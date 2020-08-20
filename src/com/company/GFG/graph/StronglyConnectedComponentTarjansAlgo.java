package com.company.GFG.graph;

import java.util.*;

public class StronglyConnectedComponentTarjansAlgo {
    public static void main(String[] args) {

    }

    public void find(ArrayList<ArrayList<Integer>> adj, int N) {


        Set<Integer> visitedSet = new HashSet<>();
        Set<Integer> articulationPoints = new HashSet<>();
        Map<Integer, Integer> visitedTime = new HashMap<>();
        Map<Integer, Integer> lowTime = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();

        dfs(0, 0, visitedSet, articulationPoints, visitedTime, lowTime, parent);


    }

    private void dfs(int current, int time, Set<Integer> visitedSet, Set<Integer> articulationPoints, Map<Integer, Integer> visitedTime, Map<Integer, Integer> lowTime, Map<Integer, Integer> parent) {
        visitedSet.add(current);
        visitedTime.put(current, time);
        lowTime.put(current, time);


    }

}
