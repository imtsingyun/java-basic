/*
 * @class SingleResponsibility3
 * @package org.mindidea.principle.demo01singleResponsibility
 * @date 2021年3月17日 00:38
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.principle.demo01singleResponsibility;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年3月17日 00:38
 * @blog https://mindidea.org
 */
public class SingleResponsibility3 {
    public static void main(String[] args) {

    }
}

class Vehicle3 {
    public void run(String vehicle) {
        System.out.println(vehicle + " is running...");
    }

    public void runAir(String vehicle) {
        System.out.println(vehicle + " is running in air");
    }

    public void runWater(String vehicle) {
        System.out.println(vehicle + " is running in water");
    }
}