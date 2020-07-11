package com.company.leetcode.tree;

public class MaxPathSum {
    public static void main(String[] args) {

        TreeNode root5 = SerializationAndDeserialization.deserialize("[9,6,-3,null,null,-6,2,null,null,2,null,-6,-6,-6]");
        System.out.println("16=" + maxPathSum(root5));

        TreeNode root4 = SerializationAndDeserialization.deserialize("[5,4,8,11,null,13,4,7,2,null,null,null,1]");
        System.out.println("48=" + maxPathSum(root4));

        TreeNode root3 = SerializationAndDeserialization.deserialize("[1,-2,3]");
        System.out.println("4=" + maxPathSum(root3));

        TreeNode root = SerializationAndDeserialization.deserialize("[-10,9,20,null,null,15,7]");
        System.out.println("42=" + maxPathSum(root));

        TreeNode root2 = new TreeNode(1, new TreeNode(2), null);
        System.out.println("3=" + maxPathSum(root2));


    }


    public static int maxPathSum(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        if (root.left == null && root.right == null) return root.val;
        int left = root.left == null ? 0 : getSum(root.left);
        int right = root.right == null ? 0 : getSum(root.right);
        int max = Math.max(left + root.val, right + root.val);
        max = Math.max(max, Math.max(root.val, right + left + root.val));
        return Math.max(max, Math.max(maxPathSum(root.left), maxPathSum(root.right)));
    }

    private static int getSum(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        if (root.left == null && root.right == null) return root.val;
        int left = root.left == null ? 0 : getSum(root.left);
        int right = root.right == null ? 0 : getSum(root.right);
        return Math.max(left + root.val, Math.max(right + root.val, root.val));
    }
}
