/*
 * @class Demo02
 * @package org.mindidea.demo01
 * @date 2020/9/26 21:34
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo01;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/9/26 21:34
 */
public class Demo02 {

    private static final int MAX_SIZE = 10;
    static final Queue<String> queue = new ArrayBlockingQueue<String>(MAX_SIZE);

    public static void main(String[] args) {
        MyThread1 task1 = new MyThread1();
        new Thread(task1).start();
        MyThread2 task2 = new MyThread2();
        new Thread(task2).start();
    }

    public static class MyThread1 implements Runnable {

        public void run() {
            while (true) {
                final long l = System.currentTimeMillis();
                final int i = (int)( l % 10000);
                producer("" + i);
                System.out.println("生产者生产元素：" + i );
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        // 生产者
        void producer(String ele) {
            synchronized (queue) {
                // 队列满，则等待队列空闲
                while (queue.size() == MAX_SIZE) {
                    try {
                        // 挂起当前线程，释放 queue 上的锁，从而消费者可以获取该锁
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 空闲时则添加元素，并通知消费者线程
                queue.add(ele);
                queue.notifyAll();
            }
        }
    }

    public static class MyThread2 implements Runnable {

        public void run() {
            while (true) {
                String customer = customer();
                System.out.println("消费者获取元素：" + customer);
                try {
                    Thread.sleep(1500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public String customer() {
            synchronized (queue) {
                while (queue.size() == 0) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                String poll = queue.poll();
                queue.notifyAll();
                return poll;
            }
        }
    }
}