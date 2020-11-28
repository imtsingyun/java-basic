/*
 * @class Demo03
 * @package org.mindidea.demo01_singleton
 * @date 2020/11/28 20:57
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo01_singleton;

/**
 * 单例模式：懒汉式，线程不安全
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/28 20:57
 * @blog https://mindidea.org
 */
public class Demo03 {

    private static Demo03 INSTANCE;

    private Demo03() {
    }

    public static Demo03 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Demo03();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Demo03.getInstance().hashCode())).start();
        }
    }
}
