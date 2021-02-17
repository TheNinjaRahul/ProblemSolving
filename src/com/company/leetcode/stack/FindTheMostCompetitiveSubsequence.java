package com.company.leetcode.stack;

import java.util.Stack;

public class FindTheMostCompetitiveSubsequence {
    public static void main(String[] args) {
        System.out.println(mostCompetitive(new int[]{5, 4, 3, 2, 1}, 3));
    }

    public static int[] mostCompetitive(int[] a, int k) {
        Stack<Integer> stack = new Stack<>();
        int rem = a.length - k;
        for (int i = 0; i < a.length; i++) {
            while (!stack.isEmpty() &&
                    rem > 0 &&
                    stack.peek() > a[i]) {
                stack.pop();
                rem--;
            }
            stack.push(a[i]);
        }
        while (!stack.isEmpty() && stack.size() != k) {
            stack.pop();
        }
        int[] res = new int[k];
        int x = k - 1;
        while (!stack.isEmpty()) {
            res[x--] = stack.pop();
        }
        return res;
    }
}
