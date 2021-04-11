package org.mindidea.datastructure_007AVL树;

import org.mindidea.datastructure_006二叉树.BST;

import java.util.Comparator;

public class AVLTree<E> extends BST<E> {

    public AVLTree() {
        this(null);
    }

    public AVLTree(Comparator<E> comparator) {
        super(comparator);
    }
}
