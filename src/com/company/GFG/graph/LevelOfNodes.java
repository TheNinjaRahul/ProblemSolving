package com.company.GFG.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOfNodes {
    public static void main(String[] args) {
        int[][] g = {{1, 2}, {0, 3, 4, 5}, {0, 6, 5}, {1}, {1}, {1, 2}, {2, 7}, {6}};
        ArrayList<ArrayList<Integer>> vertex = GraphUtil.ConvetToArrayLists(g);
        System.out.println(levels(vertex, vertex.size(), 7));
    }

    static int levels(ArrayList<ArrayList<Integer>> g, int N, int X) {
        boolean[] visited = new boolean[g.size()];

        int level = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int temp = q.remove();
                if (visited[temp]) continue;
                visited[temp] = true;
                for (Integer cv : g.get(temp)) {
                    if (cv == X) return level + 1;
                    if (visited[cv]) continue;
                    q.add(cv);
                }
            }

            level++;
        }
        return -1;

    }
}
