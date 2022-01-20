package com.atguigu.vod.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.DeleteVideoResponse;
import com.atguigu.servicebase.exceptionHandler.GuliException;
import com.atguigu.vod.service.VodService;
import com.atguigu.vod.utils.ConstantVodUtils;
import com.atguigu.vod.utils.InitObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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

    @Override
    public void removeVideo(String videoId) {
        DefaultAcsClient client = InitObject.initVodClient(ConstantVodUtils.ACCESS_KEY_ID,ConstantVodUtils.ACCESS_KEY_SECRET );
        DeleteVideoResponse response;
        try {
            response = deleteVideo(client,videoId);
        } catch (Exception e) {
            throw new GuliException(20001," 删除视频失败");
        }
        log.info("RequestId = " + response.getRequestId() + "\n");
    }

    @Override
    public void removeBatchVideo(List<String> videoIdList) {
        String ids = String.join(",",videoIdList);
        System.out.println(ids);
        removeVideo(ids);
    }

    public static DeleteVideoResponse deleteVideo(DefaultAcsClient client,String videoId) throws Exception {
        DeleteVideoRequest request = new DeleteVideoRequest();
        //支持传入多个视频ID，多个用逗号分隔
        // request.setVideoIds("VideoId1,VideoId2");
        request.setVideoIds(videoId);
        return client.getAcsResponse(request);
    }
}
