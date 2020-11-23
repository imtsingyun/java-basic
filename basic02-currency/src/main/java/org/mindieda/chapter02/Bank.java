/*
 * @class Bank
 * @package org.mindieda.chapter02
 * @date 2020/11/21 17:13
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindieda.chapter02;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/21 17:13
 * @blog https://mindidea.org
 */
public class Bank {

    public static void main(String[] args) {
        TicketWindow t1 = new TicketWindow("001");
        t1.start();

        TicketWindow t2 = new TicketWindow("002");
        t2.start();

        TicketWindow t3 = new TicketWindow("003");
        t3.start();
    }
}
