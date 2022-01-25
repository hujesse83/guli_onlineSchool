package com.atguigu.eduservice.mapStruct;

import com.atguigu.eduservice.entity.ChapterVoTree;
import com.atguigu.eduservice.entity.po.EduVideo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-25T13:36:45+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
public class EduVideoConverterImpl implements EduVideoConverter {

    @Override
    public ChapterVoTree map(EduVideo eduVideo) {
        if ( eduVideo == null ) {
            return null;
        }

        ChapterVoTree chapterVoTree = new ChapterVoTree();

        chapterVoTree.setId( eduVideo.getId() );
        chapterVoTree.setTitle( eduVideo.getTitle() );
        chapterVoTree.setVideoSourceId( eduVideo.getVideoSourceId() );

        return chapterVoTree;
    }

    @Override
    public List<ChapterVoTree> map(List<EduVideo> eduVideoList) {
        if ( eduVideoList == null ) {
            return null;
        }

        List<ChapterVoTree> list = new ArrayList<ChapterVoTree>( eduVideoList.size() );
        for ( EduVideo eduVideo : eduVideoList ) {
            list.add( map( eduVideo ) );
        }

        return list;
    }
}
