package com.atguigu.eduservice.controller.front;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.service.impl.IndexFrontServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jesse.hu
 * @date 2022/1/13 15:07
 * @LeetCodeNo
 */
@RestController
@RequestMapping("/eduservice/indexfront")
@CrossOrigin
public class IndexFrontController {

    @Autowired
    private IndexFrontServiceImpl indexFrontService;
    //查询前8条热门课程，查询前4条名师
    @GetMapping("/index")
    public R index() {
        return indexFrontService.getIndexData();
    }
}
