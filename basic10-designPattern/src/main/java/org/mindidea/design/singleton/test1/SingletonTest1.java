/*
 * @class SingletonTest1
 * @package org.mindidea.design.singleton.test1
 * @date 2021年3月20日 11:21
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.design.singleton.test1;

/**
 * 饿汉式：静态常量，直接创建
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年3月20日 11:21
 * @blog https://mindidea.org
 */
public class SingletonTest1 {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println(instance1 == instance2);
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

class Singleton {
    // 1. 私有化构造器
    private Singleton() {}

    private final static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}
