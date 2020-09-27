/*
 * @class Demo01Volatile
 * @package org.mindidea.demo02
 * @date 2020/9/27 20:36
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo02;

/**
 * synchronized 独占锁，阻塞
 * volatile 非阻塞，提供可见性保证，无法保证操作的原子性，避免指令重排序
 *
 * 一下情况下考虑使用 volatile
 *  - 写入的变量值，不依赖当前值
 *  - 该变量不会与其他状态变量一起纳入不变性条件中
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/9/27 20:36
 */
public class Demo01Volatile {
    public static void main(String[] args) {

    }
}

class ThreadSafeInteger2 {

    private volatile int value;

    public int get() {
        return value;
    }

    public void set(int value) {
        this.value = value;
    }
}

class ThreadSafeInteger1 {

    private int value;

    public synchronized int get() {
        return value;
    }

    public synchronized void set(int value) {
        this.value = value;
    }
}
