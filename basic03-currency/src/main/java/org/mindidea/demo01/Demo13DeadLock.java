/*
 * @class Demo13DeadLock
 * @package org.mindidea.demo01
 * @date 2020/9/27 0:16
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo01;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/9/27 0:16
 */
public class Demo13DeadLock {

    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                // 获取 ResourceA 共享资源的监视器锁
                synchronized (resourceA) {
                    System.out.println(Thread.currentThread() + " get resourceA");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + " waiting to get resourceB");
                    synchronized (resourceB) {
                        System.out.println(Thread.currentThread() + " get resourceB");
                    }
                }
            }
        });

//        Thread t2 = new Thread(new Runnable() {
//            public void run() {
//                synchronized (resourceB) {
//                    System.out.println(Thread.currentThread() + " get resourceB");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread() + " waiting to get resourceA");
//                    synchronized (resourceA) {
//                        System.out.println(Thread.currentThread() + " get resourceA");
//                    }
//                }
//            }
//        });
        // 何资源的有序分配会避免死锁
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                synchronized (resourceA) {
                    System.out.println(Thread.currentThread() + " get resourceB");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + " waiting to get resourceA");
                    synchronized (resourceB) {
                        System.out.println(Thread.currentThread() + " get resourceA");
                    }
                }
            }
        });

        t1.start();
        t2.start();

    }

}
