package com.company.GFG.Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class mergeKArrays {
    public static void main(String[] args) {
        int[][] data = {{1, 2, 3, 4},
                {2, 2, 3, 4},
                {5, 5, 6, 6},
                {7, 8, 9, 9}};
        System.out.println(mergeKArrays(data, 4));
    }

    static class MergeClass {
        int arrayIndex;
        int val;
        int index = 0;

        public MergeClass(int arrayIndex, int val) {
            this.arrayIndex = arrayIndex;
            this.val = val;
        }
    }

    public static ArrayList<Integer> mergeKArrays(int[][] arrays, int k) {
        PriorityQueue<MergeClass> queue = new PriorityQueue<>((a, b) -> {
            return -(b.val - a.val);
        });

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            queue.add(new MergeClass(i, arrays[i][0]));
        }
        while (!queue.isEmpty()) {
            MergeClass temp = queue.remove();
            list.add(temp.val);
            if (temp.index + 1 != k) {
                temp.index++;
                temp.val = arrays[temp.arrayIndex][temp.index];
                queue.add(temp);
            }
        }
        return list;
    }
}
