package com.company.GFG.tree;

import java.util.Map;

public class MaximumDifferenceBetweenNodeAndAncestor {
    public static void main(String[] args) {
        TreeNode r = new TreeNode(0, null, new TreeNode(1));
        System.out.println(maxAncestorDiff(r));
    }

    //    static int max = Integer.MIN_VALUE;
    static class MyMaxClass {
        int max = 0;
    }

    public static int maxAncestorDiff(TreeNode root) {
        MyMaxClass max = new MyMaxClass();
        max.max = 0;
        maxAncestorDiff(root, max);
        return max.max;
    }

    public static int maxAncestorDiff(TreeNode root, MyMaxClass max) {
        if (root == null) return 0;
        maxAncestorDiffChild(root, root.left, max);
        maxAncestorDiffChild(root, root.right, max);
        maxAncestorDiff(root.left, max);
        maxAncestorDiff(root.right, max);
        return max.max;
    }

    private static void maxAncestorDiffChild(TreeNode root, TreeNode child, MyMaxClass max) {
        if (child == null) return;
        if (Math.abs(root.val - child.val) > max.max) {
            max.max = Math.abs(root.val - child.val);
        }
        maxAncestorDiffChild(root, child.left, max);
        maxAncestorDiffChild(root, child.right, max);
    }
}
