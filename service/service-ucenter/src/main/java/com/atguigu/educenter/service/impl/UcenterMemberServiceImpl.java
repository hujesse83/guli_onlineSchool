package com.atguigu.educenter.service.impl;

import com.atguigu.commonutils.JwtUtils;
import com.atguigu.commonutils.MD5Util;
import com.atguigu.educenter.entity.po.UcenterMember;
import com.atguigu.educenter.entity.vo.UserLoginVo;
import com.atguigu.educenter.entity.vo.UserRegisterVo;
import com.atguigu.educenter.mapper.UcenterMemberMapper;
import com.atguigu.educenter.service.UcenterMemberService;
import com.atguigu.educenter.utils.ConstantWxUtils;
import com.atguigu.servicebase.exceptionHandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.net.URLEncoder;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author jesse.hu
 * @since 2022-01-14
 */
@Service
@Slf4j
public class UcenterMemberServiceImpl extends ServiceImpl<UcenterMemberMapper, UcenterMember> implements UcenterMemberService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public String login(UserLoginVo userLoginVo) {
        String mobile = userLoginVo.getMobile();
        String password = userLoginVo.getPassword();
        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)){
            throw new GuliException(20001,"登录失败");
        }

        /** spring 自导MD5
        String encrypt = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
         但是我们使用md5 + salt.
         */
        // String encryptPwdMd5 = MD5Util.MD5(password);

        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile",mobile);
        wrapper.eq("is_disabled",0);
        UcenterMember user = baseMapper.selectOne(wrapper); // 这里必要要构造函数才能接受到
        if(user==null){
            throw new GuliException(20001,"登录失败");
        }
        String dataBasePassWord = user.getPassword();
        if (!MD5Util.verify(password,dataBasePassWord)){
            throw new GuliException(20001,"密码错误");
        }
        // 登录成功
        return JwtUtils.getJwtToken(user.getId(),user.getNickname());
    }

    @Override
    public void register(UserRegisterVo registerVo) {
        String code = registerVo.getCode(); //验证码
        String mobile = registerVo.getMobile(); //手机号
        String nickname = registerVo.getNickname(); //昵称
        String password = registerVo.getPassword(); //密码

        // 先拿redis缓存判断是有讲究的、 不然查数据库验证高并发受不了
        String redisCode = redisTemplate.opsForValue().get(mobile);
        if (!code.equals(redisCode)){
            throw new GuliException(20001,"验证码不正确");
        }

        // 判断手机号是否重复
        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile",mobile);
        Long count = baseMapper.selectCount(wrapper);
        if (count>0){
            throw new GuliException(20001,"手机号已经存在");
        }

        UcenterMember ucenterMember = UcenterMember.builder().mobile(mobile).
                nickname(nickname).
                password(MD5Util.generate(password)).
                avatar("https://imgconvert.csdnimg.cn/aHR0cDovL3AzLnBzdGF0cC5jb20vbGFyZ2UvcGdjLWltYWdlLzg1MGExZWQxZTFiYTQxNjdhOGZiMmZhYjBiMzQyZjlm")
                .build();

        baseMapper.insert(ucenterMember);

    }

    @Override
    public String generateWxCode() {
        String baseUrl = "https://open.weixin.qq.com/connect/qrconnect" +
                "?appid=%s" +
                "&redirect_uri=%s" +
                "&response_type=code" +
                "&scope=snsapi_login" +
                "&state=%s" +
                "#wechat_redirect";

        //对redirect_url进行URLEncoder编码
        String redirectUrl = ConstantWxUtils.WX_OPEN_REDIRECT_URL;
        try {
            redirectUrl = URLEncoder.encode(redirectUrl, "utf-8");
        }catch(Exception ignored) {
        }

        //设置%s里面值
        String url = String.format(
                baseUrl,
                ConstantWxUtils.WX_OPEN_APP_ID,
                redirectUrl,
                "atguigu"
        );

        //重定向到请求微信地址里面
        return "redirect:"+url;
    }
}
