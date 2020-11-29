/*
 * @class BinaryObserver
 * @package org.mindidea.chapter4
 * @date 2020/11/28 19:14
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.chapter4.design;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/28 19:14
 * @blog https://mindidea.org
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
    }
}
