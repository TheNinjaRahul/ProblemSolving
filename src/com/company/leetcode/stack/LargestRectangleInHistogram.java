package com.company.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
//        int d[] = {2, 1, 5, 6, 2, 3};
        int d2[]={9,0};
        System.out.println(largestRectangleArea(d2));
    }

    public static int largestRectangleArea(int[] heights) {
        int rightmin[] = findRightMostMinElement(heights);
        int leftmin[] = findLeftMostMinElement(heights);

        int max = 0;
        for (int i = 0; i < rightmin.length; i++) {
            int h = heights[i] * (rightmin[i] - leftmin[i] - 1);
            if (h > max) {
                max = h;
            }
        }

        return max;
    }

    static class MyPair {
        int i;
        int value;

        public MyPair(int i, int value) {
            this.i = i;
            this.value = value;
        }

    }

    private static int[] findRightMostMinElement(int[] heights) {
        int output[] = new int[heights.length];
        int rightMost = heights.length;
        Stack<MyPair> s = new Stack<>();
        s.push(new MyPair(rightMost, 0));
//        output[heights.length-1]=0;
        for (int i = heights.length - 1; i >= 0; i--) {

            if (s.isEmpty()) {
                s.push(new MyPair(i, heights[i]));
            } else {
                while (!s.isEmpty() && s.peek().value >= heights[i]) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    output[i] = i;
                    s.push(new MyPair(i, heights[i]));
                } else {
                    output[i] = s.peek().i;
                    s.push(new MyPair(i, heights[i]));
                }
            }
        }
        return output;
    }

    private static int[] findLeftMostMinElement(int[] heights) {
        int output[] = new int[heights.length];
        int leftmost = -1;
        Stack<MyPair> s = new Stack<>();
        s.push(new MyPair(leftmost, 0));
//        output[heights.length-1]=0;
        for (int i = 0; i < heights.length; i++) {

            if (s.isEmpty()) {
                s.push(new MyPair(i, heights[i]));
            } else {
                while (!s.isEmpty() && s.peek().value >= heights[i]) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    output[i] = i;
                    s.push(new MyPair(i, heights[i]));
                } else {
                    output[i] = s.peek().i;
                    s.push(new MyPair(i, heights[i]));
                }
            }
        }
        return output;
    }
}
