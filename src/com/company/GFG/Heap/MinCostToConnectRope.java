package com.company.GFG.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinCostToConnectRope {
    public static void main(String[] args) {
        long[] data2 = {4l, 2l, 7l, 6l, 9l};
        minCost(data2, data2.length);

        long[] data = {4l, 3l, 2l, 6l};
        minCost(data, data.length);
    }

    static void minCost(long arr[], int n) {
        if (arr.length == 1) {
            System.out.println(0);
            return;
        }

        PriorityQueue<Long> queue = new PriorityQueue<>((a, b) ->
                (int) -(b - a));
        long sum = 0;
        long cost = 0;
        for (long i : arr) {
            queue.add(i);
        }
        while (queue.size() != 1) {
            sum = queue.remove() + queue.remove();
            cost += sum;
            queue.add(sum);
        }
        System.out.println(cost);
    }
}
