package com.atguigu.eduservice.cilent;

import com.atguigu.commonutils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author jesse.hu
 * @date 2022/1/12 15:43
 * 服务降级   兜底
 */
@Component
@Slf4j
public class VodFileDegradeFeignClient implements VodClient{
    @Override
    public R removeVideo(String videoId) {
        log.error("removeVideo Error");
        return R.error().message("删除视频失败,服务降级");
    }

    @Override
    public R removeBatchVideo(List<String> videoIdList) {
        log.error("removeBatchVideo Error");
        return R.error().message("删除课程失败，服务降级");
    }
}
