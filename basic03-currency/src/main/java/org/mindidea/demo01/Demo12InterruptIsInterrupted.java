/*
 * @class Demo12InterruptIsInterrupted
 * @package org.mindidea.demo01
 * @date 2020/9/27 0:03
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo01;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/9/27 0:03
 */
public class Demo12InterruptIsInterrupted {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (;;) {

                }
            }
        });

        t1.start();

        t1.interrupt();
        // 获取 t1 中断标志
        System.out.println("isInterrupted: " + t1.isInterrupted());

        // 获取 主线程 中断标志并重置
        System.out.println("isInterrupted: " + t1.interrupted());
        // 获取 主线程 中断标志并重置
        System.out.println("isInterrupted: " + Thread.interrupted());

        System.out.println("isInterrupted: " + t1.isInterrupted());

        t1.join();
    }
}
