/*
 * @class BinarySearchTree
 * @package org.mindidea.structure.demo05_1_二叉树
 * @date 2021/1/23 18:03
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.datastructure_006二叉树;

import org.mindidea.utils.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021/1/23 18:03
 * @blog https://mindidea.org
 */
@SuppressWarnings(value = {"unused"})
public class BinarySearchTree1<E> implements BinaryTreeInfo {

    //<editor-fold desc="成员变量">
    private int size;
    private Node<E> root;
    private final Comparator<E> comparator;
    //</editor-fold>

    //<editor-fold desc="构造器">
    public BinarySearchTree1() {
        this(null);
    }

    public BinarySearchTree1(Comparator<E> comparator) {
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

    }
    //</editor-fold>

    //<editor-fold desc="前序遍历">
    public void preorderTraversal(Visitor<E> visitor) {
        if (visitor == null) {
            return;
        }
        preorderTraversal(root, visitor);
    }
    /**
     * 递归前序遍历
     * @param node 节点
     */
    private void preorderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) {
            return;
        }
        visitor.stop = visitor.visit(node.element);
        preorderTraversal(node.left, visitor);
        preorderTraversal(node.right, visitor);
    }
    //</editor-fold>

    //<editor-fold desc="中序遍历">
    public void inorderTraversal(Visitor<E> visitor) {
        if (visitor == null) {
            return;
        }
        inorderTraversal(root, visitor);
    }

    /**
     * 中序遍历
     * @param node 节点
     */
    private void inorderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) {
            return;
        }
        inorderTraversal(node.left, visitor);
        if (visitor.stop) {
            return;
        }
        visitor.stop = visitor.visit(node.element);
        inorderTraversal(node.right, visitor);
    }
    //</editor-fold>

    //<editor-fold desc="后序遍历">
    public void postorderTraversal(Visitor<E> visitor) {
        if (visitor == null) {
            return;
        }
        postorderTraversal(root, visitor);
    }

    /**
     * 后序遍历
     * @param node 节点
     */
    private void postorderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) {
            return;
        }
        postorderTraversal(node.left, visitor);
        postorderTraversal(node.right, visitor);
        if (visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
    }
    //</editor-fold>

    //<editor-fold desc="层序遍历">
    /**
     * 层序遍历
     */
    public void levelOrderTraversal(Visitor<E> visitor) {
        if (root == null || visitor == null) return;

        Queue<Node<E>> queue = new LinkedList<>();
        // 根节点先入队
        queue.offer(root);
        // 遍历 queue
        while (!queue.isEmpty()) {
            // 取出队列头元素
            Node<E> node = queue.poll();
            // 调用 visitor 的 visit 方法，实现自定义逻辑
            if (visitor.visit(node.element)) {
                return;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
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
        return ((Node<E>)node).left;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object string(Object node) {
        return ((Node<E>)node).element;
    }
    //</editor-fold>

    //<editor-fold desc="元素节点定义">
    public static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }
    //</editor-fold>

    //<editor-fold desc="打印">
    public void show() {
        show(root);
    }
    private void show(Node<E> root) {
        if (root == null) throw new NullPointerException("The tree is empty!");
        // 得到树的深度
        int treeDepth = getTreeDepth(root);

        // 最后一行的宽度为2的（n - 1）次方乘3，再加1
        // 作为整个二维数组的宽度
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        // 用一个字符串数组来存储每个位置应显示的元素
        String[][] res = new String[arrayHeight][arrayWidth];
        // 对数组进行初始化，默认为一个空格
        for (int i = 0; i < arrayHeight; i++) {
            for (int j = 0; j < arrayWidth; j++) {
                res[i][j] = " ";
            }
        }

        // 从根节点开始，递归处理整个树
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
        writeArray(root, 0, arrayWidth / 2, res, treeDepth);

        // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
        for (String[] line : res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2 : line[i].length() - 1;
                }
            }
            System.out.println(sb);
        }
    }
    public int getTreeDepth(Node<E> root) {
        return root == null ? 0 : (1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right)));
    }
    private void writeArray(Node<E> currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        // 保证输入的树不为空
        if (currNode == null) return;
        // 先将当前节点保存到二维数组中
        res[rowIndex][columnIndex] = String.valueOf(currNode.element);

        // 计算当前位于树的第几层
        int currLevel = ((rowIndex + 1) / 2);
        // 若到了最后一层，则返回
        if (currLevel == treeDepth) return;
        // 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
        int gap = treeDepth - currLevel - 1;

        // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
        if (currNode.left != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }

        // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
        if (currNode.right != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }
    //</editor-fold>
}
