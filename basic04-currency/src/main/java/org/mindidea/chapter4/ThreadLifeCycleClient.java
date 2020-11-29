/*
 * @class ThreadLifeCycleClient
 * @package org.mindidea.chapter4
 * @date 2020/11/29 11:11
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.chapter4;

import java.util.Arrays;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/29 11:11
 * @blog https://mindidea.org
 */
public class ThreadLifeCycleClient {
    public static void main(String[] args) {
        new ThreadLifeCycleObserver().concurrentQuery(Arrays.asList("1", "2", "3", "4"));
    }
}
