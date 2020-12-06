/*
 * @class ImmutableClient
 * @package org.mindidea.chapter8
 * @date 2020/11/29 16:44
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.chapter8;

import java.util.stream.IntStream;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/29 16:44
 * @blog https://mindidea.org
 */
public class ImmutableClient {

    public static void main(String[] args) {
        Person person = new Person("Alice", "ZJ");
        IntStream.range(0, 5).forEach(i -> new UsePersonThread(person).start());
    }
}
