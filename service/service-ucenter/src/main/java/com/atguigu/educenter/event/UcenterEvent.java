package com.atguigu.educenter.event;

import com.atguigu.events.GenericSpringEvent;

/**
 * @author jesse.hu
 * @date 2022/1/17 10:17
 */
public class UcenterEvent extends GenericSpringEvent<UcenterActivity> {

    public UcenterEvent(final UcenterActivity what, boolean success) {
        super(what, success);
    }
}
