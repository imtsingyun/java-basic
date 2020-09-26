/*
 * @class Demo10Interrupt
 * @package org.mindidea.demo01
 * @date 2020/9/26 23:51
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo01;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/9/26 23:51
 */
public class Demo10Interrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread() + " hello");
                }
            }
        });
        t.start();

        Thread.sleep(1000);

        System.out.println("main thread interrupt thread");
        t.interrupt();

        t.join();
        System.out.println("main is over");
    }
}
