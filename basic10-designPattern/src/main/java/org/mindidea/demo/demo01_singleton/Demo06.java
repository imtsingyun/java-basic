/*
 * @class Demo06
 * @package org.mindidea.demo.demo01_singleton
 * @date 2020/11/28 21:51
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo.demo01_singleton;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/28 21:51
 * @blog https://mindidea.org
 */
public class Demo06 {

    private Demo06() {}

    private enum SingletonEnum {
        INSTANCE;
        private final Demo06 instance;

        SingletonEnum() {
            instance = new Demo06();
        }

        public Demo06 getInstance() {
            return instance;
        }
    }

    public static Demo06 getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> System.out.println(Demo06.getInstance().hashCode())).start();
        }

    }
}

//enum SingleObject {
//    INSTANCE;
//
//    public void test() {
//        System.out.println("this is a test function in enum");
//    }
//}
