package com.atguigu.eduservice.cilent;

import com.atguigu.commonutils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author jesse.hu
 * @date 2022/1/12 13:39
 * 原理: 根据服务名称可以得到服务注册里面的ip+端口,再拼接下面的Delete 请求,就可以完整的定位到里面的方法了
 */

@FeignClient(value = "service-vod",fallback = VodFileDegradeFeignClient.class)
@Component
public interface VodClient {
    String EDU_VOD = "/eduvod/video";
    // 根据小节Id删除视频
    @DeleteMapping(EDU_VOD+"/remove/{videoId}")
    public R removeVideo(@PathVariable("videoId") String videoId);  // PathVariable必须指定参数


    // 根据视频Id删除视频
    @DeleteMapping(EDU_VOD+"/remove-batch")
    public R removeBatchVideo(@RequestParam("videoIdList") List<String> videoIdList);

}
