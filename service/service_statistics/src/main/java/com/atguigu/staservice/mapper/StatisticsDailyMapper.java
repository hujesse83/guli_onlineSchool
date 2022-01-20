package com.atguigu.staservice.mapper;

import com.atguigu.staservice.entity.StatisticsDaily;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 网站统计日数据 Mapper 接口
 * </p>
 *
 * @author jesse.hu
 * @since 2022-01-19
 */
public interface StatisticsDailyMapper extends BaseMapper<StatisticsDaily> {

    StatisticsDaily getRegisterInfo(String day);
}
