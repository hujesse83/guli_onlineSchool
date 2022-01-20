package com.atguigu.eduservice.mapStruct;

import com.atguigu.eduservice.entity.ChapterVoTree;
import com.atguigu.eduservice.entity.po.EduChapter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-19T18:10:52+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
public class EduChapterConverterImpl implements EduChapterConverter {

    @Override
    public ChapterVoTree map(EduChapter eduChapter) {
        if ( eduChapter == null ) {
            return null;
        }

        ChapterVoTree chapterVoTree = new ChapterVoTree();

        chapterVoTree.setId( eduChapter.getId() );
        chapterVoTree.setTitle( eduChapter.getTitle() );

        return chapterVoTree;
    }

    @Override
    public List<ChapterVoTree> map(List<EduChapter> eduChapterList) {
        if ( eduChapterList == null ) {
            return null;
        }

        List<ChapterVoTree> list = new ArrayList<ChapterVoTree>( eduChapterList.size() );
        for ( EduChapter eduChapter : eduChapterList ) {
            list.add( map( eduChapter ) );
        }

        return list;
    }
}
