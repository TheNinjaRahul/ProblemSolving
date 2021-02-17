package com.company.leetcode.array;

public class FlipCoin {
    public static void main(String[] args) {
        System.out.println(flipCoin(6));
        System.out.println(flipCoin(1100));
    }

    //method 1
    private static int flipCoin(int n) {
        boolean[] coins = new boolean[n + 1];
        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            int j = i;
            int k = i;
            while (j <= n) {
                coins[j] = !coins[j];
                j += k;
            }
            if (coins[i]) {
                count++;
            }
        }
        return count;
    }


    //method 2
    private static int flipCoin2(int n) {
        boolean[] coins = new boolean[n + 1];
        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < Math.sqrt(i); j++) {
                if (i % j == 0) {
                }
            }
        }
        return count;
    }
}
