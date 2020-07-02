package com.company.GFG.search;

import java.util.Arrays;

public class FindMissingPositiveNumber {
    public static void main(String[] args) {
        int data[] = {-47, 1, 4, 49, -18, 10, 26, 18, -11, -38, -24, 36, 44, -11, 45, 20, -16, 28, 17, -49, 47, -48, -33, 42, 2, 6, -49, 30, 36, -9, 15, 39, -6, -31, -10, -21, -19, -33, 47, 21, 31, 25, -41, -23, 17, 6, 47, 3, 36, 15, -44, 33, -31, -26, -22, 21, -18, -21, -47, -31, 20, 18, -42, -35, -10, -1, 46, -27, -32, -5, -4, 1, -29, 5, 29, 38, 14, -22, -9, 0, 43, -50, -16, 14, -26};
//        System.out.println(findMissing(data,data.length));

        int data3[] = {1, 2, 3, 4, 5};
        System.out.println(findMissing(data3, data3.length));

        int data2[] = {0, -10, 1, 3, -20};
        System.out.println(findMissing(data2, data2.length));
    }

    static int findMissing(int a[], int n) {

        Arrays.sort(a);
        int index = binarySearch(0, a.length - 1, a, 1);
        if (index == -1) return 1;
        int count = 1;
        for (int i = index; i < n; i++) {
            if (count == a[i]) {
                continue;
            } else {
                if (count + 1 == a[i]) {
                    count++;
                } else {
                    return count + 1;
                }
            }
        }
        return count + 1;

    }

    public static int binarySearch(int start, int end, int[] b, int i) {
        int mid = 0;
        while (start <= end) {
            mid = start + ((end - start) / 2);
            if (b[mid] == i) {
                if (mid < b.length - 1 && b[mid] == b[mid + 1]) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            }
            if (b[mid] > i) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


    public int firstMissingPositive(int[] nums) {

        for (int i = 0;i < nums.length; i++) {
            if (nums[i] < 0) nums[i] = 0;
        }

        for (int i = 0;i < nums.length; i++) {
            int targetIndex = Math.abs(nums[i]) - 1;
            if (targetIndex >= 0 && targetIndex < nums.length) {
                if (nums[targetIndex] == 0) nums[targetIndex] = Integer.MAX_VALUE;
                nums[targetIndex] = Math.abs(nums[targetIndex]) * -1;
            }
        }
        // check if any value is not visited
        for (int i = 0;i < nums.length; i++) {
            if (nums[i] >= 0) return i + 1;
        }

        return nums.length + 1;
    }
}
