package com.company.leetcode.tree;

/**
 * https://leetcode.com/problems/path-sum-iii/
 */
public class PathSumIII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))),
                new TreeNode(-3, null, new TreeNode(11)));

        TreeNode root2 = new TreeNode(-2, null, new TreeNode(-3));
        System.out.println(pathSum(root2, -5));
        System.out.println(pathSum(root, 8));
    }

    static class mycount {
        int count = 0;
    }

    public static int pathSum(TreeNode root, int sum) {
        mycount m = new mycount();
        if (root == null) return 0;
        helper(root, sum, 0, m);
        m.count += pathSum(root.left, sum);
        m.count += pathSum(root.right, sum);
        return m.count;
    }

    public static void helper(TreeNode root, int sum, int currentSum, mycount m) {
        if (root == null) return;
        currentSum += root.val;
        if (currentSum == sum) {
            m.count++;
            return;
        }
        helper(root.left, sum, currentSum, m);
        helper(root.right, sum, currentSum, m);
    }

}
