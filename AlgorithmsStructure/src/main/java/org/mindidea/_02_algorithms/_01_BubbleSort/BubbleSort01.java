/*
 * @class BubbleSort
 * @package org.mindidea._02_algorithms.alg01_BubbleSort
 * @date 2021年2月24日 20:10
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea._02_algorithms._01_BubbleSort;

/**
 * 冒泡排序
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年2月24日 20:10
 * @blog https://mindidea.org
 */
@SuppressWarnings("all")
public class BubbleSort01 {
    public static Integer[]  sort(Integer[] arr) {
        for (int end = arr.length - 1; end > 0; end--) {
            int lastChangeIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (arr[begin] < arr[begin - 1]) {
                    int tmp = arr[begin];
                    arr[begin] = arr[begin - 1];
                    arr[begin - 1] = tmp;
                    lastChangeIndex = begin;
                }
            }
            end = lastChangeIndex;
        }
        return arr;
    }
}
