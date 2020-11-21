package com.company.leetcode.binarySearch;

public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
    }

    public static int shipWithinDays(int[] weights, int D) {
        int end = 0;
        for (int w : weights) {
            end += w;
        }
        int sum = end;
        int start = 0;
        int mid = 0;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (help(mid, weights, D, sum)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    public static boolean help(int load, int[] w, int D, int s) {
        int sum = 0;
        int reqDays = 1;
        int initialLoad = load;
        for (int i : w) {
            if (i <= load) {
                load -= i;
            } else {
                load = initialLoad - i;
                reqDays++;
            }
            if (i <= initialLoad) {
                sum += i;
            }
        }
        return reqDays <= D && sum == s;
    }
}
