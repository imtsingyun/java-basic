/*
 * @class PairTest2
 * @package org.mindidea.demo01
 * @date 2020/11/19 23:29
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo01;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/19 23:29
 * @blog https://mindidea.org
 */
public class PairTest2 {

    public static void main(String[] args) {

    }

    public static void printBuddies(Pair<? extends Employee> e) {

    }
}

class ArrayAlg1 {
    public static <T extends Comparable> Pair<T> minmax(T[] a) {
        if (a == null || a.length == 0)
            return null;

        T min = a[0];
        T max = a[0];

        for (int i = 0; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<T>(min, max);
    }
}
