package com.company.leetcode.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MinDominoRotation {
    public static void main(String[] args) {

    }

    public int minDominoRotations(int[] A, int[] B) {
        Map<Integer, List<Integer>> amap = new HashMap<>();
        Map<Integer, List<Integer>> bmap = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            if (!amap.containsKey(A[i])) amap.put(A[i], new LinkedList<>());
            if (!bmap.containsKey(B[i])) bmap.put(B[i], new LinkedList<>());

            amap.get(A[i]).add(i);
            bmap.get(B[i]).add(i);
        }


        int min = Integer.MAX_VALUE;
        for (Integer key : amap.keySet()) {
            System.out.println("Checking:" + key);

            if ((amap.containsKey(key) && amap.get(key).size() == A.length) || (bmap.containsKey(key) && bmap.get(key).size() == A.length))
                return 0;

            if (amap.containsKey(key) && bmap.containsKey(key)) {
                int a = amap.get(key).size();
                int b = bmap.get(key).size();
                int needstoCheck = A.length - a;
                if (b >= needstoCheck) {
                    int count = 0;
                    for (int index : amap.get(key)) {
                        if (A[index] == B[index]) {
                            count++;
                        }
                    }

                    min = Math.min(needstoCheck, min);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
