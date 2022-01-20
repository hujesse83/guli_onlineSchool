package com.atguigu.oss.controller;

import com.atguigu.commonutils.R;
import com.atguigu.oss.service.OssService;
import com.atguigu.oss.service.impl.OssServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/eduoss/fileoss")
@Api(tags = "阿里云文件上传")
@CrossOrigin
public class OssController {
    @Autowired
    private OssServiceImpl service;
    @PostMapping
    public R uploadOssFile(MultipartFile file){
        String path = service.uploadFileAvatar(file);
        return R.ok().data("url",path);
    }
}
