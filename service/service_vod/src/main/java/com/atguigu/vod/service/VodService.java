package com.atguigu.vod.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author jesse.hu
 * @date 2022/1/11 16:18
 */
public interface VodService {
    String uploadVideo(MultipartFile file) throws IOException;
}
