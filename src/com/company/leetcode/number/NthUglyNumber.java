package com.company.leetcode.number;

import java.util.HashMap;

public class NthUglyNumber {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(1));
        for (int i = 1; i < 20; i++) {
            System.out.print(nthUglyNumber2(i) + " ");
        }
    }

    public static int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int id2 = 0, id3 = 0, id5 = 0;
        int count = 1;
        while (count < n) {
            int val2 = ugly[id2] * 2;
            int val3 = ugly[id3] * 3;
            int val5 = ugly[id5] * 5;
            int uglyVal = Math.min(val2, Math.min(val3, val5));
            if (uglyVal == val2) id2++;
            if (uglyVal == val3) id3++;
            if (uglyVal == val5) id5++;
            ugly[count++] = uglyVal;
        }
        return ugly[n - 1];
    }


    public static int nthUglyNumber2(int n) {
        HashMap<Integer, Boolean> valueMap = new HashMap<>();
        int count = 0;
        int i = 1;
        for (; count < n; i++) {
            if (isUgly(i, valueMap)) {
                valueMap.put(i, true);
                count++;
            } else {
                valueMap.put(i, false);
            }
        }
        return i - 1;
    }

    private static boolean isUgly(int i, HashMap<Integer, Boolean> valueMap) {
        if (valueMap.containsKey(i)) return valueMap.get(i);
        if (i == 1) return true;
        if (i % 2 == 0) {
            return isUgly(i / 2, valueMap);
        } else if (i % 3 == 0) {
            return isUgly(i / 3, valueMap);
        } else if (i % 5 == 0) {
            return isUgly(i / 5, valueMap);
        }
        return false;
    }
}
