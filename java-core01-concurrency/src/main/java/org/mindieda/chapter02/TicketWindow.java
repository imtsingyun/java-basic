/*
 * @class TicketWindow
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
public class TicketWindow extends Thread {

    private final String name;

    private static final int max = 30;

    private static int index = 1;

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= max) {
            System.out.println("NAME:" + name + ", NUM: " + (index++));
        }
    }
}
