package com.company.leetcode.array;

public class FirstMissing {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

    public static int missingNumber(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int n = nums.length + 1;
        int fsum = n * (n - 1) / 2;
        return fsum - sum;
    }
}
