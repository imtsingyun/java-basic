/*
 * @class Demo11Interrupt2
 * @package org.mindidea.demo01
 * @date 2020/9/26 23:58
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo01;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/9/26 23:58
 */
public class Demo11Interrupt2 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("t1 begin sleep for 2000s");
                    Thread.sleep(200000000);
                    System.out.println("t1 awaking");
                } catch (InterruptedException e) {
                    System.out.println("t1 is interrupted while a sleeping");
                    return;
                }
                System.out.println("t1 leaving normally");
            }
        });
        t1.start();

        Thread.sleep(1000);

        t1.interrupt();

        t1.join();

        System.out.println("main is over");
    }
}
