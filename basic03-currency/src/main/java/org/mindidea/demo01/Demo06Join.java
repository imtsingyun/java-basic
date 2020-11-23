/*
 * @class Demo06Join
 * @package org.mindidea.demo01
 * @date 2020/9/26 23:23
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo01;

/**
 * 需要等待某几件事情完成后才能继续往下执行
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/9/26 23:23
 */
public class Demo06Join {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("child thread1 over!");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("child thread2 over!");
            }
        });

        thread1.start();
        thread2.start();

        System.out.println("wait all child thread over！");

        thread1.join();
        thread2.join();

        System.out.println("all child thread over!");
    }
}
