package com.company.leetcode.Math;

public class ConcatenationOfConsecutiveBinaryNumbers {
    public static void main(String[] args) {

    }

    public int concatenatedBinary(int n) {
        long val = 0;
        int i = 1;
        while (i <= n) {
            val = ((val << (long) (1 + (Math.log(i) / Math.log(2)))) % 1000000007 + i) % 1000000007;
        }
        return (int) val;
    }

}
