/*
 * @class Liskov
 * @package org.mindidea.principle.demo04_liskov
 * @date 2021年3月19日 21:45
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.principle.demo04_liskov;

import org.w3c.dom.ls.LSOutput;

/**
 * 里氏替换原则
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年3月19日 21:45
 * @blog https://mindidea.org
 */
public class Liskov {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("11-3=" + a.func1(11, 3));
        System.out.println("1-8=" + a.func1(1, 8));

        System.out.println("-----------------------");
        B b = new B();
        System.out.println("11-3=" + b.func1(11, 3));
        System.out.println("1-8=" + b.func1(1, 8));
        System.out.println("11+3+9=" + b.func2(11, 3));
    }

}

class A {
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

class B extends A {
    // 重写父类方法
    public int func1(int a, int b) {
        return a + b;
    }
    public int func2(int a, int b) {
        return func1(a, b) + 9;
    }
}