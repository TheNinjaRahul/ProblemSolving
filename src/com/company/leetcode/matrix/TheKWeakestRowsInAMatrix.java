package com.company.leetcode.matrix;

import java.util.PriorityQueue;
import java.util.Queue;

public class TheKWeakestRowsInAMatrix {
    public static void main(String[] args) {

    }

    public int[] kWeakestRows(int[][] mat, int k) {
        Queue<int[]> q = new PriorityQueue<>((a, b) -> {
            int diff = a[0] - b[0];
            if (diff == 0) {
                return a[1] - b[1];
            }
            return diff;
        });

        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) count++;
            }
            q.add(new int[]{count, i});
        }

        int ans[] = new int[k];
        int j = 0;
        while (k > 0) {
            int a[] = q.remove();
            ans[j++] = a[1];
            k--;
        }
        return ans;
    }

}
