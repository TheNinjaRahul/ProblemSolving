package com.company.Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {

    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        for (int i = 0; i < flights.length; i++) {
            if (!map.containsKey(flights[i][0])) map.put(flights[i][0], new LinkedList<>());
            List<Integer> toFlightAndPrice = new LinkedList<>();
            toFlightAndPrice.add(flights[i][1]);
            toFlightAndPrice.add(flights[i][2]);
            map.get(flights[i][0]).add(toFlightAndPrice);
        }
        System.out.println(map);
        for (Integer key : map.keySet()) {

        }
        return 0;
    }

}
