/*
 * @class Main
 * @package org.mindidea.structure.demo06_二叉树
 * @date 2020/12/15 20:47
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.structure.demo06_二叉树;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/12/15 20:47
 * @blog https://mindidea.org
 */
public class Main {

    public static void main(String[] args) {
        BinarySearchTree<Integer> b1 = new BinarySearchTree<>();
        b1.add(2);
        b1.add(1);
        b1.add(3);
        System.out.println(b1);

        BinarySearchTree<Person> b2 = new BinarySearchTree<>();
        b2.add(new Person(10, "T"));
        b2.add(new Person(19, "M"));
        b2.add(new Person(8, "I"));
        System.out.println(b2);

    }

    private static class Person implements Comparable<Person> {
        private Integer age;
        private String name;

        Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            return age.compareTo(o.age);
        }
    }
}
