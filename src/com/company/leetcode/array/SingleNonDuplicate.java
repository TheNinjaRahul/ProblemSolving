package com.company.leetcode.array;

/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 */
public class SingleNonDuplicate {
    public static void main(String[] args) {
    }

    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        int mid = -1;
        while (l <= r) {
            mid = (l + r) / 2;

            if (mid == 0 || mid == nums.length - 1) {
                return nums[mid];
            }
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;

    }

    public int singleNonDuplicate2(int[] nums) {
        int r = -1;
        for (int i = 0; i < nums.length; i += 2) {
            if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                continue;
            } else {
                r = nums[i];
                break;
            }
        }
        return r;
    }
}
