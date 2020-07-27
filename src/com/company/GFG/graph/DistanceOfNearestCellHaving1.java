package com.company.GFG.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHaving1 {

    public static void main(String[] args) {

        int data[][] = {{0, 1}, {1, 0}};
        ArrayList<ArrayList<Integer>> list = GraphUtil.ConvetToArrayLists(data);
        System.out.println(nearest(list, 0, 0));

    }

    static ArrayList<ArrayList<Integer>> nearest(ArrayList<ArrayList<Integer>> mat, int N, int M) {
        boolean[][] visited = new boolean[mat.size()][mat.get(0).size()];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.size(); i++) {
            for (int j = 0; j < mat.get(i).size(); j++) {
                if (mat.get(i).get(j) == 1) {
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
                if ((0 <= x && x < N && 0 <= y && y < M) && !visited[x][y] && mat.get(x).get(y) != 0) {
                    visited[x][y] = true;
                    mat.get(x).set(y, level);
                    queue.add(new int[]{x + 1, y});
                    queue.add(new int[]{x - 1, y});
                    queue.add(new int[]{x, y + 1});
                    queue.add(new int[]{x, y - 1});
                }
            }
            level++;
        }

        return mat;
    }
}
