/*
 * @class Demo08Wait
 * @package org.mindidea.demo01
 * @date 2020/9/26 23:38
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/9/26 23:38
 */
public class Demo08Wait {

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                lock.lock();
                try {
                    System.out.println("child t1 is in sleep");
                    Thread.sleep(10000);
                    System.out.println("child t1 is in awaked");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                lock.lock();
                try {
                    System.out.println("child t2 is in sleep");
                    Thread.sleep(10000);
                    System.out.println("child t2 is in awaked");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
