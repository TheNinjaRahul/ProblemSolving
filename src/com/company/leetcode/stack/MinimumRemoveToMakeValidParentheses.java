package com.company.leetcode.stack;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
    }

    public static String minRemoveToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int open = 0, close = 0;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == ')') {
                if (c == '(') {
                    open++;
                    stack.push(c);
                } else if (c == ')' && open > 0) {
                    close++;
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
//        if (open == close) return s;
        int removeOpen = 0;
        int removeClose = 0;
        if (open > close) {
            removeOpen = open - close;
        } else {
            removeClose = close - open;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (removeOpen != 0) {
                if (c == '(') {
                    removeOpen--;
                    continue;
                }
            }
            if (removeClose != 0) {
                if (c == ')') {
                    removeClose--;
                    continue;
                }
            }
            sb.append(c);
        }
        return sb.reverse().toString();
    }

}
