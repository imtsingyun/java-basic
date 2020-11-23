/*
 * @class SingletonObject
 * @package org.mindidea.chapter1
 * @date 2020/11/22 13:41
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.chapter1;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/22 13:41
 * @blog https://mindidea.org
 */
public class SingletonObject3 {

    private static volatile SingletonObject3 instance;

    private SingletonObject3() {

    }

    // double check
    // 1. 单利模式
    // 2. 懒加载
    // 3. 线程安全
    public static SingletonObject3 getInstance() {
        if (null == instance) {
            synchronized (SingletonObject3.class) {
                if (null == instance) {
                    instance = new SingletonObject3();
                }
            }
        }

        return instance;
    }
}
