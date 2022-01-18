package com.atguigu.educenter.event.publisher;

import com.atguigu.educenter.event.UcenterActivity;
import com.atguigu.educenter.event.UcenterEvent;
import com.atguigu.events.GenericSpringEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author jesse.hu
 * @date 2022/1/17 11:52
 */
@Component
@Slf4j
public class UcenterPublish {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishUcenterEvent(final UcenterActivity activity, boolean success){
        log.debug("Publishing audience activity event: {}, success: {}", activity, success);
        final GenericSpringEvent<UcenterActivity> ucenterEvent = new UcenterEvent(activity, success);
        applicationEventPublisher.publishEvent(ucenterEvent);
    }
}
