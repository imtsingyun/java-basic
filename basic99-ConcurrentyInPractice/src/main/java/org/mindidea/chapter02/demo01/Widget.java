/*
 * @class Widget
 * @package org.mindidea.chapter02.demo01
 * @date 2020/11/30 23:54
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.chapter02.demo01;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/30 23:54
 * @blog https://mindidea.org
 */
public class Widget {
    public synchronized void doSomething() {

    }
}

class LoggingWidget extends Widget {

    @Override
    public synchronized void doSomething() {
        System.out.println(toString() + ": calling dosomething");
        super.doSomething();
    }
}
