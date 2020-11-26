package com.company.leetcode.string;

import java.util.Stack;

public class BasicCalculatorII {


    public static void main(String[] args) {
        System.out.println("1=" + calculate("1-1+1"));
        System.out.println("6=" + calculate("100/100+1*5"));
        System.out.println(calculate("0-2147483647"));

    }

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char lastChar = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
                if (lastChar == '+') {
                    stack.push(num);
                }
                if (lastChar == '-') {
                    stack.push(-1 * num);
                }
                if (lastChar == '/') {
                    stack.push(stack.pop() / num);
                }
                if (lastChar == '*') {
                    stack.push(stack.pop() * num);
                }
                num = 0;
                lastChar = c;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static int calculate2(String s) {

        s = s.trim();
        Stack<Character> es = new Stack<>();
        Stack<Integer> ns = new Stack<>();

        int start = 0;
        int end = 1;
        boolean isLastCharSpace = false;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (c == ' ') {
                if (start == end - 1) {
                    if (s.charAt(start) != ' ') {
                        int num = Integer.parseInt(s.substring(start, end));
                        ns.push(num);
                        isLastCharSpace = true;
                    }
                    start++;
                } else if (start == end) {
                    start++;
                } else {
                    int num = Integer.parseInt(s.substring(start, end));
                    ns.add(num);
                    start = end + 1;
                    isLastCharSpace = true;
                }
                end++;
                continue;
            }

            if (c == '*' || c == '/' || c == '+' || c == '-') {
                int num = 0;
                if (isLastCharSpace) {
                    num = ns.pop();
                } else {
                    num = Integer.parseInt(s.substring(start, end));
                }
                isLastCharSpace = false;
                if (!es.isEmpty() && es.peek() == '*') {
                    ns.push(ns.pop() * num);
                    es.pop();
                    start = end + 1;
                    es.push(c);
                } else if (!es.isEmpty() && es.peek() == '/') {
                    ns.push(ns.pop() / num);
                    es.pop();
                    start = end + 1;
                    es.push(c);
                } else {
                    ns.push(num);
                    es.push(c);
                    start = end + 1;
                }
            }
            end++;
        }
        ns.push(Integer.parseInt(s.substring(start, end)));

        while (!es.isEmpty()) {
            int num2 = ns.pop();
            int num1 = ns.pop();
            char ex = es.pop();
            if (ex == '+') {
                ns.push(num1 + num2);
            } else if (ex == '-') {
                ns.push(Math.max(num1, num2) - Math.min(num1, num2));
            } else if (ex == '/') {
                ns.push(num1 / num2);
            } else if (ex == '*') {
                ns.push(num2 * num1);
            }
        }

        return ns.pop();
    }
}
