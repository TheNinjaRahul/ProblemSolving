package com.company.leetcode.Graph;

import javax.swing.*;
import java.util.*;

public class ZeroOneMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        updateMatrix(matrix);
        for (int[] m : matrix) {
            System.out.println(Arrays.toString(m));
        }
    }

    //Distance of nearest Zero


    public static int[][] updateMatrix(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i - 1, j});
                    queue.add(new int[]{i, j - 1});
                    queue.add(new int[]{i + 1, j});
                    queue.add(new int[]{i, j + 1});
                }
            }
        }
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int pair[] = queue.remove();
                int x = pair[0];
                int y = pair[1];
                if ((0 <= x && x < matrix.length && 0 <= y && y < matrix[0].length) && !visited[x][y] && matrix[x][y] != 0) {
                    visited[x][y] = true;
                    matrix[x][y] = level;
                    queue.add(new int[]{x + 1, y});
                    queue.add(new int[]{x - 1, y});
                    queue.add(new int[]{x, y + 1});
                    queue.add(new int[]{x, y - 1});
                }
            }
            level++;
        }

        return matrix;
    }

    private static boolean check(int i, int c, int[][] matrix) {
        if (0 > i || i >= matrix.length || c < 0 || c >= matrix[0].length) return false;
        return true;
    }
}
