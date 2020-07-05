package com.company.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrisonCellAfterNDAys {
    public static void main(String[] args) {
        int[] a = {1, 0, 0, 1, 0, 0, 1, 0};
        System.out.println(prisonAfterNDays(a, 1000000000));
    }

    public static int[] prisonAfterNDays(int[] a, int N) {
        if (a == null || a.length == 0 || N <= 0) return a;
        Set<String> set = new HashSet<>();
        int cycle = 0;
        for (int j = 0; j < N; j++) {
            int[] newState = getNewState(a);
            if (!set.contains(Arrays.toString(newState))) {
                set.add(Arrays.toString(newState));
                cycle++;
            } else {
                for (int k = 0; k < N % cycle; k++) {
                    a = getNewState(a);
                }
                System.out.println(Arrays.toString(a));
                return a;
            }
            a = newState;
        }

//        System.out.println(Arrays.toString(a));
        return a;

    }

    private static int[] getNewState(int[] a) {
        int[] newState = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (i == 0 || i == a.length - 1) {
//                a[i] = 0;
                continue;
            }
            if (a[i - 1] == a[i + 1]) {
                newState[i] = 1;
            } else {
                newState[i] = 0;
            }
        }
        return newState;
    }
}
