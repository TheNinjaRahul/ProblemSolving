package com.company.leetcode.array;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberofWaysWhereSquareofNumberIsEqualtoProductofTwoNumbers {
    public static void main(String[] args) {
        int[] a = {43024, 99908};
        int[] a2 = {1864};
        System.out.println(numTriplets(a, a2));
    }


    public static int numTriplets(int[] nums1, int[] nums2) {
        int count = 0;
        Map<Long, Integer> map1 = new HashMap<Long, Integer>();
        Map<Long, Integer> map2 = new HashMap<Long, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                Long key = (1l * nums1[i]) * nums1[j];
                map1.put(key, map1.getOrDefault(key, 0) + 1);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            for (int j = i + 1; j < nums2.length; j++) {
                Long key = (1l * nums2[i]) * nums2[j];
                map2.put(key, map2.getOrDefault(key, 0) + 1);
            }
        }


        for (int i = 0; i < nums1.length; i++) {
            if (map2.containsKey((1l * nums1[i]) * nums1[i])) {
                count += map1.get((1l * nums1[i]) * nums1[i]);
            }
        }
        System.out.println(count);

        for (int i = 0; i < nums2.length; i++) {
            if (map1.containsKey((1l * nums2[i]) * nums2[i])) {
                count += map2.get((1l * nums2[i]) * nums2[i]);
            }
        }
        System.out.println(count);

        return count;
    }


    public static int numTriplets1(int[] nums1, int[] nums2) {
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                for (int k = j + 1; k < nums2.length; k++) {
                    if (Math.pow(nums1[i], 2) * (1l) == ((1l) * (nums2[j])) * nums2[k]) {
                        count++;
                    }
                }
                for (int k = i + 1; k < nums2.length; k++) {
                    if (Math.pow(nums2[j], 2) * (1l) == ((1l) * (nums1[i])) * nums1[k]) {
                        count++;
                    }
                }

            }
        }

       /* for (int i = 0; i < nums2.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                for (int k = j + 1; k < nums1.length; k++) {
                    if (Math.pow(nums2[i], 2) * (1l) == ((1l) * nums1[j]) * nums1[k]) {
                        count++;
                    }
                }
            }
        }*/
        return count;
    }
}
