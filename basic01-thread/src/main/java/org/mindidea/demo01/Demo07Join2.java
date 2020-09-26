/*
 * @class Demo07Join2
 * @package org.mindidea.demo01
 * @date 2020/9/26 23:29
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo01;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/9/26 23:29
 */
public class Demo07Join2 {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("t1 begin run!");
                for (;;) {

                }
            }
        });

        final Thread mainThread = Thread.currentThread();

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 调用主线程的 interrupt（） 方法设置主线程的中断标志
                mainThread.interrupt();
            }
        });

        t1.start();

        t2.start();

        // 主线程调用 t1 的 join 方法阻塞自己等待线程 t1 执行完毕
        try {
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("main thread: " + e);
            e.printStackTrace();
        }
    }
}
