/*
 * @class TestMain
 * @package org.mindieda.chapter02.demo01
 * @date 2020/12/6 14:29
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindieda.chapter02.demo02;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/12/6 14:29
 * @blog https://mindidea.org
 */
public class TestMain {

    public static void main(String[] args) {

        // 使用 runnable 接口的好处，可以将逻辑单元从线程控制中抽离出来
        BankNumRunnable b1 = new BankNumRunnable();

        Thread t1 = new Thread(b1, "线程001");
        t1.start();
        Thread t2 = new Thread(b1, "线程002");
        t2.start();
        Thread t3 = new Thread(b1, "线程003");
        t3.start();
    }
}
