/*
 * @class TryConcurrency
 * @package org.mindieda.chapter01
 * @date 2020/11/21 16:35
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindieda.chapter01;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/21 16:35
 * @blog https://mindidea.org
 */
public class TryConcurrency {

    public static void main(String[] args) {

        Thread t1 = new Thread() {
            @Override
            public void run() {
                readFromDataBase();
            }
        };
        t1.setName("MyThread");
        t1.start();

        writeDataToFile();
    }

    private static void readFromDataBase() {
        // read data from database and handle it
        try {
            println("Begin read data from db");
            Thread.sleep(10000 * 10);
            println("Read data done and start handle it");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        println("The data handle finish and successfully");
    }

    private static void writeDataToFile() {
        try {
            println("Begin write data to file");
            Thread.sleep(1000 * 10);
            println("Write data done and start handle it");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        println("The data handle finish and successfully");
    }

    private static void println(String message) {
        System.out.println(message);
    }
}