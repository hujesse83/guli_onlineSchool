package com.atguigu.educenter.service.impl;

import com.atguigu.commonutils.JwtUtils;
import com.atguigu.commonutils.MD5Util;
import com.atguigu.educenter.entity.po.UcenterMember;
import com.atguigu.educenter.entity.vo.UserLoginVo;
import com.atguigu.educenter.mapper.UcenterMemberMapper;
import com.atguigu.educenter.service.UcenterMemberService;
import com.atguigu.servicebase.exceptionHandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
        UcenterMember user = baseMapper.selectOne(wrapper);
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
}
