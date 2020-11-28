/*
 * @class Observer
 * @package org.mindidea.chapter4
 * @date 2020/11/28 18:58
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.chapter4;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/28 18:58
 * @blog https://mindidea.org
 */
public abstract class Observer {

    protected Subject subject;

    public Observer(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    public abstract void update();
}
