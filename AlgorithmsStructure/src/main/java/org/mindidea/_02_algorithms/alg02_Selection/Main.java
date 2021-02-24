/*
 * @class Main
 * @package org.mindidea.algorithms.alg02_Selection
 * @date 2021/1/17 22:37
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea._02_algorithms.alg02_Selection;

/**
 * 选择排序：每次选择最大的元素和最后一个元素交换位置
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021/1/17 22:37
 * @blog https://mindidea.org
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {56, 9, 19, 28, 37, 2, 10, 34};

        sort1(arr);
    }

    private static void sort1(int[] arr) {
        for (int end = arr.length - 1; end > 0; end--) {
            int maxIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (arr[begin] >= arr[maxIndex]) {
                    maxIndex = begin;
                }
            }
            int tmp = arr[maxIndex];
            arr[maxIndex] = arr[end];
            arr[end] = tmp;
        }

        for (int j : arr) {
            System.out.print(j + ", ");
        }
    }
}
