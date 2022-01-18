package com.atguigu.events;

/**
 * @author jesse.hu
 * @date 2022/1/17 13:55
 */
public class GenericSpringEvent<T> {
    private final T what;
    private final boolean success;

    public GenericSpringEvent(T what, boolean success) {
        this.what = what;
        this.success = success;
    }

    public T getWhat() {
        return what;
    }

    public boolean isSuccess() {
        return success;
    }
}
