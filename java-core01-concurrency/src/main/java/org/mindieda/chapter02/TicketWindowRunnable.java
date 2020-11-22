/*
 * @class TicketWindowRunnable
 * @package org.mindieda.chapter02
 * @date 2020/11/21 17:20
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindieda.chapter02;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/21 17:20
 * @blog https://mindidea.org
 */
public class TicketWindowRunnable implements Runnable {

    private int index = 0;

    private final static int max = 50;

    public void run() {
        while (index <= max) {
            System.out.println(Thread.currentThread() + " 的号码是：" + (index++));
        }
    }
}
