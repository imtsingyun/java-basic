/*
 * @class BubbleSort06
 * @package org.mindidea._02_algorithms._01_BubbleSort
 * @date 2021年2月25日 20:15
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea._02_algorithms._01_BubbleSort;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年2月25日 20:15
 * @blog https://mindidea.org
 */
@SuppressWarnings("all")
public class BubbleSort06 {
    public static void sort(Integer[] nums) {
        for (int end = nums.length - 1; end > 0; end--) {
            int lastChangeIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (nums[begin - 1] > nums[begin]) {
                    int tmp = nums[begin];
                    nums[begin] = nums[begin - 1];
                    nums[begin - 1] = tmp;
                    lastChangeIndex = begin;
                }
            }
            end = lastChangeIndex;
        }
    }
}
