package com.company.GFG.Heap;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int data[] = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(data, 2));
    }

    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            return -(b - a);
        });
        for (int i : nums) {
            queue.add(i);
            if (queue.size() > k) queue.remove();
        }
        return queue.remove();
    }
}
