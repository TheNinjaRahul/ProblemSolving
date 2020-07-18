package com.company.leetcode.BST;

public class RangeSumOfBST {
    public static void main(String[] args) {

    }

    public int rangeSumBST(TreeNode root, int L, int R) {

        int data[] = {0};

        getAllInRange(root, L, R, data);

        return data[0];
    }

    private void getAllInRange(TreeNode root, int low, int high, int[] data) {
        if (root == null) return;

        if (root.val > low) {
            getAllInRange(root.left, low, high, data);
        }
        if (root.val >= low && root.val <= high) {
            data[0] += root.val;
        }
        if (root.val <= high) {
            getAllInRange(root.right, low, high, data);
        }

    }


}
