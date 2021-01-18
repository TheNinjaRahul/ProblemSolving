package com.company.leetcode.number;

import java.util.HashMap;
import java.util.Map;

public class TupleWithSameProduct {
    public static void main(String[] args) {
        TupleWithSameProduct a = new TupleWithSameProduct();
        System.out.println(a.tupleSameProduct(new int[]{2, 3, 4, 6}));
    }

    public int tupleSameProduct(int[] a) {

        if (a == null || a.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int mul = a[i] * a[j];
                map.put(mul, map.getOrDefault(mul, 0) + 1);
            }
        }

        int count = 0;
        System.out.println(map);
        for (int val : map.values()) {
            if (val > 1) {
                int combination = (val * (val - 1)) / 2;
                count += (combination * 8);
            }
        }

        return count;
    }

}
