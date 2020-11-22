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
public class SingletonObject4 {

    private SingletonObject4() {}

    private static class InstanceHolder {
        private final static SingletonObject4 instance = new SingletonObject4();
    }

    public static SingletonObject4 getInstance() {
        return InstanceHolder.instance;
    }
}
