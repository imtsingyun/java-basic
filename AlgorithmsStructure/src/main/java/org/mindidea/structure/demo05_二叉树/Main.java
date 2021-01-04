/*
 * @class Main
 * @package org.mindidea.structure.demo06_二叉树
 * @date 2020/12/15 20:47
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.structure.demo05_二叉树;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/12/15 20:47
 * @blog https://mindidea.org
 */
public class Main {

    public static void main(String[] args) {
        BinarySearchTree<Integer> b1 = new BinarySearchTree<>();
        b1.add(5);
        b1.add(3);
        b1.add(7);
        b1.add(6);
        b1.add(2);
        b1.add(4);
        b1.postorder();
//        b1.inorder();
//        b1.levelOrder();
//        System.out.println(b1.height());
//        b1.printTree();
//        b1.invertTree();
//        b1.printTree();

        System.out.println();
        BinarySearchTree<Person> b2 = new BinarySearchTree<>();
        b2.add(new Person(10, "T"));
        b2.add(new Person(19, "M"));
        b2.add(new Person(8, "I"));
//        b2.preorder();

    }

    private static class Person implements Comparable<Person> {
        private Integer age;
        private String name;

        Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Person o) {
            return age.compareTo(o.age);
        }
    }
}
