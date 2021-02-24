/*
 * @class Main
 * @package org.mindidea.algorithms.alg02_Selection
 * @date 2021/1/17 22:37
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea._02_algorithms._02_Selection;

import org.mindidea.common.Integers;

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
        Integer[] arr = Integers.random(10, 0, 100);
        for (int j : arr) {
            System.out.print(j + ", ");
        }
        System.out.println("\n--------------------------------------");
        arr = SelectionSort04.sort(arr);
        for (int j : arr) {
            System.out.print(j + ", ");
        }
    }

}
