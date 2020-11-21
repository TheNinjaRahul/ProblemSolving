package com.company.leetcode.binarySearch;

public class SearchInRotatedArrayII {
    public static void main(String[] args) {

    }

    public boolean search(int[] a, int target) {
        int low = 0;
        int high = a.length - 1;
        int mid = 0;
        while (low <= high) {
            while (low < high && a[low] == a[low + 1]) {
                low++;
            }
            while (low < high && a[high] == a[high - 1]) {
                high--;
            }

            mid = (low + high) / 2;
            if (a[mid] == target) return true;
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
        return false;
    }

}
