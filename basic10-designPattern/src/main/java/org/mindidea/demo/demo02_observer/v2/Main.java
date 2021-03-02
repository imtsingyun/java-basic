/*
 * @class Main
 * @package org.mindidea.demo.demo02_observer.v2
 * @date 2020/11/29 0:19
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo.demo02_observer.v2;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/29 0:19
 * @blog https://mindidea.org
 */
public class Main {
    public static void main(String[] args) {
        Child c = new Child();
        c.wakeUp();
    }
}

class Child {
    private boolean cry = false;
    private Dad d = new Dad();

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;
        d.feed();
    }
}

class Dad {
    public void feed() {
        System.out.println("dad feeding...");
    }
}
