package com.company.leetcode.sort;

import javax.swing.plaf.IconUIResource;

public class HIndex {
    public static void main(String[] args) {
        int data[] = {3, 0, 6, 1, 5};
        System.out.println(hIndex(data));
    }

    public static int hIndex(int[] citations) {
        int[] bucket = new int[citations.length + 1];
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] > citations.length) {
                bucket[citations.length]++;
            } else {
                bucket[citations[i]]++;
            }
        }

        int count = 0;
        for (int i = citations.length; i >= 0; i--) {
            count += bucket[i];
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }
}
