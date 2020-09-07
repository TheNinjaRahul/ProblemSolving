package com.company.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class ContainsPattern {
    public static void main(String[] args) {
        int data3[] = {2, 2, 1, 2, 2, 1, 1, 1, 2, 1};
        System.out.println(containsPattern(data3, 2, 2));

        int data2[] = {1, 2, 1, 2, 1, 1, 1, 3};
        System.out.println(containsPattern(data2, 2, 2));

        int data[] = {1, 2, 4, 4, 4, 4};
        System.out.println(containsPattern(data, 1, 3));

    }

    public static boolean containsPattern(int[] a, int m, int k) {

        int maxCount = 0;
        for (int i = 0; i < a.length - m; i++) {
            List<Integer> sl = new ArrayList<>();
            int count = 1;
            for (int y = i; y < a.length && y < m + i; y++) {
                sl.add(a[y]);
            }
            if (sl.size() != m) break;

            for (int j = i + m; j < a.length; j++) {
                int index = 0;
                boolean wantOuterBreak = false;
                if (a[j] == sl.get(index)) {
                    for (int x = j; x < a.length && index < m && x < j + m; x++) {
                        if (a[x] == sl.get(index)) {
                            index++;
                            if (index == m) {
                                count++;
                                j += m - 1;
                            }
                        } else {
                            wantOuterBreak = true;
                            break;
                        }
                    }
                } else {
                    break;
                }
                if (wantOuterBreak) break;
            }
            if (count == 1) count = 0;
            if (maxCount < count) {
                maxCount = count;
            }
        }
        return maxCount >= k;

    }
}
