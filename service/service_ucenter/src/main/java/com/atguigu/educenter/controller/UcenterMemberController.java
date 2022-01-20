package com.atguigu.educenter.controller;


import com.atguigu.commonutils.JwtUtils;
import com.atguigu.commonutils.R;

import com.atguigu.educenter.entity.po.UcenterMember;
import com.atguigu.educenter.entity.vo.UserLoginVo;
import com.atguigu.educenter.entity.vo.UserRegisterVo;
import com.atguigu.educenter.mapstruct.UcenterMemberConverter;
import com.atguigu.educenter.service.UcenterMemberService;
import com.atguigu.servicebase.entity.UcenterMemberOrder;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author jesse.hu
 * @since 2022-01-14
 */
@RestController
@RequestMapping("/educenter/member")
public class UcenterMemberController {
    @Autowired
    private UcenterMemberService memberService;


    // 登录
    @PostMapping("/login")
    public R loginUser(@RequestBody UserLoginVo userLoginVo){
        String token = memberService.login(userLoginVo);
        return R.ok().data("token",token);
    }

    //注册
    @PostMapping("/register")
    public R registerUser(@RequestBody @Validated UserRegisterVo registerVo) {
        memberService.register(registerVo);
        return R.ok();
    }

    // 根据token获取用户信息
    @GetMapping("/getMemberInfo")
    public R getMemberInfo(HttpServletRequest request){
        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        // 获得用户id 和头像
        UcenterMember member = memberService.getById(memberId);
        return R.ok().data("userInfo",member);
    }
    @GetMapping("/getUserInfo/{userId}")
    public UcenterMemberOrder getUserById(@PathVariable("userId") String userId){
        UcenterMember ucenterMember = memberService.getById(userId);
        UcenterMemberOrder ucenterMemberOrder = new UcenterMemberOrder();
        BeanUtils.copyProperties(ucenterMember,ucenterMemberOrder);
        return ucenterMemberOrder;
    }

    @GetMapping("/countRegister/{day}")
    public Integer countRegister(@PathVariable String day){
        return memberService.countRegisterDay(day);
    }
}

