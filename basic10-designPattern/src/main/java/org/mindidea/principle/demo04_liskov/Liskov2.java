/*
 * @class Liskov
 * @package org.mindidea.principle.demo04_liskov
 * @date 2021年3月19日 21:45
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.principle.demo04_liskov;

/**
 * 里氏替换原则:
 *
 *      将原来的父类和子类都继承一个更通俗的基类，原有的继承关系去掉
 *      采用依赖、聚合、组合等关系代替
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年3月19日 21:45
 * @blog https://mindidea.org
 */
public class Liskov2 {
    public static void main(String[] args) {
        A2 a = new A2();
        System.out.println("11-3=" + a.func1(11, 3));
        System.out.println("1-8=" + a.func1(1, 8));

        System.out.println("-----------------------");
        B2 b = new B2();
        System.out.println("11-3=" + b.func1(11, 3));
        System.out.println("1-8=" + b.func1(1, 8));
        System.out.println("11+3+9=" + b.func2(11, 3));
    }

}

class Base {

}

class A2 extends Base {
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

class B2 extends Base {
    // 组合
    A2 a2 = new A2();

    // 重写父类方法
    public int func1(int a, int b) {
        return a2.func1(a, b);
    }
    public int func2(int a, int b) {
        return func1(a, b) + 9;
    }

}