package com.company.GFG.tree;

import java.util.ArrayList;
import java.util.Stack;

public class IsSymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3)));

        System.out.println(isSymmetricRec(root));
    }

    public static boolean isSymmetricRec(TreeNode root) {
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        getLeftNodes(root.left, left);
        getRightNodes(root.right, right);

        System.out.println(left);
        System.out.println(right);

        if (left.size() == right.size()) {

            for (int i = 0; i < left.size(); i++) {
                if (left.get(i) != right.get(i)) {
                    return false;
                }
            }
            return true;

        }
        return false;
    }

    private static void getRightNodes(TreeNode right, ArrayList<Integer> list) {
        if (right == null) {
            list.add(100);
            return;
        }
        list.add(right.val);
        getRightNodes(right.right, list);
        getRightNodes(right.left, list);
    }

    private static void getLeftNodes(TreeNode left, ArrayList<Integer> list) {
        if (left == null) {
            list.add(100);
            return;
        }
        list.add(left.val);
        getLeftNodes(left.left, list);
        getLeftNodes(left.right, list);
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        getPreOrderOf(root.left, left);
        getPreOrderFromRight(root.left, right);

        return false;
    }

    private static void getPreOrderFromRight(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            list.add(100);
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() && current != null) {
            if (current == null) {
                list.add(100);
                TreeNode temp = stack.pop();
                list.add(temp.val);
            } else {
                stack.push(current);
//                list.add(current.val);
                current = current.left;
            }

        }

    }

    private static void getPreOrderOf(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            list.add(100);
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
    }
}
