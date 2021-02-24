/*
 * @class BubbleSort
 * @package org.mindidea.algorithms.alg01
 * @date 2021/1/4 21:40
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea._02_algorithms.alg01_BubbleSort;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021/1/4 21:40
 * @blog https://mindidea.org
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {56, 9, 19, 28, 37, 2, 10, 34};
        sort2(arr);
    }

    private static void sort2(int[] arr) {
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
