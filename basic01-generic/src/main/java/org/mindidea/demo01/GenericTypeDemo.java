/*
 * @class GenericTypeDemo
 * @package org.mindidea.demo01
 * @date 2020/11/20 23:48
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/20 23:48
 * @blog https://mindidea.org
 */
public class GenericTypeDemo {

    public static void main(String[] args) {
        // 带 Integer 类型的泛型
        List<Integer> list1 = new ArrayList<>();
        list1.add(123);

        // 不带 泛型的集合
        List list2;
        // 泛型被擦除
        list2 = list1;
        list2.add("ABC");

        String integer = String.valueOf(list1.get(1));
        System.out.println(integer);
        List<String> list3;
        list3 = list2;
        // ERROR:  java.lang.Integer cannot be cast to java.lang.String
//        System.out.println(list3.get(0));
    }
}
