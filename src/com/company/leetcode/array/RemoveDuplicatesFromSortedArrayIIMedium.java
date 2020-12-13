package com.company.leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedArrayIIMedium {


    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
    }

    public static int removeDuplicates(int[] a) {
        if (a.length <= 1) return a.length;
        int left = 2;
        for (int right = 2; right < a.length; right++) {
            if (a[left - 2] != a[right]) {
                a[left] = a[right];
                left++;
            }
        }
        return left;
    }


}
