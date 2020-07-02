package com.company.GFG.tree;

public class IsCompleteBinaryTree {
    public static void main(String[] args) {

    }

    boolean isFullTree(TreeNode root) {
        if (root == null) return true;
        if (root.left != null && root.right != null) {
            return isFullTree(root.left) && isFullTree(root.right);
        } else if (root.left == null && root.right == null) {
            return true;
        } else {
            return false;
        }
    }
}
