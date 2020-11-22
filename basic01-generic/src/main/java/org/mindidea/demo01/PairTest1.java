/*
 * @class Test
 * @package org.mindidea.demo01
 * @date 2020/11/19 22:55
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo01;

import java.io.Serializable;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/19 22:55
 * @blog https://mindidea.org
 */
public class PairTest1 {

    public static void main(String[] args) {
        String[] words = {"Mary", "had", "a", "little", "lamb"};

        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());

        // 调用泛型该方法
        Integer middle = ArrayAlg.getMiddle(1, 2, 3, 4);
        System.out.println(middle);

        String s = ArrayAlg.<String>getMiddle("John", "Q", "Public");
        System.out.println(s);
    }
}

class ArrayAlg {

    /**
     * 泛型方法
     * @param a
     * @param <T> 泛型
     * @return T
     */
    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }


    /**
     * 将 T 限定为 实现了 Comparable 接口
     * @param a
     * @param <T>
     * @return
     */
    public static <T extends Comparable & Serializable> T min(T[] a) {
        if (a == null || a.length == 0)
            return null;

        T smallest = a[0];
        for (int i = 0; i < a.length; i++) {
            if (smallest.compareTo(a[i]) > 0)
                smallest = a[i];
        }

        return smallest;
    }

    public static Pair<String> minmax(String[] a) {
        String min = a[0];
        String max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0)
                min = a[i];
            if (max.compareTo(a[i]) < 0)
                max = a[i];
        }
        return new Pair<String>(min, max);
    }
}