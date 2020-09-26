/*
 * @class Demo05
 * @package org.mindidea.demo01
 * @date 2020/9/26 23:10
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo01;

/**
 * notify（） 和notifyAll（） 方法的具体含义及一些需要注意的地方
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/9/26 23:10
 */
public class Demo05Notify {

    private static volatile Object resourceA = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                synchronized (resourceA) {
                    System.out.println("threadA get resourceA lock");
                    try {
                        System.out.println("threadA begin wait");
                        resourceA.wait();
                        System.out.println("threadA end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            public void run() {
                synchronized (resourceA) {
                    System.out.println("threadB get resourceA lock");
                    try {
                        System.out.println("threadB begin wait");
                        resourceA.wait();
                        System.out.println("threadB end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            public void run() {
                synchronized (resourceA) {
                    System.out.println("threadC begin notify");
                    //
//                    resourceA.notify();

                    //
                    resourceA.notifyAll();
                }
            }
        });

        threadA.start();
        threadB.start();

        Thread.sleep(1000);
        threadC.start();

        // 等待线程结束
        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println("main over");
    }
}
