package com.company.leetcode.array;

import java.util.*;

public class RemoveDuplicateFromArray {

    //we can use Set<Integer> and return size
    public static void main(String[] args) {
        int data[] = {-1, -1, -1, 1, 1, 1, 1};
        System.out.println(removeDuplicates(data));
    }

    public static int removeDuplicates(int[] nums) {

//           int[] data= list.toArray();
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];

            }
        }

        return j + 1;
    }
}
