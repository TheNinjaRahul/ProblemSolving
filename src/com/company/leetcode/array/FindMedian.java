package com.company.leetcode.array;

public class FindMedian {
    public static void main(String[] args) {
        int v = '5'-'0';
        System.out.println(v);
//        System.out.println(findMedianSortedArrays(new int[]{1, 2, 3, 4, 5, 6, 7, 7, 8, 9}, new int[]{4, 5, 5, 6, 7, 8, 9, 10}));
    }

    public static double findMedianSortedArrays(int[] a, int[] b) {
        int len = a.length + b.length;

        double mid1 = -1.0, mid2 = -1.0;
        int i = 0, j = 0, count = -1;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                mid1 = mid2;
                mid2 = a[i];
                System.out.println("i=" + i + " Mid1=" + mid1 + " " + "Mid2=" + mid2);
                i++;
            } else {
                mid1 = mid2;
                mid2 = b[j];
                System.out.println("j=" + j + " Mid1=" + mid1 + " " + "Mid2=" + mid2);
                j++;
            }
            count++;
            if (count >= ((len - 1) / 2) + 1) {
                break;
            }
        }

        while (i < a.length && count < ((len - 1) / 2) + 1) {
            mid1 = mid2;
            mid2 = a[i++];
            System.out.println("i=" + i + " Mid1=" + mid1 + " " + "Mid2=" + mid2);
            count++;
        }

        while (j < b.length && count < ((len - 1) / 2) + 1) {
            mid1 = mid2;
            mid2 = b[j++];
            System.out.println("j=" + j + " Mid1=" + mid1 + " " + "Mid2=" + mid2);
            count++;
        }
        return len % 2 == 1 ? mid1 == -1 ? mid2 : mid1 : (mid1 + mid2) / 2;
    }
}
