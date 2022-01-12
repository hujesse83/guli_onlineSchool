package com.atguigu.eduservice.mapStruct;

import com.atguigu.eduservice.entity.EduSubjectTree;
import com.atguigu.eduservice.entity.po.EduSubject;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-12T16:06:48+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
public class EduObjectConverterImpl implements EduObjectConverter {

    @Override
    public EduSubjectTree map(EduSubject eduSubject) {
        if ( eduSubject == null ) {
            return null;
        }

        EduSubjectTree eduSubjectTree = new EduSubjectTree();

        eduSubjectTree.setTitle( eduSubject.getTitle() );
        eduSubjectTree.setId( eduSubject.getId() );

        return eduSubjectTree;
    }

    @Override
    public List<EduSubjectTree> map(List<EduSubject> eduSubject) {
        if ( eduSubject == null ) {
            return null;
        }

        List<EduSubjectTree> list = new ArrayList<EduSubjectTree>( eduSubject.size() );
        for ( EduSubject eduSubject1 : eduSubject ) {
            list.add( map( eduSubject1 ) );
        }

        return list;
    }
}
