package com.atguigu.eduservice.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChapterVoTree {
    private String id;
    private String title;

    private String videoSourceId;
    // 小节
    List<ChapterVoTree> children;

    public ChapterVoTree() {
        children = new ArrayList<>();
    }
}
