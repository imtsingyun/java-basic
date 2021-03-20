/*
 * @class SingletonTest3
 * @package org.mindidea.design.singleton.test3
 * @date 2021年3月20日 16:07
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.design.singleton.test4;

/**
 * 懒汉式：线程安全
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年3月20日 16:07
 * @blog https://mindidea.org
 */
public class SingletonTest4 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
    }
}

class Singleton {

    private static Singleton instance;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}