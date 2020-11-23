/*
 * @class Demo03
 * @package org.mindidea.demo01
 * @date 2020/9/26 22:34
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo01;

/**
 * 当线程调用共享对象的 wait() 方法时，当前线程只会释放当前共享对象的锁，
 * 当前线程持有的其他共享对象的监视器锁并不会被释放。
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/9/26 22:34
 */
public class Demo03Wait {

    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                try {
                    // 获取 ResourceA 共享资源的监视器锁
                    synchronized (resourceA) {
                        System.out.println("threadA get resourceA lock");

                        // 获取 ResourceB 共享资源的监视器锁
                        synchronized (resourceB) {
                            System.out.println("threadA get resourceB lock");
                            // 线程A 释放 resourceA 资源的锁
                            System.out.println("threadA release resourceA lock");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);

                    // 获取资源 A 的监视器锁
                    synchronized (resourceA) {
                        System.out.println("threadB get resourceA lock");
                        System.out.println("threadB try to get resourceB lock");
                        synchronized (resourceB) {
                            System.out.println("threadB get resourceB lock");
                            System.out.println("threadB release resourceA lock");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();
        System.out.println("main over");
    }
}
