/*
 * @class MobileAssembly
 * @package org.mindidea.principle.demo02_interface_isolation
 * @date 2021年3月17日 23:37
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.principle.demo02_interface_isolation;

/**
 * 以手机组装为例，理解接口隔离原则
 * 将手机组装分为 “主板”、“CPU”、“摄像头”、“屏幕”几道工序
 *
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年3月17日 23:37
 * @blog https://mindidea.org
 */
public class MobileAssembly2 {
    public static void main(String[] args) {
        WorkerA a = new WorkerA();
        a.mainBoard();

        WorkerB b = new WorkerB();
        b.cpu();

        WorkerC c = new WorkerC();
        c.camera();

        WorkerD d = new WorkerD();
        d.scream();
    }
}

class WorkerA implements Board {
    @Override
    public void mainBoard() {
        System.out.println("工人A只负责组装主板");
    }
}

class WorkerB implements Cpu {
    @Override
    public void cpu() {
        System.out.println("工人B只负责组装CPU");
    }
}

class WorkerC implements Camera {

    @Override
    public void camera() {
        System.out.println("工人C只负责组装摄像头");
    }
}

class WorkerD implements Scream {
    @Override
    public void scream() {
        System.out.println("工人D只负责组装屏幕");
    }
}
// 手机主板组装接口
interface Board {
    // 组装主板
    void mainBoard();
}

// 手机CPU组装接口
interface Cpu {
    // 组装CPU
    void cpu();
}

// 手机摄像头组装接口
interface Camera {
    // 组装摄像头
    void camera();
}

// 手机屏幕组装接口
interface Scream {
     void scream();
}