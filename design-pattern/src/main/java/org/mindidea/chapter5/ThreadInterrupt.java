/*
 * @class ThreadInterrupt
 * @package org.mindidea.chapter5
 * @date 2020/11/22 17:56
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.chapter5;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/22 17:56
 * @blog https://mindidea.org
 */
public class ThreadInterrupt {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.isInterrupted());
        t.interrupt();
        System.out.println(t.isInterrupted());
    }
}
