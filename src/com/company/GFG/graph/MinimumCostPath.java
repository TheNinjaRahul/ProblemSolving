package com.company.GFG.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumCostPath {
    public static void main(String[] args) {

        int data2[][] = {{42, 93}, {07, 14}};
        System.out.println(shortest(data2, 0));

        int[][] data = {{31, 100, 65, 12, 18},
                {10, 13, 47, 157, 6},
                {100, 113, 174, 11, 33},
                {88, 124, 41, 20, 140},
                {99, 32, 111, 41, 20}};
        System.out.println(shortest(data, 0));
    }

    static class MPNode {
        int x, y, dist;

        MPNode(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.dist = d;
        }

        @Override
        public String toString() {
            return "MPNode{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dist=" + dist +
                    '}';
        }
    }

    public static int shortest(int grid[][], int q) {
        int x[] = {-1, 1, 0, 0};
        int y[] = {0, 0, 1, -1};
        int m = grid.length;
        int n = grid[0].length;
        int[][] output = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                output[i][j] = Integer.MAX_VALUE;
            }
        }
        output[0][0] = grid[0][0];

        Queue<MPNode> queue = new PriorityQueue<MPNode>((a, b) -> (a.dist - b.dist));
        queue.add(new MPNode(0, 0, grid[0][0]));
        while (!queue.isEmpty()) {
            MPNode node = queue.remove();
            dfs(node, output, grid, m, n, queue, visited, x, y);
            visited[node.x][node.y] = true;
            if (node.x == m - 1 && node.y == n - 1) {
                return output[m - 1][n - 1];
            }
        }
        return output[m - 1][n - 1];
    }

    private static void dfs(MPNode node, int[][] output, int[][] grid, int m, int n, Queue<MPNode> queue, boolean[][] visited, int[] x, int[] y) {
        if (visited[node.x][node.y]) return;
        for (int i = 0; i < x.length; i++) {
            int xx = x[i] + node.x;
            int yy = y[i] + node.y;

            if (xx < 0 || xx >= m || yy < 0 || yy >= n) continue;
            if (visited[xx][yy]) continue;

            if (output[xx][yy] == Integer.MAX_VALUE) {
                output[xx][yy] = grid[xx][yy] + node.dist;
                queue.add(new MPNode(xx, yy, output[xx][yy]));
            } else {
                if (node.dist + output[xx][yy] < output[xx][yy]) {
                    List<MPNode> nodes = new LinkedList<>();
                    while (true) {
                        MPNode temp = queue.remove();
                        if (temp.x == xx && temp.y == yy) {
                            temp.dist = node.dist + output[xx][yy];
                            queue.add(temp);
                            break;
                        } else {
                            nodes.add(temp);
                        }
                    }
                    for (MPNode nn : nodes) {
                        queue.add(nn);
                    }
                    output[xx][yy] = Math.min(node.dist + output[xx][yy], output[xx][yy]);
                }
            }
        }
    }

}
