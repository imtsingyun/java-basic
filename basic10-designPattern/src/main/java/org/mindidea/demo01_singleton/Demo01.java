/*
 * @class Demo01
 * @package org.mindidea.demo01_singleton
 * @date 2020/11/28 19:53
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo01_singleton;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/28 19:53
 * @blog https://mindidea.org
 */
public class Demo01 {

    private Demo01() {}

    private static final Demo01 INSTANCE = new Demo01();

    public static Demo01 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Demo01 demo01 = Demo01.getInstance();
        Demo01 demo02 = Demo01.getInstance();
        System.out.println(demo01 == demo02);
    }
}
