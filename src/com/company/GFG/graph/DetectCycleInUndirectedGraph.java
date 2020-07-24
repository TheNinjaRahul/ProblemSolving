package com.company.GFG.graph;

import java.util.*;

public class DetectCycleInUndirectedGraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(0);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(3);
        list3.add(4);
        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(2);
        list4.add(4);

        ArrayList<Integer> list5 = new ArrayList<>();
        list5.add(3);
        list5.add(2);


        adj.add(list1);
        adj.add(list2);
        adj.add(list3);
        adj.add(list4);
        adj.add(list5);
        ArrayList<Integer> list6 = new ArrayList<>();
        adj.add(list6);

        System.out.println(adj);
        System.out.println(isCyclic(adj, adj.size()));

        ArrayList<ArrayList<Integer>> adj2 = getTest2();
        System.out.println(adj2);
        System.out.println(isCyclic(adj2, adj2.size()));


    }

    private static ArrayList<ArrayList<Integer>> getTest2() {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.add(2);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(3);
        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(2);
        ArrayList<Integer> list5 = new ArrayList<>();

        adj.add(list1);
        adj.add(list2);
        adj.add(list3);
        adj.add(list4);
        adj.add(list5);

        return adj;
    }


    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (detectCycle(adj, visited, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean detectCycle(ArrayList<ArrayList<Integer>> list, boolean[] visited, int val, int parent) {
        if (!visited[val]) {
            visited[val] = true;
            for (Integer vals : list.get(val)) {
                if (!visited[vals]) {
                    if (detectCycle(list, visited, vals, val)) {
                        return true;
                    }
                } else if (parent != vals) {
                    return true;
                }
            }
        }
        return false;
    }


    static class VertexNode {
        int data;
        int rank = 0;
        VertexNode parent;

        public VertexNode(int data) {
            this.data = data;
        }

    }

    static Map<Integer, VertexNode> map = new HashMap<>();

    static boolean isCyclic3(ArrayList<ArrayList<Integer>> adj, int V) {
        for (int i = 0; i < V; i++) {
            make(i);
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < V; i++) {
            ArrayList<Integer> v = adj.get(i);
            for (Integer in : v) {
                int x = i, y = in;
                if (x < y) {
                    if (set.contains(x + "" + y)) {
                        continue;
                    } else {
                        set.add(x + "" + y);
                    }
                } else {
                    if (set.contains(y + "" + x)) {
                        continue;
                    } else {
                        set.add(y + "" + x);
                    }
                }
                if (merge(i, in)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean merge(int a, Integer b) {
        VertexNode p1 = findParent(a);
        VertexNode p2 = findParent(b);
        if (p1 == p2) return true;
        if (p1.rank >= p2.rank) {
            p1.rank += p2.rank + 1;
            p2.parent = p1;
            compress(b);
        } else {
            p2.rank = p1.rank + 1;
            p1.parent = p2;
            compress(a);
        }
        return false;
    }

    private static void compress(Integer b) {
        VertexNode node = map.get(b);
        compress(node);
    }

    private static VertexNode compress(VertexNode node) {
        if (node.parent == node) return node;
        node.parent = compress(node.parent);
        return node;
    }

    private static VertexNode findParent(int a) {
        VertexNode p = map.get(a);
        while (p.parent != p) {
            p = p.parent;
        }
        return p;
    }

    private static void make(int i) {
        VertexNode vertexNode = new VertexNode(i);
        vertexNode.parent = vertexNode;
        map.put(i, vertexNode);
    }

    static boolean isCyclic2(ArrayList<ArrayList<Integer>> adj, int V) {
        int a[] = new int[V];
        for (int i = 0; i < V; i++) {
            a[i] = -1;
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < V; i++) {
            ArrayList<Integer> v = adj.get(i);
            for (Integer in : v) {
                int x = i, y = in;
                if (x < y) {
                    if (set.contains(x + "" + y)) {
                        continue;
                    } else {
                        set.add(x + "" + y);
                    }
                } else {
                    if (set.contains(y + "" + x)) {
                        continue;
                    } else {
                        set.add(y + "" + x);
                    }
                }


                int lx = x, ly = y;

                while (a[x] >= 0) {
                    lx = x;
                    x = a[i];
                }

                while (a[y] >= 0) {
                    ly = y;
                    y = a[in];
                }

                if ((a[lx] == -1 && a[ly] == -1) || x != y) {
                    if (Math.abs(a[lx]) >= Math.abs(a[ly])) {
                        a[lx] += a[ly];
                        a[ly] = lx;
                    } else {
                        a[ly] += a[lx];
                        a[lx] = ly;
                    }
                } else if (x == y) return true;
            }
        }
        return false;
    }

    private static void insert(int i, Integer j, int[] a) {
        int x = i, lx = x, y = j, ly = y;

        while (a[x] > 0) {
            lx = x;
            x = a[i];
        }

        while (a[y] > 0) {
            ly = y;
            y = a[j];
        }

        if (Math.abs(a[lx]) >= Math.abs(a[ly])) {
            a[lx] += a[ly];
            a[ly] = lx;
        } else {
            a[ly] += a[lx];
            a[lx] = ly;
        }

    }

    private static boolean isHaveSaveParent(int i, Integer j, int[] a) {
        int x = i, lx = x, y = j, ly = y;

        while (a[x] >= 0) {
            lx = x;
            x = a[i];
        }

        while (a[y] >= 0) {
            ly = y;
            y = a[j];
        }
        if (a[lx] == -1 && a[lx] == a[ly]) return false;
        if (x == y) return true;
        return false;
    }
}
