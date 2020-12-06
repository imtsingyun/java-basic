/*
 * @class UsePersonThread
 * @package org.mindidea.chapter8
 * @date 2020/11/29 16:43
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.chapter8;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/29 16:43
 * @blog https://mindidea.org
 */
public class UsePersonThread extends Thread {

    private Person person;

    public UsePersonThread(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " print " + person.toString());
        }
    }
}
