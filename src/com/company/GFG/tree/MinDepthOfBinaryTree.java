package com.company.GFG.tree;

public class MinDepthOfBinaryTree {
    public static void main(String[] args) {
//        Node root = DriverCode.buildTree("10 20"); //30 N 40 N 60 N N 2");
//
//        System.out.println(minDepth(root));
    }

    static int minDepth(Node root) {
        if (root == null) return 0;
        return getData(root);
    }

    private static int getData(Node root) {
        if (root.left == null && root.right == null) return 1;
        int left=root.left!=null ? getData(root.left):Integer.MAX_VALUE;
        int right=root.right!=null ? getData(root.right):Integer.MAX_VALUE;
        return 1 + Math.min(left,right);
    }
}
