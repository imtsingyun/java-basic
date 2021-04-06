/*
 * @class SelectionSort05
 * @package org.mindidea._02_algorithms._02_Selection
 * @date 2021年2月25日 20:42
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.algo_002SelectionSort;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年2月25日 20:42
 * @blog https://mindidea.org
 */
@SuppressWarnings("all")
public class SelectionSort05 {
    public static void sort(Integer[] nums) {
        for (int end = nums.length - 1; end > 0; end--) {
            int maxIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (nums[begin] >= nums[maxIndex]) {
                    maxIndex = begin;
                }
            }
            int tmp = nums[maxIndex];
            nums[maxIndex] = nums[end];
            nums[end] = tmp;
        }
    }
}
