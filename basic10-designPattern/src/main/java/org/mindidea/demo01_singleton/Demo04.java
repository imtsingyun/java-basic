/*
 * @class Demo04
 * @package org.mindidea.demo01_singleton
 * @date 2020/11/28 21:13
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo01_singleton;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/28 21:13
 * @blog https://mindidea.org
 */
public class Demo04 {

    private Demo04() {
    }

    private static volatile Demo04 INSTANCE;

    // double check
    private Demo04 getInstance() {
        if (INSTANCE == null) {
            synchronized (Demo04.class) {
                if (null == INSTANCE) {
                    INSTANCE = new Demo04();
                }
            }
        }

        return INSTANCE;
    }
}
