/*
 * @class BankNum
 * @package org.mindieda.chapter02.demo01
 * @date 2020/12/6 14:28
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindieda.chapter02.demo02;

/**
 * 银行叫号
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/12/6 14:28
 * @blog https://mindidea.org
 */
public class BankNumRunnable implements Runnable {

    private int index = 1;

    private static final int MAX = 10;

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println(Thread.currentThread().getName() + ", 当前号码为：" + (index++));
        }
    }
}
