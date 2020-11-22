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
public class SingletonObject2 {

    private static SingletonObject2 instance;

    private SingletonObject2() {

    }

    public synchronized static SingletonObject2 getInstance() {
        if (null == instance)
            instance = new SingletonObject2();

        return instance;
    }
}
