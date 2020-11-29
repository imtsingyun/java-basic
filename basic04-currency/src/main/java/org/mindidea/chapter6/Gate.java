/*
 * @class Gate
 * @package org.mindidea.chapter6
 * @date 2020/11/29 14:10
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.chapter6;

/**
 * 临界值
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/29 14:10
 * @blog https://mindidea.org
 */
public class Gate {

    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    public synchronized void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        verify();
    }

    private void verify() {
        if (this.name.charAt(0) != this.address.charAt(0)) {
            System.out.println("-----------------BROKEN-------------------" + toString());
        }
    }

    public synchronized String toString() {
        return "NO." + counter + ", name=" + this.name + ", address=" + this.address;
    }
}
