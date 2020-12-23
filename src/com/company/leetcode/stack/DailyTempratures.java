package com.company.leetcode.stack;

import java.util.Stack;

public class DailyTempratures {
    public static void main(String[] args) {
        System.out.println(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }

    public static int[] dailyTemperatures(int[] a) {
        Stack<Integer> stack = new Stack<>();
        int i = 1;
        while (i < a.length) {
            while (!stack.isEmpty() && a[stack.peek()] < a[i]) {
                a[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
            i++;
        }

        while (!stack.isEmpty()) {
            a[stack.pop()] = 0;
        }
        return a;
    }
}
