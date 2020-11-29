/*
 * @class Client
 * @package org.mindidea.chapter6
 * @date 2020/11/29 14:16
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.chapter6;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/29 14:16
 * @blog https://mindidea.org
 */
public class Client {

    public static void main(String[] args) {
        Gate gate = new Gate();
        User bj = new User("B", "Beijing", gate);
        User hz = new User("H", "Hangzhou", gate);
        User gz = new User("G", "Guangzhou", gate);

        bj.start();
        hz.start();
        gz.start();
    }
}
