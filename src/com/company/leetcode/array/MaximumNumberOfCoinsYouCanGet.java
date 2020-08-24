package com.company.leetcode.array;

import java.util.Arrays;

public class MaximumNumberOfCoinsYouCanGet {
    public static void main(String[] args) {
        int[] d = {9, 8, 7, 6, 5, 1, 2, 3, 4};
        Arrays.sort(d);
        System.out.println(maxCoins(d));
    }

    public static int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int sum = 0;
        int index = piles.length;
        int count = piles.length / 3;

        while (count > 0) {
            index -= 2;
            sum += piles[index];
            count--;
        }

        return sum;
    }
}
