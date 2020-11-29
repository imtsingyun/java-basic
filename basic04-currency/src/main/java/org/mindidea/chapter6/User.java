/*
 * @class User
 * @package org.mindidea.chapter6
 * @date 2020/11/29 14:14
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.chapter6;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/29 14:14
 * @blog https://mindidea.org
 */
public class User extends Thread {

    private final String name;
    private final String address;
    private final Gate gate;

    public User(String name, String address, Gate gate) {
        this.name = name;
        this.address = address;
        this.gate = gate;
    }

    @Override
    public void run() {
        System.out.println(name + " Begin");
        while (true) {
            this.gate.pass(name, address);
        }
    }
}
