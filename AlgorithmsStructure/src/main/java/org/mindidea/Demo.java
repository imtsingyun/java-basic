/*
 * @class Demo
 * @package org.mindidea
 * @date 2021年2月25日 00:05
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年2月25日 00:05
 * @blog https://mindidea.org
 */
public class Demo {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("tom", 10));
        userList.add(new User("tom", 10));
        userList.add(new User("tom", 11));
        userList.add(new User("mike", 11));

        List<User> unique1 =
            userList.stream().collect(
                Collectors.collectingAndThen(
                    Collectors.toCollection(()->new TreeSet<>(Comparator.comparing(User::getName))), ArrayList::new
                )
            );

        System.out.println(unique1.size());
    }

    private static class User {
        String name;
        int age;

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
