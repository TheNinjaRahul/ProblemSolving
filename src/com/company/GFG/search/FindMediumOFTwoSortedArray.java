package com.company.GFG.search;

import java.util.Arrays;

public class FindMediumOFTwoSortedArray {
    public static void main(String[] args) {
        int[] c = {1, 5, 9};
        int[] d = {2, 3, 6, 7,};
        System.out.println(findLikeGFG(c, d));
        int[] a = {4, 6};
        int[] b = {1, 2, 3, 5};

        System.out.println(findLikeGFG(a, b));
    }


    public static double find(int[] nums1, int[] nums2) {

        int x = nums1.length;
        int y = nums2.length;

        if (y < x) {
            return find(nums2, nums1);
        }
        if (x == 0 && y == 0) {
            return 0;
        }
        if (x == 0 && y != 0) {
            if (y == 1) {
                return (double) nums2[0];
            }
            if (y % 2 == 0) {
                int mid = y / 2;
                return (double) (nums2[mid] + nums2[mid - 1]) / 2;

            } else {
                return (double) nums2[y / 2];
            }

        }
        if (y == 0 && x != 0) {
            if (x % 2 == 0) {
                return (double) nums1[x / 2];
            } else {
                int mid = x / 2;
                return (double) (nums1[mid] + nums1[mid - 1]) / 2;
            }
        }


        int low = 0;
        int high = x;
//        int partionX=(low+high)/2;
//        int partionY=((nums1.length+nums2.length+1)-partionX)/2;
        int xl = Integer.MIN_VALUE, xr = Integer.MIN_VALUE, yl = Integer.MIN_VALUE, yr = Integer.MIN_VALUE;

        while (low <= high) {
            int partionX = (low + high) / 2;
            int partionY = ((x + y + 1) / 2) - partionX;
            xl = (partionX == 0) ? Integer.MIN_VALUE : nums1[partionX - 1];
            yl = (partionY == 0) ? Integer.MIN_VALUE : nums2[partionY - 1];
            xr = (partionX == x) ? Integer.MAX_VALUE : nums1[partionX];
            yr = (partionY == y) ? Integer.MAX_VALUE : nums2[partionY];

            if (xl <= yr && yl <= xr) {
                if ((x + y) % 2 == 0) {
                    return (double) (Math.max(xl, yl) + Math.min(xr, yr)) / 2;
                } else {
                    return (Math.max(xl, yl));
                }
            } else if (xr > yl) {
                high = partionX - 1;
            } else {
                low = partionX + 1;
            }
        }

        return 0;

    }


    public static double findLikeGFG(int a[], int b[]) {
        int m = a.length, n = b.length;
        if (m == 0 && n == 0) {
            return 0;
        }
        if (m == 0 && n != 0) {
            if (n == 1) {
                return (double) b[0];
            }
            if (n % 2 == 0) {
                int mid = n / 2;
                return (double) (b[mid] + b[mid - 1]) / 2;

            } else {
                return (double) b[n / 2];
            }

        }
        if (n == 0 && m != 0) {
            if (m % 2 == 0) {
                return (double) a[m / 2];
            } else {
                int mid = m / 2;
                return (double) (a[mid] + a[mid - 1]) / 2;
            }
        }


        double x = -1, last = 0;
        int mid = (a.length + b.length) / 2;
        int count = 0;
        int p1 = 0, p2 = 0;
        while (p1 < a.length && p2 < b.length && count < mid) {
            if (a[p1] <= b[p2]) {
                last = a[p1++];
            } else {
                last = b[p2++];
            }
            count++;
        }
        if (count < mid) {
            while (count < mid && p1 < a.length) {
                last = a[p1++];
            }
            while (count < mid && p2 < a.length) {
                last = b[p2++];
            }
        }
        if (a[p1] <= b[p2]) {
            x = a[p1++];
        } else {
            x = b[p2++];
        }

        if ((a.length + b.length) % 2 != 0) {
            return x;
        } else {
            return (double) (x + last) / 2;
        }
//        return  ? x : (double)
    }

    public static double findMedian(int a[], int b[]) {
        Arrays.sort(a);
        Arrays.sort(b);
        if (a.length < b.length) {
            return findMedian(b, a);
        }

        int x = a.length, y = b.length, xl = 0, xr = 0, px = 0, py = 0, yl = 0, yr = 0, low = 0, high = x;

        while (low <= high) {
            px = (low + high) / 2;
            py = ((x + y + 1) / 2) - px;
            xl = px == 0 ? Integer.MIN_VALUE : a[px - 1];
            yl = py == 0 ? Integer.MIN_VALUE : b[py - 1];
            xr = px == x ? Integer.MAX_VALUE : a[px];
            yr = py == y ? Integer.MAX_VALUE : b[py];

            if (xl <= yr && yl <= xr) {
                if ((x + y) % 2 == 0) {
                    return (double) (Math.max(xl, yl) + Math.min(xr, yr)) / 2;
                } else {
                    return Math.max(xl, yl);
                }
            }
            if (xl > yr) {
                high = px - 1;
            } else {
                low = px + 1;
            }
        }
        return 0;
    }
}
