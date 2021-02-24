/*
 * @class BubbleSort02
 * @package org.mindidea._02_algorithms.alg01_BubbleSort
 * @date 2021年2月24日 20:39
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea._02_algorithms.alg01_BubbleSort;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年2月24日 20:39
 * @blog https://mindidea.org
 */
@SuppressWarnings("all")
public class BubbleSort02 {
    public static Integer[] sort(Integer[] arr) {
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
