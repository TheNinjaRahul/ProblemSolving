package com.company.leetcode.Graph;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 */
public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        int [][]flights={{0,1,100},{1,2,100},{0,2,500}};
        System.out.println(findCheapestPrice(0,flights,0,2,1));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> input = new HashMap<>();

        for (int[] f : flights) {
            if (!input.containsKey(f[0])) input.put(f[0], new HashMap<Integer, Integer>());
            input.get(f[0]).put(f[1], f[2]);
        }

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.add(new int[]{0, src, K + 1});

        while (!queue.isEmpty()) {
            int[] top = queue.remove();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if (city == dst) return price;
            if (stops > 0) {
                Map<Integer, Integer> adj = input.getOrDefault(city, new HashMap<>());
                for (int a : adj.keySet()) {
                    queue.add(new int[]{(price + adj.get(a)), a, stops - 1});
                }
            }
        }
        return -1;
    }

}
