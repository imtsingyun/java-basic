/*
 * @class WaitSet
 * @package org.mindidea.chapter2
 * @date 2020/11/22 14:14
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.chapter2;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/22 14:14
 * @blog https://mindidea.org
 */
public class WaitSet {

    private static final Object LOCK = new Object();

    /**
     * 所有对象都有一个 wait set, 用来存放调用了该对象的 wait 方法后进入 block 状态线程
     * 线程被 notify 之后，不一定立即得到执行
     *
     * @param args
     */
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10).forEach(i ->
                new Thread(String.valueOf(i)) {
                    @Override
                    public void run() {
                        synchronized (LOCK) {
                            try {
                                Optional.of(Thread.currentThread().getName() + " will come to wait set")
                                        .ifPresent(System.out::println);
                                LOCK.wait();
                                Optional.of(Thread.currentThread().getName() + " will leave to wait set")
                                        .ifPresent(System.out::println);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }.start());


        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        IntStream.rangeClosed(1, 10).forEach(i -> {
            synchronized (LOCK) {
                LOCK.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
