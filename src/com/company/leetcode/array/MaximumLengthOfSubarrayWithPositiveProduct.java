package com.company.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class MaximumLengthOfSubarrayWithPositiveProduct {
    public static void main(String[] args) {

        int d3[] = {-1, -2, -3, 0, 1};
        System.out.println(getMaxLen(d3));


        int d2[] = {0, 1, -2, -3, -4};
        System.out.println(getMaxLen(d2));

        int[] d = {1, -2, -3, 4};
        System.out.println(getMaxLen(d));
    }


    public static int getMaxLen(int[] nums) {

        if (nums.length == 0) return 0;
        if (nums.length == 1 && nums[0] < 0) return 0;

        long product[] = new long[nums.length];
        long p = 1l;
        for (int i = 0; i < nums.length; i++) {
            if (p == 0) {
                p = nums[i];
                product[i] = p;
                continue;
            }
            p *= nums[i];
            if (p == 0) {
                product[i] = 0;
            } else if (p < 0) {
                product[i] = p / nums[i];
            } else {
                product[i] = p;
            }

        }

        int si = 0;
        long max = 0l;
        int res = 0;
        for (int i = 0; i < product.length; i++) {
            if (product[i] > max) {
                if (res < (i - si + 1)) {
                    res = i - si + 1;
                }
            }
        }
        return res;

        /*long max = 0l;
        int startIndex = 0;
        int l = 0;
        boolean indexChanged = false;
        for (int i = 0; i < product.length; i++) {
            if (product[i] == 0) {
                startIndex = i;
                max = 0l;
                indexChanged = true;
                continue;
            }
            if (max < product[i]) {
                max = product[i];

                if (indexChanged) {
                    if (l < (i - startIndex)) {
                        l = i - startIndex;
                    }
                } else {
                    if (l < (i - startIndex + 1)) {
                        l = i - startIndex;
                    }
                }

            }
        }*/
//        return 0;

    }
}
