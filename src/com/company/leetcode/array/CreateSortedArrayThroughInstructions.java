package com.company.leetcode.array;

import java.util.ArrayList;
import java.util.List;


public class CreateSortedArrayThroughInstructions {
    public static void main(String[] args) {
        System.out.println(createSortedArray(new int[]{1, 3, 3, 3, 2, 4, 2, 1, 2}));
    }

    public static int createSortedArray(int[] a) {
        List<Integer> list = new ArrayList<>();
        int cost = 0;
        list.add(a[0]);
        for (int i = 1; i < a.length; i++) {
            int index = binarySearch(list, a[i]);
            int left = index == 0 ? 0 : index;
            int right = index == list.size() ? 0 : list.size() - index;
            cost += Math.min(left, right);
            list.add(index, a[i]);
        }
        return cost;
    }

    private static int binarySearch(List<Integer> list, int val) {
        int low = 0;
        int high = list.size() - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (list.get(mid) < val) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

}
