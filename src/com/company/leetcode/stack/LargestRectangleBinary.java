package com.company.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleBinary {
    public static void main(String[] args) {
//        int[][] data={{0,1,1,0},{1,1,1,1},{1,1,1,1},{1,1,0,0}};\
        int [][]data={{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
        LargestRectangleBinary l=new LargestRectangleBinary();
        System.out.println(l.maxArea(data,9,9));
    }

    public int maxArea(int M[][], int m, int n) {
        int a[]=new int[M[0].length];
        int max=0;
        for(int i=0;i<M.length;i++){
            for(int j=0;j<M[0].length;j++){
                if(M[i][j]==0){
                    a[j]=0;
                }else {
                    a[j]=a[j]+1;
                }
            }
            int s=largestRectangleArea(a);
            if(s>max){
                max=s;
            }
        }
        return max;
    }

    public  int largestRectangleArea(int[] heights) {
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

    class MyPair {
        int i;
        int value;

        public MyPair(int i, int value) {
            this.i = i;
            this.value = value;
        }

    }

    public  int[] findRightMostMinElement(int[] heights) {
        int output[] = new int[heights.length];
        int rightMost = heights.length;
        Stack<LargestRectangleInHistogram.MyPair> s = new Stack<>();
        s.push(new LargestRectangleInHistogram.MyPair(rightMost, 0));
//        output[heights.length-1]=0;
        for (int i = heights.length - 1; i >= 0; i--) {

            if (s.isEmpty()) {
                s.push(new LargestRectangleInHistogram.MyPair(i, heights[i]));
            } else {
                while (!s.isEmpty() && s.peek().value >= heights[i]) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    output[i] = i;
                    s.push(new LargestRectangleInHistogram.MyPair(i, heights[i]));
                } else {
                    output[i] = s.peek().i;
                    s.push(new LargestRectangleInHistogram.MyPair(i, heights[i]));
                }
            }
        }
        return output;
    }

    public int[] findLeftMostMinElement(int[] heights) {
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
