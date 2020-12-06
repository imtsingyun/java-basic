/*
 * @class BankNumThread
 * @package org.mindieda.chapter02.demo01
 * @date 2020/12/6 16:06
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindieda.chapter02.demo01;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/12/6 16:06
 * @blog https://mindidea.org
 */
public class BankNumThread extends Thread {

    private int index = 1;

    private static final int MAX = 20;

    public BankNumThread(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println(Thread.currentThread().getName() + "，当前号码为：" + (index++));
        }
    }
}
