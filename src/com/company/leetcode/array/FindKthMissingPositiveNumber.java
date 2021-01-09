package com.company.leetcode.array;

import java.util.LinkedList;
import java.util.List;

public class FindKthMissingPositiveNumber {
    public static void main(String[] args) {
        FindKthMissingPositiveNumber f = new FindKthMissingPositiveNumber();
        System.out.println(f.findKthPositive(new int[]{1, 2, 3, 4}, 2));
    }

    public int findKthPositive(int[] a, int k) {
        List<Integer> list = new LinkedList<>();
        int count = 0;
        int j = 0;
        for (int i = 1; ; i++) {
            if (j < a.length) {
                if (a[j] != i) {
                    count++;
                    list.add(i);
                } else {
                    j++;
                }
            } else {
                count++;
            }

            if (count == k) {
                System.out.println(list);
                return i;
            }
        }
    }
}
