package com.company.leetcode.tree;

import java.util.Stack;

public class IncreasingOrderSearchTree {
    public static void main(String[] args) {

    }


    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode head = null, last = null;

        while (!stack.isEmpty()) {
            if (stack.peek().left != null) {
                stack.push(stack.peek().left);
            } else {
                if (head == null) {
                    head = stack.peek();
                    last = stack.pop();
                }
                if (stack.peek().right != null) {

                }
            }
        }
        return null;
    }
}
