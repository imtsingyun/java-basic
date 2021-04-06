/*
 * @class BubbleSort
 * @package org.mindidea.algorithms.alg01
 * @date 2021/1/4 21:40
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.algo_001BubbleSort;

import org.mindidea.utils.Integers;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021/1/4 21:40
 * @blog https://mindidea.org
 */
@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        Integer[] arr = Integers.random(10, 0, 100);
        for (int j : arr) {
            System.out.print(j + ", ");
        }
        System.out.println("\n========================");
        BubbleSort07.sort(arr);
        for (int j : arr) {
            System.out.print(j + ", ");
        }
    }

    private static void sort(Integer[] arr) {
        for (int end = arr.length - 1; end > 0; end--) {
            // 最后一次比较的位置，该位置后面的元素都是有序的
            int lastExchangeIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (arr[begin] < arr[begin - 1]) {
                    int tmp = arr[begin];
                    arr[begin] = arr[begin - 1];
                    arr[begin - 1] = tmp;
                    lastExchangeIndex = begin;
                }
            }
            end = lastExchangeIndex;
        }

        for (int j : arr) {
            System.out.print(j + ", ");
        }
    }
}
