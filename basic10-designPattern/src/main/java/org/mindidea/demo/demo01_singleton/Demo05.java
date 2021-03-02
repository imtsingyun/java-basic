/*
 * @class Demo05
 * @package org.mindidea.demo.demo01_singleton
 * @date 2020/11/28 21:35
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo.demo01_singleton;

/**
 * 线程安全，懒汉式，无锁，高效
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/28 21:35
 * @blog https://mindidea.org
 */
public class Demo05 {

    private Demo05() {
    }

    private static class InstanceHolder {
        private final static Demo05 instance = new Demo05();
    }

    public static Demo05 getInstance() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return InstanceHolder.instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> System.out.println(Demo05.getInstance().hashCode())).start();
        }
    }
}
