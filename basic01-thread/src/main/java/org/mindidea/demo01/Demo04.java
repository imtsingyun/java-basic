/*
 * @class Demo04
 * @package org.mindidea.demo01
 * @date 2020/9/26 22:48
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo01;

/**
 * 当一个线程调用共享对象的wait（）方法被阻塞挂起后，
 * 如果其他线程中断了该线程， 则该线程会抛出InterruptedException 异常并返回。
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/9/26 22:48
 */
public class Demo04 {
    static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("----------begin------------");
                    synchronized (obj) {
                        obj.wait();
                    }
                    System.out.println("----------end------------");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();

        Thread.sleep(1000);

        System.out.println("--- begin interrupt threadA ---");
        threadA.interrupt();
        System.out.println("--- end interrupt threadA ---");
    }
}
