/*
 * @class ThreadCloseGraceful
 * @package org.mindieda.chapter06
 * @date 2020/12/9 22:49
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindieda.chapter06;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/12/9 22:49
 * @blog https://mindidea.org
 */
public class ThreadCloseGraceful2 {

    private static class Worker extends Thread {

        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        break; // return
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        worker.interrupt();
    }
}
