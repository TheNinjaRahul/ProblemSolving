package com.company.leetcode.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedian {

    public static void main(String[] args) {
        FindMedian f = new FindMedian();
        f.addNum(1);
        f.addNum(2);
        System.out.println(f.findMedian());
        f.addNum(3);
        System.out.println(f.findMedian());
    }

    PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> min = new PriorityQueue<>();

    public void addNum(int x) {
        if (max.size() == 0) {
            max.add(x);
        } else if (max.peek() < x) {
            min.add(x);
        } else {
            max.add(x);
        }

        if (Math.abs(min.size() - max.size()) > 1) {
            if (max.size() > min.size()) {
                min.add(max.remove());
            } else {
                max.add(min.remove());
            }
        }

    }

    public double findMedian() {
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
