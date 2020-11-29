/*
 * @class ThreadLifeCycleObserver
 * @package org.mindidea.chapter4
 * @date 2020/11/29 0:37
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.chapter4;

import java.util.List;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/29 0:37
 * @blog https://mindidea.org
 */
public class ThreadLifeCycleObserver implements LifeCycleListener {

    private final Object LOCK = new Object();

    public void concurrentQuery(List<String> ids) {
        if (ids == null || ids.isEmpty()) {
            return;
        }
        ids.stream().forEach(id -> new Thread(new ObservableRunnable() {
            
        }));
    }

    @Override
    public void onEvent(ObservableRunnable.RunnableEvent event) {

    }
}
