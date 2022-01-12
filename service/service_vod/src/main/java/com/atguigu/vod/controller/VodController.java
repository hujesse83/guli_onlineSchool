package com.atguigu.vod.controller;

import com.atguigu.commonutils.R;
import com.atguigu.vod.service.impl.VodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author jesse.hu
 * @date 2022/1/11 16:17
 */

@RestController
@RequestMapping("/eduvod/video")
@CrossOrigin
public class VodController {
    @Autowired
    private VodServiceImpl vodService;

    @PostMapping("/uploadVideo")
    public R upload (MultipartFile file){
        String videoId = vodService.uploadVideo(file);
        return R.ok().data("videoId",videoId);
    }

    // delete video by specific videoId
    @DeleteMapping("/remove/{videoId}")
    public R removeVideo(@PathVariable String videoId){
        vodService.removeVideo(videoId);
        return R.ok();
    }

    // delete batch video
    @DeleteMapping("/remove-batch")
    public R removeBatchVideo(@RequestBody List<String> videoIdList){
        System.out.println("==============videoIdList");
        System.out.println(videoIdList);
        vodService.removeBatchVideo(videoIdList);
        return R.ok();
    }
}
