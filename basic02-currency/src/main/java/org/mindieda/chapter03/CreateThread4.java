/*
 * @class CreateThread4
 * @package org.mindieda.chapter03
 * @date 2020/11/21 23:22
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindieda.chapter03;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/21 23:22
 * @blog https://mindidea.org
 */
public class CreateThread4 {

    private static int counter = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(null, new Runnable() {
            public void run() {
                try {
                    add(1);
                } catch (Error error) {
                    System.out.println(counter);
                }
            }

            private void add(int i) {
                counter++;
                add(i + 1);
            }
        }, "Test", 1 << 24);

        t1.start();
    }
}
