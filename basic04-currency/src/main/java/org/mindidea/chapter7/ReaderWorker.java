/*
 * @class ReaderWorker
 * @package org.mindidea.chapter7
 * @date 2020/11/29 16:05
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.chapter7;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/29 16:05
 * @blog https://mindidea.org
 */
public class ReaderWorker extends Thread {

    private final SharedData data;

    public ReaderWorker(SharedData data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char[] readBuf = data.read();
                System.out.println(Thread.currentThread().getName() + " reads " + String.valueOf(readBuf));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
