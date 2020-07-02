package com.company.leetcode.tree;

public class FindDiameterOfTree {

    public static void main(String[] args) {

    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int currentNodeDiameter=1+height(root.left)+height(root.right);
        int leftDiameter=diameterOfBinaryTree(root.left);
        int rightDiameter=diameterOfBinaryTree(root.right);
        return Math.max(currentNodeDiameter,Math.max(leftDiameter,rightDiameter));
    }

    private int height(TreeNode root) {
        if(root==null) return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
}
