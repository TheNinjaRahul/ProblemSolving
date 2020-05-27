package com.company.GFG.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfArray {
    public static void main(String[] args) {

        int data[] = {2, 2, 3, 4, 5};
        int data2[] = {1, 1, 2, 3, 4};


        int a[] = {9, 1, 9, 1, 9, 1, 0};
        int b[] = {9, 8, 7, 6, 5, 4, 3, 2, 1};
//        System.out.println(findInterSection(data, data2, data.length, data2.length));
        System.out.println(findInterSection(a, b, a.length, b.length));
    }

    private static List<Integer> findInterSection(int[] a, int[] b, int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = 0;
        while (i < n && j < m) {
//            int insert=0;
            if (a[i] == b[j]) {
                if (list.isEmpty()) {
                    list.add(a[i]);
                } else if (!(list.get(list.size() - 1) == a[i])) {
                    list.add(a[i]);
                }
            }

            if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }

        }


        return list;
    }
}
