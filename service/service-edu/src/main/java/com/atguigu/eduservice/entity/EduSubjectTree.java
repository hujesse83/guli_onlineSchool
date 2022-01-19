package com.atguigu.eduservice.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EduSubjectTree {
    private String id;
    private String title;
    private List<EduSubjectTree> children;

    public EduSubjectTree() {
        this.children = new ArrayList<>();
    }
}
