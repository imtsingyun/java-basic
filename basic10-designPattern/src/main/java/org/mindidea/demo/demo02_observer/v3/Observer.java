/*
 * @class Observer
 * @package org.mindidea.demo.demo02_observer.v3
 * @date 2020/11/29 12:17
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo.demo02_observer.v3;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/29 12:17
 * @blog https://mindidea.org
 */
public interface Observer {
    public abstract void update(NumberGenerator generator);
}
