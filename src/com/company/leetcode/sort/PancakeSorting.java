package com.company.leetcode.sort;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {
    public static void main(String[] args) {
        int[] data = {3, 2, 4, 1};
        System.out.println(pancakeSort(data));
    }

    public static List<Integer> pancakeSort(int[] A) {
        int cur_size = A.length - 1;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < A.length; i++) {
            int max = A[0], max_index = 0;
            ;

            for (int j = 1; j <= cur_size; j++) {
                if (max < A[j]) {
                    max = A[j];
                    max_index = j;
                }
            }
            if (cur_size != max_index) {
                list.add(max_index + 1);
                flip(A, max_index);
                list.add(cur_size + 1);
                flip(A, cur_size);
            }
            cur_size--;
        }
        return list;
    }

    public static void flip(int[] A, int end) {
        int s = 0;
        while (s < end) {
            int temp = A[s];
            A[s] = A[end];
            A[end] = temp;
            s++;
            end--;
        }
    }
}
