/*
 * @class Integers
 * @package org.mindidea.common
 * @date 2021/1/5 0:17
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.utils;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021/1/5 0:17
 * @blog https://mindidea.org
 */
public class Integers {

    public static Integer[] random(int count, int min, int max) {
        if (count <=0 || min > max) return null;
        Integer[] array = new Integer[count];
        int delta = max - min + 1;
        for (int i = 0; i < count; i++) {
            array[i] = min + (int)(Math.random() * delta);
        }
        return array;
    }

    public void isSort(Integer[] nums) {

    }
}
