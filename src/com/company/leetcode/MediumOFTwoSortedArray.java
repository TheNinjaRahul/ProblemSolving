package com.company.leetcode;

public class MediumOFTwoSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{};//{23, 26, 31, 35}; //{1,3,8,9,15};//
        int[] nums2 = new int[]{2,3};//{3, 5, 7, 9, 11, 16};//{7,11,18,19,21,25};//;

        System.out.println(findMedianSortedArrays(nums1, nums2));

    }



    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length;
        int y = nums2.length;

        if(y<x){
            return findMedianSortedArrays(nums2,nums1);
        }
        if (x == 0 && y == 0) {
            return 0;
        }
        if (x == 0 && y != 0) {
            if(y==1){
                return (double) nums2[0];
            }
            if (y % 2 == 0) {
                int mid = y / 2;
                return (double)(nums2[mid] + nums2[mid - 1]) / 2;

            } else {
                return (double)nums2[y / 2];
            }

        }
        if (y == 0 && x != 0) {
            if (x % 2 == 0) {
                return (double)nums1[x / 2];
            } else {
                int mid = x / 2;
                return (double)(nums1[mid] + nums1[mid - 1]) / 2;
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
}
