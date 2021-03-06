/*
 * @class SelectionSor04
 * @package org.mindidea._02_algorithms.alg02_Selection
 * @date 2021年2月24日 22:17
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.algo_002SelectionSort;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年2月24日 22:17
 * @blog https://mindidea.org
 */
@SuppressWarnings("all")
public class SelectionSort04 {
    public static Integer[] sort(Integer[] arr) {
        for (int end = arr.length - 1; end > 0; end--) {
            int maxIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                // >= 能保证算法的稳定性
                // 10 10 3 9
                if (arr[maxIndex] <= arr[begin]) {
                    maxIndex = begin;
                }
            }
            int tmp = arr[maxIndex];
            arr[maxIndex] = arr[end];
            arr[end] = tmp;
        }
        return arr;
    }
}
