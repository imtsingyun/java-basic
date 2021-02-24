/*
 * @class Demo
 * @package org.mindidea.basic
 * @date 20/2/2021 上午12:37
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea._01_basic;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 20/2/2021 上午12:37
 * @blog https://mindidea.org
 */
public class Demo {

    public static void main(String[] args) {
        short a = 1;
        short b = (short) (a + 1);
        short c = 1;
        c += 1;
        System.out.println(c);

        Integer i = new Integer(100);
        Integer j = new Integer(100);
        System.out.println(i == j); //false
        System.out.println(i.equals(j)); //true

        Integer i1 = new Integer(100);
        int j1 = 100;
        System.out.println(i1 == j1); //true

        Integer i2 = new Integer(100);
        Integer j2 = 100;
        System.out.println(i2 == j2); //false

        Integer i3 = 100;
        Integer j3 = 100;
        System.out.println(i3 == j3); //true
        Integer i4 = 128;
        Integer j4 = 128;
        System.out.println(i4 == j4); //false
    }
}
