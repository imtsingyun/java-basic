/*
 * @class PersonSet
 * @package org.mindidea.chapter04.demo02
 * @date 2020/12/6 13:40
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.chapter04.demo02;

import java.util.HashSet;
import java.util.Set;

/**
 * 通过封闭机制确保线程安全
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/12/6 13:40
 * @blog https://mindidea.org
 */
public class PersonSet {

    private final Set<Person> mySet = new HashSet<Person>();

    public synchronized void addPerson(Person person) {
        mySet.add(person);
    }

    public synchronized boolean containsPerson(Person person) {
        return mySet.contains(person);
    }
}

class Person {

}