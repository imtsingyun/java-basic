/*
 * @class DependencyInversion3
 * @package org.mindidea.principle.demo03_dependecy_inversion
 * @date 2021年3月18日 01:02
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.principle.demo03_dependecy_inversion;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年3月18日 01:02
 * @blog https://mindidea.org
 */
public class DependencyInversion3 {
    public static void main(String[] args) {
        IDriver driver = new Driver();
        driver.driver(new Benz());
        driver.driver(new BMW());
    }
}

class Driver implements IDriver {
    // 1。构造器注入依赖
//    private ICar car;
//    public Driver(ICar car) {
//        this.car = car;
//    }
//
    // 2。Setter注入依赖
//    public void setCar(ICar car) {
//        this.car = car;
//    }

    // 3。接口声明式的依赖注入
    @Override
    public void driver(ICar car) {
        car.run();
    }
}

class Benz implements ICar {
    @Override
    public void run() {
        System.out.println("Benz Car is running...");
    }
}

class BMW implements ICar {
    @Override
    public void run() {
        System.out.println("BMW Car is running...");
    }
}

interface IDriver {
    void driver(ICar car);
}

interface ICar {
    void run();
}
