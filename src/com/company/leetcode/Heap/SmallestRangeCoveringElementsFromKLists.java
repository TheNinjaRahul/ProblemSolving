package com.company.leetcode.Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringElementsFromKLists {
    public static void main(String[] args) {

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


    public int[] smallestRange(List<List<Integer>> nums) {

        int k = nums.size();
        int range = Integer.MAX_VALUE;
        int a = 0, b = 0;

        PriorityQueue<MinMax> minQueue = new PriorityQueue<>((x, y) -> {
            return -(y.val - x.val);
        });

        PriorityQueue<MinMax> maxQueue = new PriorityQueue<>((x, y) -> {
            return y.val - x.val;
        });


        for (int i = 0; i < k; i++) {
            MinMax minMax = new MinMax(i, nums.get(i).get(0));
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

            if (min.index + 1 == nums.get(min.arrayIndex).size()) break;
            min.val = nums.get(min.arrayIndex).get(min.index + 1);
            min.index++;
            minQueue.add(min);
            maxQueue.add(max);
            maxQueue.add(min);
        }
        return new int[]{a, b};
    }
}
