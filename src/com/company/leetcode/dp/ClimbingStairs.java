package com.company.leetcode.dp;

import java.util.HashMap;

public class ClimbingStairs {
    public static void main(String[] args) {

    }

    public int climbStairs(int n)  {
        HashMap<Integer, Integer> map = new HashMap<>();
        countRec(n, map);
        return map.get(n);
    }

    static int countRec(int n, HashMap<Integer, Integer> map) {
        if (n <= 0) return 0;
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int sum = 0;
        if (n - 1 == 0) {
            sum += 1;
        } else if (n - 1 > 0) {
            sum += countRec(n - 1,map);
        }
        if (n - 2 == 0) {
            sum += 1;
        } else if (n - 2 > 0) {
            sum += countRec(n - 2,map);
        }

        map.put(n, sum);
        return sum;
    }
}
