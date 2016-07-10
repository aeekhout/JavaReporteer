package com.eekhout.reporteer.libs.base;

/**
 * Created by Alexander on 27-06-2016.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
