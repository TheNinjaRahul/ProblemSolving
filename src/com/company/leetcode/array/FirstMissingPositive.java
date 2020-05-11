package com.company.leetcode.array;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] data = {3, 4, 6, 7};
        System.out.println(firstMissingPositive2(data));
    }

    public static int firstMissingPositive2(int[] nums) {
        // replace all negatives with 0
        for (
                int i = 0;
                i < nums.length; i++) {
            if (nums[i] < 0) nums[i] = 0;
        }
        // mark arr value as visited by multiplying it by -1.
        // if an arr value is 0, set it to Integer.MAX_VALUE
        for (
                int i = 0;
                i < nums.length; i++) {
            int targetIndex = Math.abs(nums[i]) - 1;
            if (targetIndex >= 0 && targetIndex < nums.length) {
                if (nums[targetIndex] == 0) nums[targetIndex] = Integer.MAX_VALUE;
                nums[targetIndex] = Math.abs(nums[targetIndex]) * -1;
            }
        }
        // check if any value is not visited
        for (
                int i = 0;
                i < nums.length; i++) {
            if (nums[i] >= 0) return i + 1;
        }
        // all visited, the next smaller positive integer is the next num after arr.length
        return nums.length + 1;
    }

    public static int firstMissingPositive(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }

            if (max < nums[i]) {
                max = nums[i];
            }
            sum += nums[i];
        }
        int sum2 = (nums.length + 1) * (2 * (min) + (nums.length)) / 2;
        return sum2 - sum;
    }
}
