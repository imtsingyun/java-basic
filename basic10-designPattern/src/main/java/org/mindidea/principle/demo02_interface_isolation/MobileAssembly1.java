/*
 * @class MobileAssembly
 * @package org.mindidea.principle.demo02_interface_isolation
 * @date 2021年3月17日 23:37
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.principle.demo02_interface_isolation;

import javafx.concurrent.Worker;

/**
 * 以手机组装为例，理解接口隔离原则
 * 将手机组装分为 “主板”、“CPU”、“摄像头”、“屏幕”几道工序
 *
 * MobileAssembly1 反例，没有遵循 接口隔离原则
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年3月17日 23:37
 * @blog https://mindidea.org
 */
public class MobileAssembly1 {
    public static void main(String[] args) {
        Worker1 w1 = new Worker1();
        w1.mainBoard();
        w1.cpu();
        w1.camera();
        w1.scream();

        Worker2 w2 = new Worker2();
        w2.mainBoard();
        w2.cpu();
        w2.camera();
        w2.scream();
    }
}

// worker1 需要完成手机组装的所有工序
class Worker1 implements MobileAssembly {

    @Override
    public void mainBoard() {
        System.out.println("worker1 组装主板");
    }

    @Override
    public void cpu() {
        System.out.println("worker1 组装CPU");
    }

    @Override
    public void camera() {
        System.out.println("worker1 组装摄像头");
    }

    @Override
    public void scream() {
        System.out.println("worker1 组装屏幕");
    }
}


// worker2 需要完成手机组装的所有工序
class Worker2 implements MobileAssembly {

    @Override
    public void mainBoard() {
        System.out.println("worker2 组装主板");
    }

    @Override
    public void cpu() {
        System.out.println("worker2 组装CPU");
    }

    @Override
    public void camera() {
        System.out.println("worker2 组装摄像头");
    }

    @Override
    public void scream() {
        System.out.println("worker2 组装屏幕");
    }
}

// 手机组装接口
interface MobileAssembly {
    // 组装主板
    void mainBoard();

    // 组装CPU
    void cpu();

    // 组装摄像头
    void camera();
    // 屏幕组装
    void scream();
}