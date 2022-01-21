package com.atguigu.staservice.service.impl;


import com.atguigu.staservice.client.UcenterClient;
import com.atguigu.staservice.entity.StatisticsDaily;
import com.atguigu.staservice.mapper.StatisticsDailyMapper;
import com.atguigu.staservice.service.StatisticsDailyService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    // 前端为null, 传过来就是 "null"  就是这么奇怪
    @Override
    public Map<String, Object> getStatisticData(String begin, String end) {
        QueryWrapper<StatisticsDaily> wrapper = new QueryWrapper<>();
        if (StringUtils.isBlank(begin) && StringUtils.isNotBlank(end)){
            wrapper.le("date_calculated",end);
        }else if(StringUtils.isBlank(end) && StringUtils.isNotBlank(begin)){
            wrapper.ge("date_calculated",begin);
        }else if (StringUtils.isNotBlank(end) && StringUtils.isNotBlank(begin)){
            wrapper.between("date_calculated",begin,end);
        }
        wrapper.select("date_calculated","login_num","register_num","video_view_num","course_num");
        wrapper.orderByAsc("date_calculated");   // 升序
        List<StatisticsDaily> dailyList = baseMapper.selectList(wrapper);
        List<String> dailyTimeList = dailyList.stream().map(StatisticsDaily::getDateCalculated).collect(Collectors.toList());
        List<Integer> courseNum = dailyList.stream().map(StatisticsDaily::getCourseNum).collect(Collectors.toList());
        List<Integer> loginNum = dailyList.stream().map(StatisticsDaily::getLoginNum).collect(Collectors.toList());
        List<Integer> viewNum = dailyList.stream().map(StatisticsDaily::getVideoViewNum).collect(Collectors.toList());
        List<Integer> registerNum = dailyList.stream().map(StatisticsDaily::getRegisterNum).collect(Collectors.toList());
        HashMap<String, Object> map = new HashMap<>();
        map.put("dailyTimeList",dailyTimeList);
        map.put("courseNum",courseNum);
        map.put("loginNum",loginNum);
        map.put("viewNum",viewNum);
        map.put("registerNum",registerNum);
         return map;
    }
}
