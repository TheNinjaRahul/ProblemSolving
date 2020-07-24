package com.company.GFG.Heap;

import java.util.*;

public class Heap {
    public static void main(String[] args) {
        int[] data = {12, 5, 787, 1, 23};
        System.out.println(kLargest(data, 5, 2));
    }



    public static ArrayList<Integer> kLargest(int arr[], int n, int k) {


        Comparator<Integer> reverse = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -(o1 - o2);
            }
        };

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            return -(b - a);
        });
        for (int i : arr) {
            queue.add(i);
            if (queue.size() > k) queue.remove();
        }
        LinkedList<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            list.addFirst(queue.poll());
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.addAll(list);
        return result;
    }
}
