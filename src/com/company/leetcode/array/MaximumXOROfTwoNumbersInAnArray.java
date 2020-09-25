package com.company.leetcode.array;

public class MaximumXOROfTwoNumbersInAnArray {
    public static void main(String[] args) {

    }


    class TrieBitNode {
        TrieBitNode left;
        TrieBitNode right;
    }

    public void insert(TrieBitNode head, int val) {

        TrieBitNode curr = head;

        for (int i = 31; i >= 0; i--) {
            int bit = (val >> i) & 1;
            if (bit == 1) {
                if (curr.right == null) {
                    curr.right = new TrieBitNode();
                }
                curr = curr.right;
            } else {
                if (curr.left == null) {
                    curr.left = new TrieBitNode();
                }
                curr = curr.left;
            }
        }
    }

    public int findMaximumXOR(int[] nums) {
        if (nums.length == 0) return 0;
        TrieBitNode head = new TrieBitNode();
        for (int i = 0; i < nums.length; i++) {
            insert(head, nums[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {

            int ans = 0;
            TrieBitNode curr = head;
            for (int j = 31; j >= 0; j--) {
                int bit = (nums[i] >> j) & 1;

                if (bit == 1) {
                    if (curr.left != null) {
                        ans += Math.pow(2, j);
                        curr = curr.left;
                    } else {
                        curr = curr.right;
                    }
                } else {
                    if (curr.right != null) {
                        ans += Math.pow(2, j);
                        curr = curr.right;
                    } else {
                        curr = curr.left;
                    }
                }
            }
            max = Math.max(ans, max);
        }

        return max;
    }
}
