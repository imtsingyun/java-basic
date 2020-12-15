/*
 * @class ThreadJoin
 * @package org.mindieda.chapter05
 * @date 2020/12/9 22:41
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindieda.chapter05;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/12/9 22:41
 * @blog https://mindidea.org
 */
public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            IntStream.range(1, 100)
                    .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
        });



        Thread t2 = new Thread(() -> {
            IntStream.range(1, 100)
                    .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
        });

        t1.start();
        t2.start();
        /*
         * 主线程等待 t1 和 t1 结束后再运行
         */
        t1.join();
        t2.join(100);

        Optional.of("All of tasks finish done.").ifPresent(System.out::println);

        IntStream.range(1, 100)
                .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
    }
}
