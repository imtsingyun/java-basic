/*
 * @class BinarySearchTree
 * @package org.mindidea.structure.demo06_二叉树
 * @date 2020/12/15 19:57
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.structure.demo06_二叉树;

import org.w3c.dom.NodeList;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Stack;

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

    /**
     * 前序遍历：root -> left -> right
     *
     * @author Tsingyun(青雲)
     * @createTime 2020/12/15 21:34
     */
    public void preorder() {
        preorder(root);
    }

    /**
     * 递归遍历
     *
     * @author Tsingyun(青雲)
     * @createTime 2020/12/16 18:24
     */
    private void preorder(Node<E> node) {
        if (node == null) return;
        System.out.print(node.element + ", ");
        preorder(node.left);
        preorder(node.right);
    }

    /**
     * 前序 非递归遍历
     *
     * @author Tsingyun(青雲)
     * @createTime 2020/12/16 18:24
     */
    private void preorder2(Node<E> node) {
        if (node == null) return;
        Stack<Node<E>> stack = new Stack<>();
        stack.add(node);
        while (!stack.isEmpty()) {
            Node<E> topNode = stack.pop();

            System.out.print(topNode.element + ", ");

            if (topNode.right != null) {
                stack.add(topNode.right);
            }

            if (topNode.left != null) {
                stack.add(topNode.left);
            }
        }
    }

    /**
     * 中序遍历
     *
     * @author Tsingyun(青雲)
     * @createTime 2020/12/15 21:34
     */
    public void inorder() {
        inorder2(root);
    }

    private void inorder(Node<E> node) {
        if (node == null) return;
        inorder(node.left);
        System.out.println(node.element);
        inorder(node.right);
    }

    private void inorder2(Node<E> node) {
        Stack<Node<E>> stack = new Stack<>();
        Node<E> p = node;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.add(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                System.out.print(p.element + ",");
                p = p.right;
            }
        }
    }

    /**
     * 后序遍历
     *
     * @author Tsingyun(青雲)
     * @createTime 2020/12/15 21:34
     */
    public void postorder() {

    }

    /**
     * 层序遍历
     *
     * @author Tsingyun(青雲)
     * @createTime 2020/12/15 21:34
     */
    public void levelOrder() {

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
