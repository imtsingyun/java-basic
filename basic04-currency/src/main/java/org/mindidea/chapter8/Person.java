/*
 * @class Person
 * @package org.mindidea.chapter8
 * @date 2020/11/29 16:42
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.chapter8;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/11/29 16:42
 * @blog https://mindidea.org
 */
public final class Person {

    private final String name;
    private final String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
