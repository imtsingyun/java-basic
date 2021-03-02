/*
 * @class Demo02
 * @package org.mindidea.demo.demo01_singleton
 * @date 2020/11/28 19:55
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo.demo01_singleton;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/28 19:55
 * @blog https://mindidea.org
 */
public class Demo02 {

    private static final Demo02 INSTANCE;

    static {
        INSTANCE = new Demo02();
    }

    private Demo02() {}

    public static Demo02 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Demo02 demo01 = Demo02.getInstance();
        Demo02 demo02 = Demo02.getInstance();
        System.out.println(demo01 == demo02);
    }
}
