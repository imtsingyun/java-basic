/*
 * @class Bank2
 * @package org.mindieda.chapter02
 * @date 2020/11/21 17:21
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindieda.chapter02;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/21 17:21
 * @blog https://mindidea.org
 */
public class Bank2 {

    public static void main(String[] args) {
        final TicketWindowRunnable tw1 = new TicketWindowRunnable();
        final TicketWindowRunnable tw2 = new TicketWindowRunnable();
        final TicketWindowRunnable tw3 = new TicketWindowRunnable();
        Thread t1 = new Thread(tw1, "001");
        t1.start();
        Thread t2 = new Thread(tw2, "002");
        t2.start();
        Thread t3 = new Thread(tw3, "003");
        t3.start();
    }
}

