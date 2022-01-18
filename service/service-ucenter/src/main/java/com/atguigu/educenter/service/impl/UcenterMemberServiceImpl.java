package com.atguigu.educenter.service.impl;

import com.atguigu.commonutils.JwtUtils;
import com.atguigu.commonutils.MD5Util;
import com.atguigu.educenter.entity.em.ReportActionType;
import com.atguigu.educenter.entity.po.UcenterMember;
import com.atguigu.educenter.entity.vo.UserLoginVo;
import com.atguigu.educenter.entity.vo.UserRegisterVo;
import com.atguigu.educenter.event.UcenterActivity;
import com.atguigu.educenter.event.publisher.UcenterPublish;
import com.atguigu.educenter.mapper.UcenterMemberMapper;
import com.atguigu.educenter.service.UcenterMemberService;
import com.atguigu.educenter.utils.ConstantWxUtils;
import com.atguigu.educenter.utils.HttpClientUtils;
import com.atguigu.servicebase.exceptionHandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;

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

    @Autowired
    private UcenterPublish ucenterPublish;

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

    @Override
    public String callBack(String code, String state)  {
        //1 获取code值，临时票据，类似于验证码
        //2 拿着code请求 微信固定的地址，得到两个值 accsess_token 和 openid
        String baseAccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token" +
                "?appid=%s" +
                "&secret=%s" +
                "&code=%s" +
                "&grant_type=authorization_code";
        // 拼接三个参数 ： id 密钥 和 code值
        String accessTokenUrl = String.format(
                baseAccessTokenUrl,
                ConstantWxUtils.WX_OPEN_APP_ID,
                ConstantWxUtils.WX_OPEN_APP_SECRET,
                code
        );
        //请求这个拼接好的地址，得到返回两个值 accsess_token 和 openid
        //使用httpclient发送请求，得到返回结果
        String accessTokenInfo = "";
        try{
            accessTokenInfo = HttpClientUtils.get(accessTokenUrl);
        }catch (Exception e){
            e.printStackTrace();
        }
        Gson gson = new Gson();
        HashMap mapAccessToken = gson.fromJson(accessTokenInfo, HashMap.class);
        String access_token = (String)mapAccessToken.get("access_token");
        String openid = (String)mapAccessToken.get("openid");

        UcenterMember uc = getUcMember(openid);
        if(uc==null){
            //3 拿着得到accsess_token 和 openid，再去请求微信提供固定的地址，获取到扫描人信息
            //访问微信的资源服务器，获取用户信息
            String baseUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo" +
                    "?access_token=%s" +
                    "&openid=%s";
            //拼接两个参数
            String userInfoUrl = String.format(
                    baseUserInfoUrl,
                    access_token,
                    openid
            );
            String userInfo = "";
            try{
                userInfo = HttpClientUtils.get(userInfoUrl);
            }catch (Exception e){
                e.printStackTrace();
            }

            //获取返回userinfo字符串扫描人信息
            HashMap userInfoMap = gson.fromJson(userInfo, HashMap.class);
            String nickname = (String)userInfoMap.get("nickname");//昵称
            String headimgurl = (String)userInfoMap.get("headimgurl");//头像
             uc = UcenterMember.builder()
                    .openid(openid)
                    .nickname(nickname)
                    .avatar(headimgurl)
                    .build();
            ucenterPublish.publishUcenterEvent(
                    new UcenterActivity(1, ReportActionType.SAVE_USER,uc,new Date())
                    ,true);
        }
        // save event

        String jwtToken = JwtUtils.getJwtToken(uc.getId(), uc.getNickname());
        //最后：返回首页面，通过路径传递token字符串
        return "redirect:http://localhost:3000?token="+jwtToken;
    }

    @Override
    public UcenterMember getUcMember(String openId) {
        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("openid",openId);
        UcenterMember ucenterMember = baseMapper.selectOne(wrapper);
        return baseMapper.selectOne(wrapper);

    }

    @Override
    public boolean registerByOpenId(String openId) {
        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("openid",openId);
        UcenterMember ucenterMember = baseMapper.selectOne(wrapper);
        return ucenterMember!=null;
    }

    @Override
    public void saveWxUser(UcenterMember ucenterMember) {
        this.save(ucenterMember);
    }
}
