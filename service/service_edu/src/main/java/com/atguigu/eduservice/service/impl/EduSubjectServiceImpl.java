package com.atguigu.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.atguigu.eduservice.entity.EduSubjectTree;
import com.atguigu.eduservice.entity.excel.SubjectData;
import com.atguigu.eduservice.entity.po.EduSubject;
import com.atguigu.eduservice.listener.SubjectExcelListener;
import com.atguigu.eduservice.mapStruct.EduObjectConverter;
import com.atguigu.eduservice.mapper.EduSubjectMapper;
import com.atguigu.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author jesse.hu
 * @since 2022-01-02
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public void saveSubject(MultipartFile file) {
        InputStream in = null;
        try{
            in = file.getInputStream();
            EasyExcel.read(in, SubjectData.class,new SubjectExcelListener(this)).sheet().doRead();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<EduSubjectTree> getAllOneTwoSubject() {
        QueryWrapper<EduSubject> wrapperOne = new QueryWrapper<>();
        wrapperOne.eq("parent_id","0");
        List<EduSubject> oneSubjectList = baseMapper.selectList(wrapperOne);

        QueryWrapper<EduSubject> wrapperTwo = new QueryWrapper<>();
        wrapperTwo.ne("parent_id","0");
        List<EduSubject> twoSubjectList = baseMapper.selectList(wrapperTwo);

        List<EduSubjectTree> finalSubjectList = new ArrayList<>();

        for (EduSubject eduSubject : oneSubjectList) { //遍历oneSubjectList集合
            EduSubjectTree oneSubject = EduObjectConverter.INSTANCE.map(eduSubject);
            finalSubjectList.add(oneSubject);
            List<EduSubjectTree> twoFinalSubjectList = new ArrayList<>();
            for (EduSubject tSubject : twoSubjectList) {
                if (tSubject.getParentId().equals(eduSubject.getId())) {
                    EduSubjectTree twoSubject = EduObjectConverter.INSTANCE.map(tSubject);
                    twoFinalSubjectList.add(twoSubject);
                }
            }
            oneSubject.setChildren(twoFinalSubjectList);
        }
        return finalSubjectList;
    }

}
