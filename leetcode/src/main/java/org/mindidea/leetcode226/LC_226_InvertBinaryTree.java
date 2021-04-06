/*
 * @class LC_226_InvertBinaryTree
 * @package org.mindidea.leetcode
 * @date 2020/12/19 14:17
 * Copyright (c) 2020 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.leetcode226;

import java.util.Stack;

/**
 * 226. Invert Binary Tree
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2020/12/19 14:17
 * @blog https://mindidea.org
 */
public class LC_226_InvertBinaryTree {
    public static void main(String[] args) {
        Solution s = new Solution();
        Solution.TreeNode root = new Solution.TreeNode();
    }
}

class Solution {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> queue = new Stack();
        queue.push(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.right != null) {
                queue.push(node.right);
            }
            if(node.left != null) {
                queue.push(node.left);
            }
        }
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


