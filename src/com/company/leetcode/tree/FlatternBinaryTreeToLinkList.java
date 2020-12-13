package com.company.leetcode.tree;

public class FlatternBinaryTreeToLinkList {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        flatten(root);
        while (root != null) {
            System.out.println(root.val);
            root = root.right;
        }
    }

    public static void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten(left);
        flatten(right);
        root.left = null;
        root.right = left;

        if (left != null) {
            while (left.right != null) {
                left = left.right;
            }
            left.right = right;
        }
    }
}
