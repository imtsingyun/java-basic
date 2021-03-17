/*
 * @class SingleResponsibility2
 * @package org.mindidea.principle.demo01singleResponsibility
 * @date 2021年3月17日 00:35
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.principle.demo01singleResponsibility;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年3月17日 00:35
 * @blog https://mindidea.org
 */
public class SingleResponsibility2 {
    public static void main(String[] args) {

    }
}

// 遵守了单一职责原则
class RoadVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + " in running on road.");
    }
}

class AirVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + " in running in air.");
    }
}