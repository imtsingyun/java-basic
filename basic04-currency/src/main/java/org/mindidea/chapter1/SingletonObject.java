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
public class SingletonObject {

    private static SingletonObject instance;

    private SingletonObject() {

    }

    public static SingletonObject getInstance() {
        if (null == instance)
            instance = new SingletonObject();

        return instance;
    }
}
