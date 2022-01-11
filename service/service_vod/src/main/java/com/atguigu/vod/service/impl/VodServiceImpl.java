package com.atguigu.vod.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.atguigu.vod.service.VodService;
import com.atguigu.vod.utils.ConstantVodUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author jesse.hu
 * @date 2022/1/11 16:18
 */

@Service
@Slf4j
public class VodServiceImpl implements VodService {
    @Override
    public String uploadVideo(MultipartFile file) {
        InputStream inputStream = null;
        try {
            String fileName = file.getOriginalFilename();
            System.out.println(fileName);
            //title：上传之后显示名称
            assert fileName != null;
            String title = fileName.substring(0, fileName.lastIndexOf(".")); // 重名也不影响、Vod会生成唯一Id
            System.out.println(
                    title
            );
            //inputStream：上传文件输入流
            inputStream = file.getInputStream();
            UploadStreamRequest request = new UploadStreamRequest(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET, title, fileName, inputStream);

            UploadVideoImpl uploader = new UploadVideoImpl();
            UploadStreamResponse response = uploader.uploadStream(request);
            String id = "";
            if (response.isSuccess()) {
                System.out.print("VideoId=" + response.getVideoId() + "\n");
                id = response.getVideoId();
            } else { //如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因
                id = response.getVideoId();
                log.error("VideoId=" + response.getVideoId() + "\n");
                log.error("ErrorCode=" + response.getCode() + "\n");
                log.error("ErrorMessage=" + response.getMessage() + "\n");
            }
            inputStream.close();
            return id;
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return "";
    }
}
