/*
 * @class BinarySearchTree
 * @package org.mindidea.structure.demo05_1_二叉树
 * @date 2021/1/23 18:03
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea._03_structure.demo05_1_二叉树;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021/1/23 18:03
 * @blog https://mindidea.org
 */
public class BinarySearchTree<E> {

    private int size;
    private Node<E> root;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {

    }

    /**
     * 添加元素
     *
     * @param element 被添加的元素
     * @return void
     * @author Tsingyun(青雲)
     * @createTime 2021/1/23 18:25
     */
    public void add(E element) {
        elementNotNullCheck(element);
        // 添加第一个节点（根节点）
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }
        // 添加其他节点
        // 找到父节点
        Node<E> node = root;
        Node<E> parent = node;
        int compare = 0;
        while (node != null) {
            parent = node;
            compare = compare(element, node.element);
            if (compare > 0) {
                node = node.right;
            } else if (compare < 0) {
                node = node.left;
            } else {
                // TODO: 相等
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

    public void remove(E element) {

    }

    public boolean contains(E element) {

        return false;
    }

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
        // 使用 Java 自带比较器
        return ((Comparable<E>) e1).compareTo(e2);
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    public void show() {
        show(root);
    }

    private void show(Node<E> root) {
        if (root == null) System.out.println("EMPTY!");
        // 得到树的深度
        int treeDepth = getTreeDepth(root);

        // 最后一行的宽度为2的（n - 1）次方乘3，再加1
        // 作为整个二维数组的宽度
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        // 用一个字符串数组来存储每个位置应显示的元素
        String[][] res = new String[arrayHeight][arrayWidth];
        // 对数组进行初始化，默认为一个空格
        for (int i = 0; i < arrayHeight; i ++) {
            for (int j = 0; j < arrayWidth; j ++) {
                res[i][j] = " ";
            }
        }

        // 从根节点开始，递归处理整个树
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
        writeArray(root, 0, arrayWidth/ 2, res, treeDepth);

        // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
        for (String[] line: res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i ++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2: line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
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

    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }
}
