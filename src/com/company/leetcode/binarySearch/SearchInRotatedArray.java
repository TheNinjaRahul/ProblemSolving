package com.company.leetcode.binarySearch;

public class SearchInRotatedArray {

    public static void main(String[] args) {
        System.out.println(search(new int[]{3, 1}, 1));
    }

    public static int search(int[] a, int target) {
        int low = 0, high = a.length - 1;
        int mid = -1;
        int ans = -1;

        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] == target) {
                ans = mid;
                break;
            }

            if (a[low] <= a[mid]) {
                if (a[low] <= target && a[mid] >= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (a[mid] <= target && a[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return ans;
    }
}
