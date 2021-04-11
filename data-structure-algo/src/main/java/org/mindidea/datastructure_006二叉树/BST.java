/*
 * @class BinarySearchTree
 * @package org.mindidea.structure.demo05_1_二叉树
 * @date 2021/1/23 18:03
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.datastructure_006二叉树;

import org.mindidea.utils.BinaryTree;

import java.util.Comparator;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021/1/23 18:03
 * @blog https://mindidea.org
 */
@SuppressWarnings(value = {"unused"})
public class BST<E> extends BinaryTree<E> {

    //<editor-fold desc="成员变量">
    private final Comparator<E> comparator;
    //</editor-fold>

    //<editor-fold desc="构造器">
    public BST() {
        this(null);
    }

    public BST(Comparator<E> comparator) {
        this.comparator = comparator;
    }
    //</editor-fold>

    //<editor-fold desc="接口：判断是否包含元素">
    public boolean contains(E element) {
        return getNode(element) != null;
    }
    //</editor-fold>

    //<editor-fold desc="接口：添加元素">

    /**
     * 添加元素
     *
     * @param element 被添加的元素
     * @return void
     * @author Tsingyun(青雲)
     * @createTime 2021/1/23 18:25
     */
    @SuppressWarnings("Duplicates")
    public void add(E element) {
        elementNotNullCheck(element);
        // 添加第一个节点
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }
        // 添加不是第一个节点
        // 1. 找到父节点
        // 2. 创建新节点
        // 3. parent.left = node 或 parent.right = node
        Node<E> node = root;
        Node<E> parent = root;
        int compare = 0;
        while (node != null) {
            compare = compare(element, node.element);
            // 记录父节点
            parent = node;
            // 新元素大于node节点
            if (compare > 0) {
                node = node.right;
            } else if (compare < 0) {
                node = node.left;
            } else {
                // 相等时替换元素，考虑自定义对象
                node.element = element;
                return;
            }
        }
        Node<E> newNode = new Node<>(element, parent);
        if (compare > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
    }

    @SuppressWarnings("Duplicates")
    public void addV2(E element) {
        elementNotNullCheck(element);
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }
        Node<E> node = root;
        int compare = 0;
        Node<E> parent = null;
        while (node != null) {
            compare = compare(element, node.element);
            parent = node;
            if (compare > 0)
                node = node.right;
            else if (compare < 0)
                node = node.left;
            else return;
        }
        Node<E> newNode = new Node<>(element, parent);
        if (compare > 0)
            parent.right = newNode;
        else
            parent.left = newNode;
        size++;
    }
    //</editor-fold>

    //<editor-fold desc="删除元素">
    public void remove(E element) {
        remove(getNode(element));
    }

    private void remove(Node<E> node) {
        if (node == null) {
            return;
        }
        size--;
        // 度为 2
        if (node.hasTwoChildren()) {
            // 前驱节点
            Node<E> p = precursor(node);
            // 使用前驱节点的值替换度为2的节点的值
            node.element = p.element;
            // 下面实际上要删除的节点是前驱节点 p
            node = p;
        }

        // 此处 node 的度必然为 0 或 1
        Node<E> replacement = node.left != null ? node.left : node.right;
        // node 度为 1
        if (replacement != null) {
            replacement.parent = node.parent;
            // node 度为 1，并且上根节点
            if (node.parent == null) {
                root = replacement;
            } else if (node == node.parent.left) {
                node.parent.left = replacement;
            } else {
                node.parent.right = replacement;
            }
        }
        // node 是叶子节点，并且是根节点
        else if (node.parent == null) {
            root = null;
        }
        // node 是叶子节点，但不是根节点
        else {
            if (node == node.parent.left) {
                node.parent.left = null;
            } else {
                node.parent.right = null;
            }
        }
    }
    //</editor-fold>

    //<editor-fold desc="元素比较">

    /**
     * 元素比较逻辑
     *
     * @param e1 参与比较的第一个元素
     * @param e2 参与比较的第二个元素
     * @return int result=0 e1=e2; result>0 e1>e2; result<0 e1<e2;
     * @author Tsingyun(青雲)
     * @createTime 2021/1/23 21:37
     */
    @SuppressWarnings("unchecked")
    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        // 使用 Java 自带比较器
        return ((Comparable<E>) e1).compareTo(e2);
    }
    //</editor-fold>

    //<editor-fold desc="根据元素获取节点">

    /**
     * 根据元素获取节点
     *
     * @param element 元素
     * @return 节点
     */
    private Node<E> getNode(E element) {
        Node<E> node = root;
        while (node != null) {
            int cmp = compare(element, node.element);
            if (cmp == 0) return node;
            if (cmp > 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return null;
    }
    //</editor-fold>

    //<editor-fold desc="元素非空检查">
    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }
    //</editor-fold>

}
