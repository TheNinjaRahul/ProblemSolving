package com.company.hackerank;


import java.io.IOException;
import java.util.*;

public class DijkstraShortReach {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int data2[][] = {{1, 2, 10},
                {1, 3, 6},
                {2, 4, 8}};
        System.out.println(Arrays.toString(shortestReach(5, data2, 2)));

        int data[][] = {{1, 2, 24},
                {1, 4, 20},
                {3, 1, 3},
                {4, 3, 12}};

        System.out.println(Arrays.toString(shortestReach(4, data, 1)));
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

    static int[] shortestReach(int n, int[][] edges, int s) {
        boolean visited[] = new boolean[n];
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.MAX_VALUE;
        }

        Map<Integer, List<MyWeightedEdge>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (!map.containsKey(edges[i][0])) map.put(edges[i][0], new LinkedList<>());
            if (!map.containsKey(edges[i][1])) map.put(edges[i][1], new LinkedList<>());
            map.get(edges[i][0]).add(new MyWeightedEdge(edges[i][1], edges[i][2]));
            map.get(edges[i][1]).add(new MyWeightedEdge(edges[i][0], edges[i][2]));
        }

        PriorityQueue<MyWeightedEdge> queue = new PriorityQueue<>((a, b) -> {
            return (a.cost - b.cost);
        });

        for (MyWeightedEdge myWeightedEdge : map.get(edges[s][0])) {
            queue.add(myWeightedEdge);
            cost[myWeightedEdge.end - 1] = myWeightedEdge.cost;
        }

        cost[s - 1] = 0;

        visited[s - 1] = true;
//        System.out.println(queue);
//        System.out.println(map);
//        System.out.println(queue);
        while (!queue.isEmpty()) {
            MyWeightedEdge node = queue.remove();
            if (visited[node.end - 1]) continue;

            for (MyWeightedEdge myWeightedEdge : map.get(node.end)) {
                if (myWeightedEdge.end == s || visited[myWeightedEdge.end - 1]) continue;
                if (cost[myWeightedEdge.end - 1] == Integer.MAX_VALUE) {

                    cost[myWeightedEdge.end - 1] = node.cost + myWeightedEdge.cost;
                    queue.add(myWeightedEdge);
                    continue;
                }
                myWeightedEdge.cost = Math.min(cost[myWeightedEdge.end - 1], (node.cost + myWeightedEdge.cost));
                cost[myWeightedEdge.end - 1] = myWeightedEdge.cost;
                queue.add(myWeightedEdge);
            }
            visited[node.end - 1] = true;
        }

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < cost.length; i++) {
            System.out.print(cost[i] + " ");
            if (i == s - 1) {
                continue;
            }
            if (cost[i] == Integer.MAX_VALUE) {
                list.add(-1);
            } else {
                list.add(cost[i]);
            }
        }

        int result[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
//        System.out.println(list);
        return result;
    }


}
