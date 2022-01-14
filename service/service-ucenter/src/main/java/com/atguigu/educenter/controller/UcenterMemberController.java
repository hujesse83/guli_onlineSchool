package com.atguigu.educenter.controller;


import com.atguigu.commonutils.R;

import com.atguigu.educenter.entity.vo.UserLoginVo;
import com.atguigu.educenter.service.UcenterMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@CrossOrigin
public class UcenterMemberController {
    @Autowired
    private UcenterMemberService memberService;


    // 登录
    @PostMapping
    public R loginUser(@RequestBody UserLoginVo userLoginVo){
        String token = memberService.login(userLoginVo);
        return R.ok().data("token",token);
    }



    //注册
}

