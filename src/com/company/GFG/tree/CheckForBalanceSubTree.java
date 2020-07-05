package com.company.GFG.tree;

public class CheckForBalanceSubTree {
    public static void main(String[] args) {
//        Node root=DriverCode.buildTree("1 2 N N 3");
//        System.out.println(isBalanced(root));
    }

    static boolean isBalanced(Node root) {
        if (root == null) return true;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.abs(left-right)<=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private static int getHeight(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
