package com.company.leetcode.array;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{2, 3, 4, 5, 6, 10, 32, 5, 2}, 3));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
            if (q.size() > k) {
                q.remove();
            }
        }

        return q.remove();

    }
}
