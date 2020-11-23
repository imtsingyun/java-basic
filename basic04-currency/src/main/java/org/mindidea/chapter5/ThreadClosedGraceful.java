/*
 * @class ThreadClosedGraceful
 * @package org.mindidea.chapter5
 * @date 2020/11/22 18:36
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.chapter5;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/22 18:36
 * @blog https://mindidea.org
 */
public class ThreadClosedGraceful {

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker.shutdown();
    }


    private static class Worker extends Thread {

        private volatile boolean start = true;

        @Override
        public void run() {
            while (start) {

            }
        }

        public void shutdown() {
            this.start = false;
        }
    }
}
