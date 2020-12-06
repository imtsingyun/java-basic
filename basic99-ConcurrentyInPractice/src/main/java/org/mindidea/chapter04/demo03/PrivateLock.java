/*
 * @class PrivateLock
 * @package org.mindidea.chapter04.demo03
 * @date 2020/12/6 13:47
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.chapter04.demo03;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/12/6 13:47
 * @blog https://mindidea.org
 */
public class PrivateLock {

    private final Object myLock = new Object();

    Widget widget;

    void somMethod() {
        // 通过私有锁保护状态
        synchronized (myLock) {

        }
    }
}

class Widget {

}
