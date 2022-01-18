package com.atguigu.eduservice.service.impl;

import com.atguigu.eduservice.entity.po.EduTeacher;
import com.atguigu.eduservice.mapper.EduTeacherMapper;
import com.atguigu.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author jesse.hu
 * @since 2021-12-28
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Override
    public Map<String, Object> getTeacherFrontList(Page<EduTeacher> pageParam) {
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        //把分页数据封装到pageTeacher对象
        Page<EduTeacher> eduTeacherPage = baseMapper.selectPage(pageParam, wrapper);

        List<EduTeacher> records = eduTeacherPage.getRecords();
        long current = eduTeacherPage.getCurrent();
        long pages = eduTeacherPage.getPages();
        long size = eduTeacherPage.getSize();
        long total = eduTeacherPage.getTotal();
        boolean hasNext = eduTeacherPage.hasNext();//下一页
        boolean hasPrevious = eduTeacherPage.hasPrevious();//上一页

        //把分页数据获取出来，放到map集合
        Map<String, Object> map = new HashMap<>();
        map.put("items", records);
        map.put("current", current);
        map.put("pages", pages);
        map.put("size", size);
        map.put("total", total);
        map.put("hasNext", hasNext);
        map.put("hasPrevious", hasPrevious);


        return map;
    }
}
