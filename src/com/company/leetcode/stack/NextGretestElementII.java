package com.company.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGretestElementII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{5, 4, 3, 2, 1})));
    }

    public static int[] nextGreaterElements(int[] a) {
        // if(a.length<=1) return a;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        while (i < a.length) {
            if (max < a[i]) {
                max = a[i];
                maxIndex = i;
            }
            while (!stack.isEmpty() && stack.peek() < a[i]) {
                a[stack.peek()] = a[i];
                stack.pop();
            }
            stack.push(i);
            i++;
        }
        while (!stack.isEmpty()) {
            a[stack.pop()] = max;
        }
        if (maxIndex != -1) {
            a[maxIndex] = -1;
        }
        return a;
    }
}
