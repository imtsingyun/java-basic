/*
 * @class Singleton8
 * @package org.mindidea.design.singleton.test8
 * @date 2021年3月20日 17:14
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.design.d1singleton.test8;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年3月20日 17:14
 * @blog https://mindidea.org
 */
public class Singleton8 {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;

    }
}

enum Singleton {
    INSTANCE;

    public void sayOk() {
        System.out.println("ok");
    }
}
