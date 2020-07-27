package com.company.GFG.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class MinimumSwapsToSort {
    public static void main(String[] args) {
//        int[] data = {8, 9, 16, 15};
//        int[] data = {1, 5, 4, 3, 2};
        int[] data = {0, 2, 3, 4, 1, 6, 5};
        System.out.println(minSwaps(data, 0));
    }

    public static int minSwaps(int[] arr, int N) {
        int[] sorted = Arrays.copyOfRange(arr, 0, arr.length);
//        System.out.println(Arrays.toString(sorted));
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(sorted[i], i);
        }

        boolean[] expectedPosition = new boolean[arr.length];

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (expectedPosition[i]) continue;
            int count = 0;
            while (!expectedPosition[i] && map.get(arr[i]) != i) {
                expectedPosition[i] = true;
                i = map.get(arr[i]);
                count++;
            }
            if (count != 0) sum += count - 1;
        }
        return sum;
    }
}
