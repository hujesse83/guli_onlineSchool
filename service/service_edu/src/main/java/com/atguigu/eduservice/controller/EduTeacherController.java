package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.po.EduTeacher;
import com.atguigu.eduservice.entity.vo.TeacherQuery;
import com.atguigu.eduservice.mapper.EduTeacherMapper;
import com.atguigu.eduservice.service.impl.EduTeacherServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jesse.hu
 * @since 2021-12-28
 */
@RestController
@RequestMapping("/eduservice/teacher")
@Api(tags = "讲师管理")
@ApiSupport(author = "jesse.hu")  // 主要是便于找到接口拥有者
public class EduTeacherController {
    @Autowired
    public EduTeacherServiceImpl eduTeacherService;

    @Autowired
    public EduTeacherMapper eduTeacherMapper;


    @GetMapping("")
    @ApiOperation("获取所有讲师列表")
    public R findAllTeacher(){
        List<EduTeacher> list = eduTeacherService.list();
        return R.ok().data("item",list);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("逻辑删除讲师")
    @ApiImplicitParam(name = "id",value = "id",required = true)
    public R removeTeacher(@PathVariable(value = "id") String id){
       return  eduTeacherService.removeById(id)?R.ok():R.error();
    }

    @GetMapping("pageTeacher/{current}/{limit}")
    @ApiOperation("分页查询讲师")
    public R pageListTeacher(@PathVariable long current,
                             @PathVariable long limit){
        Page<EduTeacher> eduTeacherPage = new Page<>(current,limit);
        Page<EduTeacher> page = eduTeacherService.page(eduTeacherPage, null);
        List<EduTeacher> records = page.getRecords();
        long total = page.getTotal();
        return R.ok().data("rows",records).data("total",total);
    }

    @ApiOperation("多条件分页查询讲师")
    @PostMapping("pageTeacherCondition/{current}/{limit}")
    public R pageTeacherCondition(@PathVariable long current,
                                  @PathVariable long limit,
                                  @RequestBody (required = false) TeacherQuery teacherQueryVo){
        Page<EduTeacher> eduTeacherPage = new Page<>(current,limit);
        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper<>();
        String name = teacherQueryVo.getName();
        String begin = teacherQueryVo.getBegin();
        String end = teacherQueryVo.getEnd();
        Integer level = teacherQueryVo.getLevel();
        if(StringUtils.hasLength(name)){
            queryWrapper.like("name",name);
        }
        if(level!=null){
            queryWrapper.like("level",level);
        }
        if(StringUtils.hasLength(begin)){
            queryWrapper.ge("gmt_create",begin);
        }
        if(StringUtils.hasLength(begin)){
            queryWrapper.le("gmt_modified",end);
        }
        Page<EduTeacher> page = eduTeacherService.page(eduTeacherPage, queryWrapper);
        List<EduTeacher> records = page.getRecords();
        long total = page.getTotal();
        return R.ok().data("rows",records).data("total",total);
    }

    @ApiOperation("添加讲师")
    @PostMapping("/addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher){
        boolean save = eduTeacherService.save(eduTeacher);
        return save?R.ok():R.error();
    }

    @ApiOperation("通过id获取讲师")
    @GetMapping("getTeacher/{id}")
    public R getTeacher(@PathVariable String id){
        EduTeacher teacher = eduTeacherService.getById(id);
        return R.ok().data("teacher",teacher);
    }

    @ApiOperation("修改讲师")
    @PostMapping("/updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher){
        boolean save = eduTeacherService.updateById(eduTeacher);
        return save?R.ok():R.error();
    }



}

