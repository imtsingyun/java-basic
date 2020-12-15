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
public class ThreadCloseGraceful {

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

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        worker.shutdown();
    }
}
