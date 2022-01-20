package com.atguigu.staservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.staservice.entity.StatisticsDaily;
import com.atguigu.staservice.service.impl.StatisticsDailyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 网站统计日数据 前端控制器
 * </p>
 *
 * @author jesse.hu
 * @since 2022-01-19
 */
@RestController
@RequestMapping("/staservice/sta")
@CrossOrigin
public class StatisticsDailyController {

    @Autowired
    private StatisticsDailyServiceImpl statisticsDailyService;



    //TODO replace with post method
    @GetMapping("/getRegisterInfo/{begin}/{end}")
    public R getStatisticData(@PathVariable String begin,@PathVariable String end){
        Map<String, Object> resMap = statisticsDailyService.getStatisticData(begin, end);
        return R.ok().data(resMap);
    }
}

