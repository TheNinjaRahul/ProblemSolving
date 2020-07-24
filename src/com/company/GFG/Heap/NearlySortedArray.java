package com.company.GFG.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class NearlySortedArray {
    public static void main(String[] args) {


    }

    ArrayList<Integer> nearlySorted(int arr[], int num, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k == arr.length) {
            for (int i = arr.length - 1; i >= 0; i--) {
                list.add(arr[i]);
            }
            return list;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < k + 1; i++) {
            queue.add(arr[i]);
        }

        int index = 0;
        for (int i = k + 1; i < arr.length; i++) {
            list.add(queue.poll());
            queue.add(arr[i]);
        }

        while (!queue.isEmpty()) {
            list.add(queue.remove());
        }
        return list;
    }
}
