/*
 * @class NoVisibility
 * @package org.mindidea.chapter03
 * @date 2020/12/1 0:33
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.chapter03;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/12/1 0:33
 * @blog https://mindidea.org
 */
public class NoVisibility {

    private static boolean ready;

    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 100;
        ready = true;
    }
}
