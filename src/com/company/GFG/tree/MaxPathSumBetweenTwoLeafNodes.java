package com.company.GFG.tree;


public class MaxPathSumBetweenTwoLeafNodes {

    static class Res {
        int max = Integer.MIN_VALUE;
    }

    public static void main(String[] args) {

        Node root3 = DriverCode.buildTree("1 8 6 -7 -10 -9");
        System.out.println("-1=" + maxPathSum(root3));
        Node root2 = DriverCode.buildTree("-10 -1 0 3");
        System.out.println("-8=" + maxPathSum(root2));
        Node root1 = DriverCode.buildTree("3 4 5 -10 4");
        System.out.println("16=" + maxPathSum(root1));
        Node root = DriverCode.buildTree("-9 6 -10");
        System.out.println("-13=" + maxPathSum(root));
    }

    static int maxPathSum(Node root) {
        Res res = new Res();
        getSum(root, res);
        return res.max;
    }

    private static int getSum(Node root, Res res) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.data;

        int left = getSum(root.left, res);
        int right = getSum(root.right, res);
        if (root.left != null && root.right != null) {
            res.max = Math.max(res.max, left + right + root.data);
            return Math.max(left, right) + root.data;
        }

        return root.left == null ? right + root.data : left + root.data;

    }
}
