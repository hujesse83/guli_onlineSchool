package com.atguigu.educenter.controller;

import com.atguigu.educenter.service.UcenterMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jesse.hu
 * @date 2022/1/15 16:49
 */

@CrossOrigin
@Controller  //只是请求地址，不需要返回数据. 重定向不需要json数据啊
@RequestMapping("/api/ucenter/wx")
public class WxApiController {
    @Autowired
    private UcenterMemberService memberService;

    //1 生成微信扫描二维码
    @GetMapping("/login")
    public String getWxCode() {
       return memberService.generateWxCode();
    }
}
