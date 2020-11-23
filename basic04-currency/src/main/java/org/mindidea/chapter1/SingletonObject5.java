/*
 * @class SingletonObject5
 * @package org.mindidea.chapter1
 * @date 2020/11/22 14:05
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.chapter1;

import java.util.stream.IntStream;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/22 14:05
 * @blog https://mindidea.org
 */
public class SingletonObject5 {
    private SingletonObject5() {}

    private enum Singleton {

        INSTANCE;

        private final SingletonObject5 instance;
        Singleton() {
            instance = new SingletonObject5();
        }

        public SingletonObject5 getInstance() {
            return instance;
        }
    }

    public static SingletonObject5 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100).forEach(i -> new Thread(String.valueOf(i)) {
            @Override
            public void run() {
                System.out.println(SingletonObject5.getInstance());
            }
        });
    }
}
