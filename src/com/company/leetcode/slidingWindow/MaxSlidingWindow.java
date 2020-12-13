package com.company.leetcode.slidingWindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    public static int[] maxSlidingWindow(int[] a, int k) {
        Deque<Integer> queue = new LinkedList<>();
        int start = 0;
        int[] ans = new int[a.length - k + 1];
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (queue.isEmpty()) {
                queue.add(i);
                continue;
            }
            while (!queue.isEmpty() && a[queue.getLast()] < a[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
            if (i >= k - 1) {
                ans[j++] = a[queue.getFirst()];
                if (queue.getFirst() == start++) {
                    queue.removeFirst();
                }
            }
        }

        return ans;
    }
}
