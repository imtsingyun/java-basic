/*
 * @class BubbleSort07
 * @package org.mindidea._02_algorithms._01_BubbleSort
 * @date 2021年3月2日 21:57
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.algo_001BubbleSort;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年3月2日 21:57
 * @blog https://mindidea.org
 */
@SuppressWarnings("all")
public class BubbleSort07 {
    public static void sort(Integer[] numbers) {
        for (int end = numbers.length - 1; end >=0; end--) {
            int lastChanged = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (numbers[begin] < numbers[begin-1]) {
                    int tmp = numbers[begin];
                    numbers[begin] = numbers[begin - 1];
                    numbers[begin - 1] = tmp;
                    lastChanged = begin;
                }
            }
            end = lastChanged;
        }
    }
}
