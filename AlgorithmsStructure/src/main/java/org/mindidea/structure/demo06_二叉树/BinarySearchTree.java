/*
 * @class BinarySearchTree
 * @package org.mindidea.structure.demo06_二叉树
 * @date 2020/12/15 19:57
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.structure.demo06_二叉树;

import java.util.Comparator;

/**
 * 二叉搜索树
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/12/15 19:57
 * @blog https://mindidea.org
 */
public class BinarySearchTree<E> {

    private int size;

    private Node<E> root;
    private Comparator<E> comparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {

    }

    public void add(E element) {
        // 检查 element 是否为空
        elementNotNullCheck(element);
        // 第一个节点
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }

        // 查找节点插入的位置
        Node<E> node = root;
        Node<E> parent = null;
        int compare = 0;
        while (node != null) {
            compare = compare(element, node.element);
            parent = node;
            if (compare > 0) {
                node = node.right;
            } else if (compare < 0) {
                node = node.left;
            } else {
                return;
            }
        }
        // 插入新节点
        Node<E> newNode = new Node<>(element, parent);
        if (compare > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }

        size++;
    }

    private void findPosition(E element) {

    }

    @SuppressWarnings("unchecked")
    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        // Comparable 必须可比较
        return ((Comparable<E>) e1).compareTo(e2);
    }

    public void remove(E element) {

    }

    public boolean contains(E element) {
        return false;
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("Element must not be null.");
        }
    }

    private static class Node<E> {
        E element;
        Node<E> parent;
        Node<E> left;
        Node<E> right;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }
}
