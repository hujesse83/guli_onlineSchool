package com.atguigu.staservice.schedule;

import com.atguigu.staservice.service.impl.StatisticsDailyServiceImpl;
import com.atguigu.staservice.utils.CronStatement;
import com.atguigu.staservice.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author jesse.hu
 * @date 2022/1/19 17:19
 */
@Slf4j
@Component
public class DailyMemberStatistics {

    @Autowired
    private StatisticsDailyServiceImpl statisticsDailyService;

    static {
        log.info("DailyMemberStatistics tasks with async begins");
    }

    @Scheduled(cron = CronStatement.DAILY)
    @Async("schedule-pool")  // 指定线程池的名称
    public void registerTask() {
        log.info(Thread.currentThread().getName() + " begin to anync tasks");
        String today = DateUtils.parseDateToStr("yyyy-MM-dd", new Date());
        statisticsDailyService.saveRegisterInfo(today);
    }
}
