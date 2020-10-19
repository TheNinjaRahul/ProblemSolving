package com.company.Graph;

public class DisjoingSetByRank {
    public static void main(String[] args) {
        DisjoingSetByRank ds = new DisjoingSetByRank();
        int[][] edges = {{0, 1}, {2, 3}, {1, 2}, {0, 4}};//{4, 3}};
        System.out.println(ds.isCyclic(edges, 5));
    }

    class Node {
        int parent = -1;
        int rank = 0;

        @Override
        public String toString() {
            return "Node{" +
                    "parent=" + parent +
                    ", rank=" + rank +
                    '}';
        }
    }

    public boolean isCyclic(int[][] edges, int n) {

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }

        for (int[] edge : edges) {
            int parentOfA = findparentOf(edge[0], nodes);
            int parentOfB = findparentOf(edge[1], nodes);

            if (parentOfA == parentOfB) return true;

            if (nodes[parentOfA].parent == -1 && nodes[parentOfB].parent != -1) {
                nodes[parentOfB].parent = nodes[parentOfA].parent;
            } else if (nodes[parentOfB].parent == -1 && nodes[parentOfA].parent != -1) {
//                nodes[parentOfB].parent = parentOfA;
                nodes[parentOfA].parent = nodes[parentOfB].parent;
            } else if (nodes[parentOfA].parent == -1 && nodes[parentOfB].parent == -1) {
                int rankA = nodes[parentOfA].rank;
                int rankB = nodes[parentOfB].rank;
                if (rankA >= rankB) {
                    nodes[parentOfB].parent = parentOfA;
                    nodes[parentOfA].rank++;
                } else {
                    nodes[parentOfA].parent = parentOfB;
                    nodes[parentOfB].rank++;
                }
            }
        }
        return false;
    }

    private int findparentOf(int i, Node[] nodes) {
        if (nodes[i].parent == -1) {
            return i;
        } else {
            nodes[i].parent = findparentOf(nodes[i].parent, nodes);
            return nodes[i].parent;
        }
    }
}
