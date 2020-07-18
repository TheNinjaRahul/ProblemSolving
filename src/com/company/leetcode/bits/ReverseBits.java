package com.company.leetcode.bits;

public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverseBits(5));
    }

    public static int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                int reveserse = 1 << (31 - i);
                ans |= reveserse;
            }
        }
        return ans;
    }
}
