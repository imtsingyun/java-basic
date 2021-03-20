/*
 * @class SingletonTest7
 * @package org.mindidea.design.singleton.test7
 * @date 2021年3月20日 16:37
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.design.d1singleton.test7;

/**
 * 静态内部类
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年3月20日 16:37
 * @blog https://mindidea.org
 */
public class SingletonTest7 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
    }
}

// 静态内部类特点：
// 1. 外部类加载时，不会加载内部类
// 2. 调用静态内部类的静态变量时，静态内部类会被加载，且只加载一次
class Singleton {

    private Singleton() {}

    // 静态内部类
    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
