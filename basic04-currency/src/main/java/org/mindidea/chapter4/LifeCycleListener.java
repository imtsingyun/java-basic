/*
 * @class LifeCycleListener
 * @package org.mindidea.chapter4
 * @date 2020/11/29 0:37
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.chapter4;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/29 0:37
 * @blog https://mindidea.org
 */
public interface LifeCycleListener {
    void onEvent(ObservableRunnable.RunnableEvent event);
}
