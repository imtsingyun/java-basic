/*
 * @class CreateThread2
 * @package org.mindieda.chapter03
 * @date 2020/12/6 18:13
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindieda.chapter03;

import java.util.Arrays;

/**
 * ThreadGroup
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/12/6 18:13
 * @blog https://mindidea.org
 */
public class CreateThread2 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        ThreadGroup threadGroup = t.getThreadGroup();
        int i = threadGroup.activeCount();
        System.out.println(i);

        /* output:
                Thread[main,5,main]
                Thread[Monitor Ctrl-Break,5,main]
                Thread[Thread-0,5,main]
         */
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);

        Arrays.stream(threads).forEach(System.out::println);

    }
}
