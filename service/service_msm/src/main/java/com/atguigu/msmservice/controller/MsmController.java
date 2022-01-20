package com.atguigu.msmservice.controller;

import com.atguigu.commonutils.R;
import com.atguigu.msmservice.service.impl.MsmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author jesse.hu
 * @date 2022/1/14 10:45
 */

@RestController
@RequestMapping("/edumsm/msm")
public class MsmController {

    @Autowired
    private MsmServiceImpl msmService;

    @GetMapping("/send/{phone}")
    public R sendMsm(@PathVariable String phone){
        // 我们生成验证码的值, 阿里云负责发送
        boolean b = msmService.sendMsm(phone);
        return b?R.ok():R.error();
    }
}
