package com.company.leetcode.slidingWindow;

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{-7, -8, 7, 5, 7, 1, 6, 0}, 4)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 1)));
    }


    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            if (deque.isEmpty()) {
                deque.addLast(i);
            } else {
                while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                    deque.removeLast();
                }
                deque.addLast(i);
            }
        }

        int a[] = new int[nums.length - k + 1];
        a[0] = nums[deque.getFirst()];
        System.out.println(a[0]);

        int j = 1;
        for (int i = k; i < nums.length; i++) {
            if (deque.getFirst() == i - k) {
                deque.removeFirst();
            }
            if (deque.isEmpty()) {
                deque.addLast(i);
            } else {
                while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                    deque.removeLast();
                }
                deque.addLast(i);
            }
            a[j++] = nums[deque.getFirst()];
            System.out.println(a[j - 1]);
        }
        return a;
    }

}
