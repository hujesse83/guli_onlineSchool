package com.atguigu.staservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.staservice.entity.DailyQueryVo;
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
public class StatisticsDailyController {

    @Autowired
    private StatisticsDailyServiceImpl statisticsDailyService;



    //TODO replace with post method DONE
    @PostMapping("/getRegisterInfo")
    public R getStatisticData(@RequestBody DailyQueryVo dailyQueryVo){
        Map<String, Object> resMap = statisticsDailyService.getStatisticData(dailyQueryVo.getBegin(), dailyQueryVo.getEnd());
        R data = R.ok().data(resMap);
        return data;
    }
}

