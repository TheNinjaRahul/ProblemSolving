package com.company.GFG.graph;

import com.company.hackerank.DijkstraShortReach;

import java.util.*;

public class DijkstraSet1 {
    public static void main(String[] args) {

    }

    static class MyWeightedEdge {
        int end;
        int cost;

        public MyWeightedEdge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "myWeightedEdge{" +
                    "end=" + end +
                    ", cost=" + cost +
                    '}';
        }
    }

    static int[] dijkstra(ArrayList<ArrayList<Integer>> g, int src, int V) {

        boolean visited[] = new boolean[V];
        int[] cost = new int[V];
        for (int i = 0; i < V; i++) {
            cost[i] = Integer.MAX_VALUE;
        }

        Map<Integer, List<MyWeightedEdge>> map = new HashMap<>();

        for (int i = 0; i < g.size() / 2; i++) {
            if (!map.containsKey(i)) map.put(i, new LinkedList<>());
            ArrayList<Integer> inner = g.get(i);
            for (int j = 0; j < inner.size(); j++) {
                map.get(i).add(new MyWeightedEdge(j, inner.get(j)));
            }
        }

        PriorityQueue<MyWeightedEdge> queue = new PriorityQueue<>((a, b) -> {
            return (a.cost - b.cost);
        });

        for (MyWeightedEdge myWeightedEdge : map.get(src)) {
            queue.add(myWeightedEdge);
            cost[myWeightedEdge.end] = myWeightedEdge.cost;
        }

        cost[src] = 0;
        visited[src] = true;
        //        System.out.println(queue);
//        System.out.println(map);
//        System.out.println(queue);
        while (!queue.isEmpty()) {
            MyWeightedEdge node = queue.remove();
            if (visited[node.end]) continue;

            for (MyWeightedEdge myWeightedEdge : map.get(node.end)) {
                if (myWeightedEdge.end == src || visited[myWeightedEdge.end]) continue;
                if (cost[myWeightedEdge.end] == Integer.MAX_VALUE) {

                    cost[myWeightedEdge.end] = node.cost + myWeightedEdge.cost;
                    queue.add(myWeightedEdge);
                    continue;
                }
                myWeightedEdge.cost = Math.min(cost[myWeightedEdge.end], (node.cost + myWeightedEdge.cost));
                cost[myWeightedEdge.end] = myWeightedEdge.cost;
                queue.add(myWeightedEdge);
            }
            visited[node.end] = true;
        }

        return cost;
    }
}
