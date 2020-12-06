/*
 * @class Counter
 * @package org.mindidea.chapter04.demo01
 * @date 2020/12/3 23:27
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.chapter04.demo01;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/12/3 23:27
 * @blog https://mindidea.org
 */
public class Counter {

    // value 构成类的状态
    private long value = 0;

    public synchronized long getValue() {
        return value;
    }

    public synchronized long increment() {
        if (value == Long.MAX_VALUE) {
            throw new IllegalStateException("counter overflow");
        }
        return ++value;
    }
}
