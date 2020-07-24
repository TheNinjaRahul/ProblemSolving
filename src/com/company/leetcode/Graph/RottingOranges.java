package com.company.leetcode.Graph;

import org.omg.CORBA.INTERNAL;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/rotting-oranges/
 */

public class RottingOranges {
    public static void main(String[] args) {

        int[][] data3 = {{0, 2}};
        System.out.println(orangesRotting(data3));

        int[][] data2 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        System.out.println(orangesRotting(data2));

        int[][] data = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(data));

    }


    /*

     */


    static class RottenPair {
        int i;
        int j;

        public RottenPair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    /**
     * the value 0 representing an empty cell;
     * the value 1 representing a fresh orange;
     * the value 2 representing a rotten orange.
     *
     * @param grid
     * @return
     */

    public static int orangesRotting(int grid[][]) {
        List<String> list = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        Queue<RottenPair> queue = new LinkedList<>();
        int total = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 2) total++;
                if (grid[i][j] == 2) {
                    queue.add(new RottenPair(i, j));
                }
            }
        }
        if (total == 0) return 0;
        int result = bfs(queue, grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return result;
    }

    private static int bfs(Queue<RottenPair> queue, int[][] grid) {
        int count = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                RottenPair rottenPair = queue.remove();
                int i = rottenPair.i;
                int j = rottenPair.j;
                if (j > 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    queue.add(new RottenPair(i, j - 1));
                }
                if (i > 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    queue.add(new RottenPair(i - 1, j));
                }
                if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    queue.add(new RottenPair(i, j + 1));
                }

                if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    queue.add(new RottenPair(i + 1, j));
                }
            }
            count++;
        }
        return count;
    }
}
