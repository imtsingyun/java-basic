/*
 * @class Main
 * @package org.mindidea.structure.demo05_1_二叉树
 * @date 2021/1/23 21:48
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.datastructure_006二叉树;

import org.mindidea.utils.printer.BinaryTrees;

import java.util.Comparator;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021/1/23 21:48
 * @blog https://mindidea.org
 */
@SuppressWarnings("Duplicates")
public class Main {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3
        };
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (Integer integer : arr) {
            bst.add(integer);
        }
        BinaryTrees.println(bst);

        System.out.println("=========================================================");
        bst.levelOrderTraversal(new BinarySearchTree.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.print("-" + element);
                return element == 8;
            }
        });
        System.out.println();
        System.out.println("=========================================================");


        BinarySearchTree<Student> bst2 = new BinarySearchTree<>();
        bst2.add(new Student(15, 100, "tim2"));
        bst2.add(new Student(11, 99, "tim3"));
        bst2.add(new Student(12, 109, "tim1"));
        BinaryTrees.println(bst2);
        System.out.println("=========================================================");

        BinarySearchTree<Student> bst3 =
                new BinarySearchTree<>(Comparator.comparingInt(o -> o.age));
        bst3.add(new Student(15, 100, "tim2"));
        bst3.add(new Student(11, 99, "tim3"));
        bst3.add(new Student(12, 109, "tim1"));
        BinaryTrees.println(bst3);
    }

    private static class Student implements Comparable<Student> {
        int age;
        int score;
        String name;

        public Student(int age, int score, String name) {
            this.age = age;
            this.score = score;
            this.name = name;
        }

        @Override
        public int compareTo(Student o) {
            return score - o.score;
        }

        @Override
        public String toString() {
            return name + ":" + age + ":" + score;
        }
    }
}
