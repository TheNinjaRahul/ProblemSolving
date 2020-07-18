package com.company.leetcode.BST;

import com.company.GFG.tree.ConvertLinkListToArray;

public class SortedArrayToBST {

    public static void main(String[] args) {
        int data[]={-10,-3,0,5,9};
        TreeNode root=sortedArrayToBST(data);
        System.out.println(root);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
       return getRootNode(low, high, nums);
    }

    private static TreeNode getRootNode(int low, int high, int[] nums) {
        if (low > high) return null;
        int mid = (low+high)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = getRootNode(low, mid - 1, nums);
        root.right = getRootNode(mid + 1, high, nums);
        return root;
    }
}
