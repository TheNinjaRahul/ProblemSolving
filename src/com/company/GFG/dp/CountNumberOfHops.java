package com.company.GFG.dp;

import java.util.HashMap;

public class CountNumberOfHops {
    public static void main(String[] args) {
        System.out.println(countWays(4));
    }


    static long countWays(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1l;
        if (n == 2) return 2l;
        if (n == 3) return 3l;
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n] % 1000000007;
    }

    static long countWays2(int n) {
        HashMap<Integer, Long> map = new HashMap<>();
        countRec(n, map);
        return map.get(n);
    }

    static long countRec(int n, HashMap<Integer, Long> map) {
        if (n <= 0) return 0;
        if (map.containsKey(n)) {
            return map.get(n);
        }
        long sum = 0;
        if (n - 1 == 0) {
            sum += 1;
        } else if (n - 1 > 0) {
            sum += countWays(n - 1);
        }
        if (n - 2 == 0) {
            sum += 1;
        } else if (n - 2 > 0) {
            sum += countWays(n - 2);
        }

        if (n - 3 == 0) {
            sum += 1;
        } else if (n - 3 > 0) {
            sum += countWays(n - 3);
        }
        map.put(n, sum);
        return sum;
    }
}
