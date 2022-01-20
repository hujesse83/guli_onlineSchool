package com.atguigu.vod.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author jesse.hu
 * @date 2022/1/11 16:18
 */
public interface VodService {
    String uploadVideo(MultipartFile file) throws IOException;

    void removeVideo(String id);

    void removeBatchVideo(List<String> videoIdList);
}
