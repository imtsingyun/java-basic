/*
 * @class Demo09Yield
 * @package org.mindidea.demo01
 * @date 2020/9/26 23:43
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo01;

/**
 * 当一个线程调用yield 方法时，实际就是在暗示
 * 线程调度器当前线程请求让出自己的CPU 使用，但是线程调度器可以无条件忽略这个暗示
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/9/26 23:43
 */
public class Demo09Yield {

    public static void main(String[] args) {
        new YieldTest();
        new YieldTest();
        new YieldTest();
    }
}

class YieldTest implements Runnable {

    YieldTest() {
        Thread t = new Thread(this);
        t.start();
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            if ((i % 5) == 0) {
                System.out.println(Thread.currentThread() + " yield cpu...");
                // 当前线程让出 cup 执行权，放弃时间片，进行下一轮调度
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread() + " is over");
    }
}
