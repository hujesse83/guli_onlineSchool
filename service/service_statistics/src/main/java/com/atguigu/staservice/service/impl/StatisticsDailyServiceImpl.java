package com.atguigu.staservice.service.impl;


import com.atguigu.staservice.client.UcenterClient;
import com.atguigu.staservice.entity.StatisticsDaily;
import com.atguigu.staservice.mapper.StatisticsDailyMapper;
import com.atguigu.staservice.service.StatisticsDailyService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 网站统计日数据 服务实现类
 * </p>
 *
 * @author jesse.hu
 * @since 2022-01-19
 */
@Service
public class StatisticsDailyServiceImpl extends ServiceImpl<StatisticsDailyMapper, StatisticsDaily> implements StatisticsDailyService {

    @Autowired
    private UcenterClient ucenterClient;

    @Override
    public void saveRegisterInfo(String day) {
        Integer count = ucenterClient.countRegister(day);

        StatisticsDaily statisticsDaily = StatisticsDaily
                .builder()
                .loginNum(RandomUtils.nextInt(100, 200))
                .videoViewNum(RandomUtils.nextInt(100, 200))
                .courseNum(RandomUtils.nextInt(100, 200))
                .registerNum(count)
                .dateCalculated(day)
                .build();
        baseMapper.insert(statisticsDaily);
    }

    @Override
    public StatisticsDaily getRegisterInfo(String day) {
        return baseMapper.getRegisterInfo(day);
    }
}
