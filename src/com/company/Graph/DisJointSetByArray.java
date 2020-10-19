package com.company.Graph;

import java.util.Arrays;

public class DisJointSetByArray {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 3}, {2, 3}, {1, 2}};
        DisJointSetByArray dj = new DisJointSetByArray();
        System.out.println(dj.isCyclic(edges, 4));
    }

    public boolean isCyclic(int[][] edges, int n) {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for (int[] edge : edges) {
            int parentOfa = findParentOf(edge[0], parent);
            int parentOfb = findParentOf(edge[1], parent);
            if (parent[parentOfa] == -1 && parent[parentOfb] >= 0) {
                parent[parentOfb] = parentOfa;
            } else if (parent[parentOfb] == -1 && parent[parentOfa] >= 0) {
                parent[parentOfa] = parentOfb;
            } else if (parentOfa == parentOfb) {
                return true;
            } else {
                parent[parentOfa] = parentOfb;
            }

//                if (parent[parentOfa] == parent[parentOfb]) return true;
//
//            if (parent[parentOfa] == -1) {
//                parent[parentOfa] = parentOfb;
//            } else {
//                parent[parentOfb] = parentOfa;
//            }
        }
        return false;
    }

    private int findParentOf(int i, int[] parent) {
        while (parent[i] > 0) {
            i = parent[i];
        }
        return i;
    }
}


