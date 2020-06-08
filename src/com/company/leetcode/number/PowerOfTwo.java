package com.company.leetcode.number;

public class PowerOfTwo {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(3));
    }

    public static boolean isPowerOfTwo(int n) {
        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                return false;
            }
        }
        if (n == 1) {
            return true;
        }
        return false;
    }
}
