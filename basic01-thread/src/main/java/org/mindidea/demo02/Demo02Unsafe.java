/*
 * @class Demo02Unsafe
 * @package org.mindidea.demo02
 * @date 2020/9/27 21:07
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo02;

import sun.misc.Unsafe;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/9/27 21:07
 */
public class Demo02Unsafe {
    static final Unsafe unsafe = Unsafe.getUnsafe();

    static long stateOffset;

    private volatile long state = 0;

    static {
        try {
            stateOffset = unsafe.objectFieldOffset(Demo02Unsafe.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Demo02Unsafe demo = new Demo02Unsafe();
        unsafe.compareAndSwapInt(demo, stateOffset, 0, 1);

        System.out.println("success");
    }
}
