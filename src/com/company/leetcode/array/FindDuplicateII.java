package com.company.leetcode.array;

import java.util.LinkedList;
import java.util.List;

public class FindDuplicateII {
    public static void main(String[] args) {
        int[] data = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(data));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int j = Math.abs(nums[i]) - 1;
            if (nums[j] < 0) {
                list.add(j+1);
            } else {
                nums[j] = -nums[j];
            }
        }
        return list;
    }
}
