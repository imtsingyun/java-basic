/*
 * @class SingleResponsibility1
 * @package org.mindidea.principle.demo01singleResponsibility
 * @date 2021年3月17日 00:32
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.principle.demo01singleResponsibility;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年3月17日 00:32
 * @blog https://mindidea.org
 */
public class SingleResponsibility1 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("摩托车");
        vehicle.run("飞机");
        vehicle.run("汽车");
        vehicle.run("轮船");
    }
}

// 交通工具类
// 方式1：违反了单一职责原则
class Vehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + " is running...");
    }
}
