package com.atguigu.staservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.staservice.entity.StatisticsDaily;
import com.atguigu.staservice.service.impl.StatisticsDailyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getRegisterInfo/{day}")
    public R getRegisterInfo(@PathVariable String day){
        StatisticsDaily statisticsDaily = statisticsDailyService.getRegisterInfo(day);
        return R.ok().data("dailyDate",statisticsDaily);
    }
}

