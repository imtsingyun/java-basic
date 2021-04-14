package org.mindidea.datastructure_007AVL树;

import org.mindidea.utils.printer.BinaryTreeInfo;

import java.util.Comparator;

public class AVLTree<E> implements BinaryTreeInfo {

    //<editor-fold desc="成员变量">
    private int size;
    private Node<E> root;
    private final Comparator<E> comparator;
    //</editor-fold>

    //<editor-fold desc="构造器">
    public AVLTree() {
        this(null);
    }

    public AVLTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }
    //</editor-fold>

    //<editor-fold desc="接口：获取树的大小">
    public int size() {
        return size;
    }
    //</editor-fold>

    //<editor-fold desc="接口：是否为空">
    public boolean isEmpty() {
        return size == 0;
    }
    //</editor-fold>

    //<editor-fold desc="接口：清空">
    public void clear() {

    }
    //</editor-fold>

    //<editor-fold desc="接口：判断是否包含元素">
    public boolean contains(E element) {
        return false;
    }
    //</editor-fold>

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
        Node<E> node = root;
        int compare = 0;
        Node<E> parent = null;
        while (node != null) {

        }
    }

    //<editor-fold desc="元素非空检查">
    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }
    //</editor-fold>

    //<editor-fold desc="自定义遍历接口">
    public static abstract class Visitor<E> {
        /**
         * @param element 元素
         * @return true 停止遍历
         */
        abstract boolean visit(E element);

        boolean stop;
    }
    //</editor-fold>

    //<editor-fold desc="打印元素">
    @Override
    public Object root() {
        return root;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object string(Object node) {
        return ((Node<E>) node).element;
    }
    //</editor-fold>

    //<editor-fold desc="Node节点">
    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;
        int height;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean hasTwoChildren() {
            return left != null && right != null;
        }
    }
    //</editor-fold>
}
