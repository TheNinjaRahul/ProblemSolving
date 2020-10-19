package com.company.Graph;

import java.util.*;
import java.util.stream.Collectors;

public class NetworkDelayTime {
    public static void main(String[] args) {
        NetworkDelayTime ndt = new NetworkDelayTime();

        int[][] t1 = {{1, 2, 3}, {1, 3, 4}, {5, 3, 10}, {3, 4, 2}, {2, 4, 8}};
        System.out.println("-1 -->" + ndt.networkDelayTime(t1, 5, 1));

        int[][] t3 = {{1, 2, 3}, {4, 3, 4}};
        System.out.println("-1 -->" + ndt.networkDelayTime(t3, 4, 1));

        int[][] t2 = {{1, 2, 3}, {1, 3, 4}, {3, 4, 2}, {2, 4, 8}};
        System.out.println("6 -->" + ndt.networkDelayTime(t2, 4, 1));

        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println("2 -->" + ndt.networkDelayTime(times, 4, 2));
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        for (int[] t : times) {
            if (!map.containsKey(t[0])) map.put(t[0], new LinkedList<List<Integer>>());
            List<Integer> list = new LinkedList<>();
            list.add(t[1]);
            list.add(t[2]);
            map.get(t[0]).add(list);
        }
        System.out.println(map);

        int dist[] = new int[N + 1];
        boolean visited[] = new boolean[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;
        int count = 1;
        while (count < dist.length) {
            count++;
            int min = getMin(dist, visited);
            if (min == Integer.MAX_VALUE) return -1;
            if (dist[min] == Integer.MAX_VALUE) return -1;

            visited[min] = true;
            for (List<Integer> edges : map.getOrDefault(min, new LinkedList<>())) {
                dist[edges.get(0)] = Math.min(dist[edges.get(0)], dist[min] + edges.get(1));
            }
        }

        int data = 0;

        for (int i = 1; i < dist.length; i++) {
            data = Math.max(data, dist[i]);
        }

        return data;

    }

    private int getMin(int[] dist, boolean[] visited) {
        int minIndex = Integer.MAX_VALUE;
        int minDist = Integer.MAX_VALUE;
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                minIndex = i;
                break;
            }
        }
        if (minIndex == Integer.MAX_VALUE) return minIndex;
        minDist = dist[minIndex];
        for (int i = minIndex; i < dist.length; i++) {
            if (minDist > dist[i] && !visited[i]) {
                minIndex = i;
                minDist = dist[i];
            }
        }
        return minIndex;
    }

    class DistNode {
        int vertex;
        int dist;

        public DistNode(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "DistNode{" +
                    "vertex=" + vertex +
                    ", dist=" + dist +
                    '}';
        }

    }

    public int networkDelayTime2(int[][] times, int N, int K) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        for (int[] t : times) {
            if (!map.containsKey(t[0])) map.put(t[0], new LinkedList<List<Integer>>());
            List<Integer> list = new LinkedList<>();
            list.add(t[1]);
            list.add(t[2]);
            map.get(t[0]).add(list);
        }

        System.out.println(map);
        PriorityQueue<DistNode> queue = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        List<DistNode> list = new ArrayList<>();
//        list.add(null);

        for (int i = 0; i < N; i++) {
            DistNode node = new DistNode(i + 1, Integer.MAX_VALUE);
            if (i + 1 == K) {
                node.dist = 0;
            }
            queue.add(node);
            list.add(node);
        }

        boolean[] visited = new boolean[N];
        System.out.println(queue);
        while (!queue.isEmpty()) {
            DistNode node = queue.remove();
            visited[node.vertex] = true;
            if (node.dist == Integer.MAX_VALUE) return -1;

            for (List<Integer> l : map.get(node.vertex)) {
                DistNode distNode = list.get(l.get(0) - 1);
                distNode.dist = Math.min(distNode.dist, node.dist + l.get(1));
            }
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) return -1;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, list.get(i).dist);
        }
        return max;
    }


}
