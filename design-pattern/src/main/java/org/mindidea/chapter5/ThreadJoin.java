/*
 * @class ThreadJoin
 * @package org.mindidea.chapter5
 * @date 2020/11/22 17:19
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.chapter5;

import java.util.stream.IntStream;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/22 17:19
 * @blog https://mindidea.org
 */
public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() ->
                IntStream.rangeClosed(1, 10)
                        .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i)));

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            IntStream.rangeClosed(1, 10).forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
        });

        t1.start();
        t2.start();

        // join 方法是相对于当前线程（main）的，而不是 t1 和 t2 之间的
        // main 线程会等待这两个都结束后才会执行
        t1.join();
        t2.join();

        IntStream.rangeClosed(1, 10).forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
    }
}
