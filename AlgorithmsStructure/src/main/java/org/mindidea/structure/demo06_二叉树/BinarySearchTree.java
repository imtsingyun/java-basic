/*
 * @class BinarySearchTree
 * @package org.mindidea.structure.demo06_二叉树
 * @date 2020/12/15 19:57
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.structure.demo06_二叉树;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
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
            if (p != null) {
                stack.add(p);
                p = p.left;
            } else {
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
        postorder1(root);
    }

    private void postorder(Node<E> node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.element);
    }

    private void postorder1(Node<E> node) {
        if (node == null) {
            return;
        }
        Node<E> prev = null; // 上一次打印的元素
        Node<E> p = node;
        Stack<Node<E>> stack = new Stack<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.add(p);
                p = p.left;
            } else {
                // 先从栈顶取出元素，如果不满足if条件，则再次入桟
                p = stack.pop();
                // 如果p的右节点为空，或者==prev，则弹出p，并打印
                if (p.right == null || p.right == prev) {
                    System.out.print(p.element + ", ");
                    prev = p;
                    p = null;
                } else {
                    // 将栈顶的元素重新添加到栈中
                    stack.add(p);
                    p = p.right;
                }
            }
        }
    }

    private void postorder2(Node<E> node) {
        if (node == null) return;
        Stack<Node<E>> stack = new Stack<>();
        Node<E> p = node;
        Node<E> prev = null;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.add(p);
                p = p.left;
            }
            p = stack.pop();
            if (p.right == null || p.right == prev) {
                System.out.print(p.element + ", ");
                prev = p;
                p = null;
            } else {
                stack.add(p);
                p = p.right;
            }
        }
    }

    /**
     * 层序遍历
     *
     * @author Tsingyun(青雲)
     * @createTime 2020/12/15 21:34
     */
    public void levelOrder() {
        levelOrder(root);
    }

    private void levelOrder(Node<E> node) {
        if (node == null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node<E> poll = queue.poll();
            System.out.println(poll.element);
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
    }

    public int height() {
        return height2(root);
    }

    private int height1(Node<E> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height1(node.left), height1(node.right));
    }

    private int height2(Node<E> node) {
        if (node == null) return 0;
        int height = 0;
        // 每 一层元素个数
        int levelSize = 1;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node<E> poll = queue.poll();
            levelSize--;
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
            // 即将访问下一层
            if (levelSize == 0) {
                levelSize = queue.size();
                height++;
            }
        }
        return height;
    }

    // 翻转二叉树
    public void invertTree() {
        invertTree(root);
    }

    private void invertTree(Node<E> node) {
        if (node == null) return;

        Stack<Node<E>> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node<E> pop = stack.pop();
            Node<E> temp = pop.left;
            pop.left = pop.right;
            pop.right = temp;
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    public void printTree() {
        printTree(root);
    }

    private void printTree(Node<E> node) {
        if (node == null) return;
        int levelSize = 1;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node<E> poll = queue.poll();
            levelSize--;
            System.out.print(poll.element + ", ");
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
            // 即将访问下一层
            if (levelSize == 0) {
                levelSize = queue.size();
                System.out.println();
            }
        }
    }

    /**
     * 前驱节点
     *
     * @author Tsingyun(青雲)
     * @createTime 2020/12/19 14:36
     */
    public Node<E> predecessor(Node<E> node) {
        // predecessorNode = node.left.right.right.right...
        if (node == null) {
            return null;
        }
        if (node.left != null) {
            Node<E> p = node.left;
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }
        return null;
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
