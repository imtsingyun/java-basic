/*
 * @class DeamonThread
 * @package org.mindieda.chapter04
 * @date 2020/12/9 21:52
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindieda.chapter04;

/**
 * 守护线程
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/12/9 21:52
 * @blog https://mindidea.org
 */
public class DaemonThread {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " running");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.setDaemon(true);
        t.start();
        System.out.println(Thread.currentThread().getName());
    }
}
