package com.company.leetcode.number;

public class LeetCodeBank {
    public static void main(String[] args) {
        System.out.println(totalMoney(10));
    }

    public static int totalMoney(int n) {
        int ans = 0;
        int count = 0;
        int weeks = n / 7;
        for (int i = 0; i <= weeks; i++) {
            int t = 0;
            for (int j = i + 1; j <= i + 7; j++) {
                ans += j;
                count++;
                if (count == n) break;
            }
            if (count == n) break;
        }
        return ans;
    }
}
