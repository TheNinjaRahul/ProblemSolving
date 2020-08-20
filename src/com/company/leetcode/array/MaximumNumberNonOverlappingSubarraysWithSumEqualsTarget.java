package com.company.leetcode.array;

import org.omg.CORBA.MARSHAL;

import javax.swing.text.MutableAttributeSet;
import java.util.*;

public class MaximumNumberNonOverlappingSubarraysWithSumEqualsTarget {
    public static void main(String[] args) {

        int n2[] = {-1, 3, 5, 1, 4, 2, -9};
        System.out.println("2=" + maxNonOverlapping(n2, 6));

        int n4[] = {0, 0, 0};
        System.out.println("3=" + maxNonOverlapping(n4, 0));

        int[] n5 = {-5, 5, -4, 5, 4};
        System.out.println("2=" + maxNonOverlapping(n5, 5));

        int n3[] = {-2, 6, 6, 3, 5, 4, 1, 2, 8};
        System.out.println("3=" + maxNonOverlapping(n3, 10));


        int[] n1 = {1, 1, 1, 1, 1};
        System.out.println("2=" + maxNonOverlapping(n1, 2));


    }

    public static int maxNonOverlapping(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        int sum = 0;
        int count = 0;
        set.add(0);
        for (int n : nums) {

            sum += n;
            if (set.contains(sum - target)) {
                count++;
                sum = 0;
                set.clear();
                set.add(0);
            } else {
                set.add(sum);
            }
        }
        return count;
    }

    public static int maxNonOverlapping2(int[] nums, int target) {

        if (nums.length == 0) return 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int sum = nums[i];
            if (sum == target) {
                ans = Math.max(ans + 1, maxNonOverlapping(Arrays.copyOfRange(nums, i + 1, nums.length), target));
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {

                if (sum + nums[j] == target) {
                    count = 1 + maxNonOverlapping(Arrays.copyOfRange(nums, j + 1, nums.length), target);
                    ans = Math.max(count, ans);
                    break;
                }
                sum += nums[j];
            }
            ans = Math.max(count, ans);
        }
        return ans;
    }
}
