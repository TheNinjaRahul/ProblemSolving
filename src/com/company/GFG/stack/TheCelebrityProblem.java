package com.company.GFG.stack;

import javafx.collections.MapChangeListener;

import java.util.Stack;

public class TheCelebrityProblem {
    public static void main(String[] args) {
        int data[][] = {{0, 1, 0}, {0, 0, 0}, {0, 1, 0}};
        int d[][] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int d1[][]={{0,1},{1,0}};

        TheCelebrityProblem t = new TheCelebrityProblem();
        System.out.println(t.getId(d1,2));
        System.out.println(t.getId(d, 3));
        System.out.println(t.getId(data, 3));
    }

    int getId(int M[][], int n) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < M.length; i++) {
            s.push(i);
        }

        while (s.size() != 1) {
            int a = s.pop();
            int b = s.pop();

            if (isKnows(a, b, M)) {
                s.push(b);
            } else {
                s.push(a);
            }
        }

        int c=s.pop();

        for(int i=0;i< M.length;i++){
            if (i != c && (isKnows(c, i,M) ||
                    (!isKnows(i, c,M))))
                return -1;
        }
        return c;
    }

    private boolean isKnows(int a, int b, int[][] m) {
        return m[a][b] == 1 ? true : false;
    }
}
