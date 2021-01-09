package com.company.leetcode.slidingWindow;

import java.util.ArrayList;

public class MaxSumSubarrayOfSizeK {
    public static void main(String[] args) {

    }

    static int maximumSumSubarray(int K, ArrayList<Integer> a, int N) {
        int start = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int end = 0; end < N; end++) {
            sum += a.get(end);
            if (end >= K - 1) {
                max = Math.max(max, sum);
                sum -= a.get(start++);
            }
        }
        return max;
    }
}
