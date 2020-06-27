package com.company.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static com.company.leetcode.tree.InorderTree.inorderTraversal;

public class PreOrderWithoutRecurstion {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        System.out.println(preorderTraversal(root));

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (true) {

            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }

            if (stack.isEmpty()) break;
            root = stack.pop();
            root = root.right;

        }
        return list;

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (true) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (stack.isEmpty()) break;

            root = stack.pop();


        }

        return null;
    }


}
