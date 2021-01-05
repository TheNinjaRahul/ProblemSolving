package com.company.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class HistoGram {
    public static void main(String[] args) {
        HistoGram h = new HistoGram();
        System.out.println(h.largestRectangleArea(new int[]{9, 9}));
        System.out.println(h.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(h.largestRectangleArea(new int[]{9, 0}));
    }

    public int largestRectangleArea(int[] a) {
        if (a.length == 0) return 0;
        if (a.length == 1) return a[0];
        int left[] = getLeftMin(a);
        int right[] = getRightMin(a);
        System.out.println(Arrays.toString(left));

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < left.length; i++) {
            max = Math.max(max, (right[i] - left[i] + 1) * a[i]);
        }
        return max;
    }

    public int[] getLeftMin(int[] a) {
        Stack<Integer> stack = new Stack<>();
        int[] x = new int[a.length];
        x[0] = 0;
        stack.push(0);
        for (int i = 1; i < a.length; i++) {
            while (!stack.isEmpty() && a[stack.peek()] >= a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                x[i] = 0;
            } else {
                x[i] = stack.peek() + 1;
            }
            stack.push(i);
        }
        return x;
    }

    public int[] getRightMin(int[] a) {
        Stack<Integer> stack = new Stack<>();
        int[] x = new int[a.length];
        x[a.length - 1] = a.length - 1;
        stack.push(a.length - 1);
        for (int i = a.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && a[stack.peek()] >= a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                x[i] = a.length - 1;
            } else {
                x[i] = stack.peek() - 1;
            }
            stack.push(i);
        }
        return x;
    }
}
