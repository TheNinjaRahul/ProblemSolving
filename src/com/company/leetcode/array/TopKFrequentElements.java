package com.company.leetcode.array;

import org.omg.CORBA.INTERNAL;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
//        int data[] = {-1, -1};
//        int data[] = {1, 1, 1, 2, 2, 3};
//        int data[] = {1, 1, 2, 2, 2, 3, 3, 3};
//        int data[] = {5, 3, 1, 1, 1, 3, 73, 1};
        int data[] = {4, 1, -1, 2, -1, 2, 3};
        System.out.println(Arrays.toString(topKFrequent(data, 2)));
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                int v = map.get(i);
                v++;
                map.put(i, v);
            } else {
                map.put(i, 1);
            }
        }

        System.out.println(map);
        List<Integer> value = new LinkedList<>();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            value.add(e.getValue());
        }
        Collections.sort(value, Collections.reverseOrder());

        int[] result = new int[k];
        int i = 0;
        int fetchSortedIndex = 0;
        while (fetchSortedIndex < k) {
            int deleteKey = 0;
            boolean needToDelete = false;
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                if (e.getValue() == value.get(fetchSortedIndex)) {
                    result[i++] = e.getKey();
                    fetchSortedIndex++;
                    deleteKey = e.getKey();
                    needToDelete = true;
                    break;
                }
            }
            if (needToDelete) map.remove(deleteKey);
        }

        return result;
    }


    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        Queue<Integer> queue = new PriorityQueue<>((n1, n2) -> {
            return map.get(n1) - map.get(n2);
        });

        for (int n : map.keySet()) {
            queue.add(n);
            if (queue.size() > k) queue.poll();
        }
        int[] top = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            top[i] = queue.remove();
        }
        return top;

    }
}
