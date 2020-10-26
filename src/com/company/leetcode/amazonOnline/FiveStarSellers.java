package com.company.leetcode.amazonOnline;

import java.util.List;
import java.util.PriorityQueue;

public class FiveStarSellers {
    public static void main(String[] args) {
        int[][] rating = {{4, 4}, {1, 2}, {3, 6}};
        System.out.println(FiveStarSellers.fiveStarReviews(rating, 77));
    }

    public static int fiveStarReviews(int[][] productRatings, int ratingsThreshold) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> diff(b) - diff(a));
        for (int i = 0; i < productRatings.length; i++) {
            queue.offer(productRatings[i]);
        }
        double currentRating = 0.0;
        for (int a[] : productRatings) {
            currentRating += 100 * a[0] / a[1];
        }

        int num = 0;
        while (currentRating < ratingsThreshold * productRatings.length) {
            num++;
            int[] temp = queue.remove();
            currentRating += (100 * (temp[0] + 1) / (temp[1] + 1)) - ((100 * temp[0]) / temp[1]);
            queue.offer(new int[]{temp[0] + 1, temp[1] + 1});
        }
        return num;
    }

    private static int diff(int[] a) {
        double currentRating = 100.0 * a[0] / a[1];
        double newCurrent = 100.0 * (a[0] + 1) / (a[1] + 1);
        return (int) (newCurrent - currentRating);
    }
}
