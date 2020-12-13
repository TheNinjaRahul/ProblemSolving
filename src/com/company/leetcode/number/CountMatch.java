package com.company.leetcode.number;

public class CountMatch {
    public static void main(String[] args) {
        System.out.println(numberOfMatches(7));
    }

    public static int numberOfMatches(int n) {
        int count = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
                count += n;
            } else {
                count += (n - 1) / 2;
                n = (n - 1) / 2 + 1;
            }
        }
        return count;
    }
}
