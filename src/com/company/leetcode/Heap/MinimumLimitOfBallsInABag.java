package com.company.leetcode.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumLimitOfBallsInABag {
    public static void main(String[] args) {
        int[] a = {2, 4, 8, 2};
        System.out.println(minimumSize(a, 4));
    }

    public static int minimumSize(int[] nums, int maxOperations) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : nums) {
            q.add(i);
        }
        while (maxOperations > 0) {
            maxOperations--;
            int max = q.remove();
            int smax = q.remove();
            int div = max / 2;

            if (max % 2 == 0) {
                q.add(div);
                q.add(div);
            } else {
                q.add(div);
                q.add(div + 1);
            }
        }
        return q.remove();
    }
}
