/*
 * @class SingletonTest6
 * @package org.mindidea.design.singleton.test5
 * @date 2021年3月20日 16:32
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.design.d1singleton.test5;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年3月20日 16:32
 * @blog https://mindidea.org
 */
public class SingletonTest6 {
}

class Singleton {

    private static volatile Singleton instance;

    private Singleton() {}

    // double check
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
