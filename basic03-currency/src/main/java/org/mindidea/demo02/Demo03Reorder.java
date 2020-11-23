/*
 * @class Demo03Reorder
 * @package org.mindidea.demo02
 * @date 2020/9/27 21:18
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo02;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/9/27 21:18
 */
public class Demo03Reorder {

    static class ReadThread extends Thread {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                if (ready) {
                    System.out.println(num + num);
                }
                System.out.println("read thread...");
            }
        }
    }

    public static class WriteThread extends Thread {
        @Override
        public void run() {
            num = 2;
            ready = true;
            System.out.println("writeThread set over...");
        }
    }

    private static int num = 0;
    private static boolean ready = false;

    public static void main(String[] args) throws InterruptedException {
        ReadThread rt = new ReadThread();
        rt.start();

        WriteThread wt = new WriteThread();
        wt.start();

        Thread.sleep(10);
        rt.interrupt();
        System.out.println("main exit");
    }
}

