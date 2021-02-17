package com.company.leetcode.string;

public class MinOperation {
    public static void main(String[] args) {
        System.out.println(minOperations("10"));
    }

    public static int minOperations(String s) {
        boolean f = false;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (f) {
                if (c == '0') {
                    count++;
                }

            } else {
                if (c == '1') {
                    count++;
                }
            }
            f = !f;
        }

        f = true;
        int count2 = 0;
        for (char c : s.toCharArray()) {
            if (f) {
                if (c == '0') {
                    count2++;
                }

            } else {
                if (c == '1') {
                    count2++;
                }
            }
            f = !f;
        }

        return Math.min(count, count2);
    }
}
