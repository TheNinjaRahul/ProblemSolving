package com.company.GFG.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedian {

    public static void main(String[] args) {
        insertHeap(5);
        System.out.println(getMedian());
        insertHeap(15);
        System.out.println(getMedian());
        insertHeap(1);
        System.out.println(getMedian());
        insertHeap(3);
        System.out.println(getMedian());
    }

    static PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> min = new PriorityQueue<>();

    // Function to insert heap
    public static void insertHeap(int x) {
        if (max.size() == 0) {
            max.add(x);
        } else if (max.peek() < x) {
            min.add(x);
        } else {
            max.add(x);
        }

        if (Math.abs(min.size() - max.size()) > 1) {
            balanceHeaps();
        }

    }

    // Function to balance Heaps
    public static void balanceHeaps() {
        if (Math.abs(min.size() - max.size()) > 1) {
            if (max.size() > min.size()) {
                min.add(max.remove());
            } else {
                max.add(min.remove());
            }
        }
    }

    // function to getMedian
    public static double getMedian() {
        if (min.size() == 0 && max.size() == 0) return -1;
        if (min.size() == 0 && max.size() == 1) return max.peek();
        if (min.size() == max.size()) {
            double x = max.peek();
            double y = min.peek();
            return (x + y) / 2;
        } else {
            if (max.size() > min.size()) {
                return max.peek();
            } else {
                return min.peek();
            }
        }
    }
}
