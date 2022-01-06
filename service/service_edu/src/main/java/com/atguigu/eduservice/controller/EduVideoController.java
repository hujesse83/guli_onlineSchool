package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.po.EduVideo;
import com.atguigu.eduservice.service.impl.EduVideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author jesse.hu
 * @since 2022-01-03
 */
@RestController
@RequestMapping("/eduservice/video")
@CrossOrigin
public class EduVideoController {
    @Autowired
    private EduVideoServiceImpl eduVideoService;

    @PostMapping("/addVideo")
    public R addVideo(@RequestBody EduVideo eduVideo){
        eduVideoService.save(eduVideo);
        return R.ok();
    }

    // TODO 后面这个方法需要完善：删除小节时候，同时把里面视频给删掉
    @DeleteMapping("/delete/{videoId}")
    public R deleteVideo(@PathVariable String videoId){
        eduVideoService.removeById(videoId);
        return R.ok();
    }

    @PostMapping("/updateVideo")
    public R updateVideo(@RequestBody EduVideo eduVideo){
        eduVideoService.updateById(eduVideo);
        return R.ok();
    }

    @GetMapping("/{videoId}")
    public R getVideo(@PathVariable String videoId){
        EduVideo video = eduVideoService.getById(videoId);
        return R.ok().data("video",video);
    }



}

