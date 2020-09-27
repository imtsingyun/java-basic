/*
 * @class Demo14ThreadLocal
 * @package org.mindidea.demo01
 * @date 2020/9/27 0:28
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo01;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/9/27 0:28
 */
public class Demo14ThreadLocal01 {

    static void print(String str) {
        // 打印当前线程本地内存中 localVariable 变量的值
        System.out.println(str + ": " + localVariable.get());
        // 清除当前线程本地内存中的 localVariable 变量
//        localVariable.remove();
    }

    static ThreadLocal<String> localVariable = new ThreadLocal<String>();

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                localVariable.set("t1 local var");
                print("t1");
                System.out.println("t1 remove after" + ": " + localVariable);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                localVariable.set("t2 local var");
                print("t2");
                System.out.println("t2 remove after" + ": " + localVariable);
            }
        });

        t1.start();
        t2.start();
    }
}
