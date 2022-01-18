package com.atguigu.educenter.controller;

import com.atguigu.educenter.service.UcenterMemberService;
import com.atguigu.educenter.utils.ConstantWxUtils;
import com.atguigu.educenter.utils.HttpClientUtils;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

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

    //2、生成callback函数
    @GetMapping("/callback")
    public String callBack(String code,String state) throws Exception {
        // 把扫码人信息加入到数据库
        // 数据库是否存在相同信息  这里接触耦合 使用spring event事件
        return memberService.callBack(code,state);
    }
}
