package com.company.leetcode.tree;

import com.company.GFG.tree.TreeUtil;

public class SumOfLeftLeaves {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        System.out.println(sumOfLeftLeaves(root));
    }
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null && root.left.right == null && root.left.left == null) {
            sum=root.left.val;
        }
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;

    }
}
