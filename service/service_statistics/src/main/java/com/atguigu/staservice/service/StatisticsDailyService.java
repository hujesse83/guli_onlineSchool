package com.atguigu.staservice.service;

import com.atguigu.staservice.entity.StatisticsDaily;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 网站统计日数据 服务类
 * </p>
 *
 * @author jesse.hu
 * @since 2022-01-19
 */
public interface StatisticsDailyService extends IService<StatisticsDaily> {

    void saveRegisterInfo(String day);

    StatisticsDaily getRegisterInfo(String day);
}
