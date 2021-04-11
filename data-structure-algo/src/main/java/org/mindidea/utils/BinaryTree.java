package org.mindidea.utils;

import org.mindidea.datastructure_006二叉树.BST;
import org.mindidea.utils.printer.BinaryTreeInfo;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unused")
public class BinaryTree<E> implements BinaryTreeInfo {

    //<editor-fold desc="成员变量">
    protected int size;
    protected BST.Node<E> root;
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
        root = null;
        size = 0;
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

    //<editor-fold desc="前序遍历">
    public void preorderTraversal(BST.Visitor<E> visitor) {
        if (visitor == null) {
            return;
        }
        preorderTraversal(root, visitor);
    }

    /**
     * 递归前序遍历
     *
     * @param node 节点
     */
    private void preorderTraversal(Node<E> node, BST.Visitor<E> visitor) {
        if (node == null || visitor.stop) {
            return;
        }
        visitor.stop = visitor.visit(node.element);
        preorderTraversal(node.left, visitor);
        preorderTraversal(node.right, visitor);
    }
    //</editor-fold>

    //<editor-fold desc="中序遍历">
    public void inorderTraversal(BST.Visitor<E> visitor) {
        if (visitor == null) {
            return;
        }
        inorderTraversal(root, visitor);
    }

    /**
     * 中序遍历
     *
     * @param node 节点
     */
    private void inorderTraversal(Node<E> node, BST.Visitor<E> visitor) {
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
    public void postorderTraversal(BST.Visitor<E> visitor) {
        if (visitor == null) {
            return;
        }
        postorderTraversal(root, visitor);
    }

    /**
     * 后序遍历
     *
     * @param node 节点
     */
    private void postorderTraversal(Node<E> node, BST.Visitor<E> visitor) {
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

    //<editor-fold desc="前驱节点">
    /**
     * 前驱节点: node 的左子树最靠右的节点
     * 获取 node 的前驱节点
     *
     * @param node node
     * @return 前驱节点
     */
    protected Node<E> precursor(Node<E> node) {
        if (node == null) {
            return null;
        }
        Node<E> p = node.left;
        // 左子树不为空 left.right.right....
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }
        // 右子树为空 parent.parent.parent
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }
        // node.parent == null
        // node == node.parent.right

        return node.parent;
    }
    //</editor-fold>

    //<editor-fold desc="后继节点">
    protected Node<E> successor(Node<E> node) {
        if (node == null) {
            return null;
        }
        Node<E> p = node.right;
        if (p != null) {
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }

        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;
    }
    //</editor-fold>

    //<editor-fold desc="自定义遍历接口">
    public static abstract class Visitor<E> {
        /**
         * @param element 元素
         * @return true 停止遍历
         */
        public abstract boolean visit(E element);

        boolean stop;
    }
    //</editor-fold>

    //<editor-fold desc="元素节点定义">
    protected static class Node<E> {
        public E element;
        public Node<E> left;
        public Node<E> right;
        public Node<E> parent;

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
