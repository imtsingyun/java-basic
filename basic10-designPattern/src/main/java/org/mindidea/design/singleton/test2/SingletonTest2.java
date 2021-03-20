/*
 * @class SingletonTest2
 * @package org.mindidea.design.singleton.test2
 * @date 2021年3月20日 14:23
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.design.singleton.test2;

/**
 * 饿汉式：静态代码块中初始化
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年3月20日 14:23
 * @blog https://mindidea.org
 */
public class SingletonTest2 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
    }
}

class Singleton {

    private static Singleton instance;

    // 1. 私有化构造器
    private Singleton() {}

    static {
        instance = new Singleton();
    }

    public static Singleton getInstance() {
        return instance;
    }
}