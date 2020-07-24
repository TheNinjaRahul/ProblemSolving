package com.company.GFG.Heap;

import java.util.ArrayList;
import java.util.Objects;
import java.util.PriorityQueue;

public class SmallestRangeInKLists {
    public static void main(String[] args) {
        int data[][] = {{1, 3, 5, 7, 9}, {0, 2, 4, 6, 8}, {2, 3, 5, 7, 11}};
        findSmallestRange(data, 5, 3);
    }

    static class MinMax {
        int arrayIndex;
        int val;
        int index = 0;

        public MinMax(int arrayIndex, int val) {
            this.arrayIndex = arrayIndex;
            this.val = val;
        }

        @Override
        public String toString() {
            return "MinMax{" +
                    "arrayIndex=" + arrayIndex +
                    ", val=" + val +
                    ", index=" + index +
                    '}';
        }

    }


    static void findSmallestRange(int[][] arr, int n, int k) {

        int range = Integer.MAX_VALUE;
        int a = 0, b = 0;

        PriorityQueue<MinMax> minQueue = new PriorityQueue<>((x, y) -> {
            return -(y.val - x.val);
        });

        PriorityQueue<MinMax> maxQueue = new PriorityQueue<>((x, y) -> {
            return y.val - x.val;
        });

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            MinMax minMax = new MinMax(i, arr[i][0]);
            maxQueue.add(minMax);
            minQueue.add(minMax);
        }

        while (!maxQueue.isEmpty() && !minQueue.isEmpty()) {
            MinMax min = minQueue.remove();
            MinMax max = maxQueue.remove();
            int newrange = max.val - min.val;
            if (newrange < range) {
                range = newrange;
                a = min.val;
                b = max.val;
            }
            maxQueue.remove(min);
//            minQueue.remove(min);

            if (min.index + 1 == n) break;
            min.val = arr[min.arrayIndex][min.index + 1];
            min.index++;
            minQueue.add(min);
            maxQueue.add(max);
            maxQueue.add(min);
        }
        System.out.println(a + " " + b);
    }
}
