package com.company.GFG.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GraphUtil {

    public static ArrayList<ArrayList<Integer>> ConvetToArrayLists(int[][] g) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int[] a : g) {
            ArrayList<Integer> mini = Arrays.stream(a).boxed().collect(Collectors.toCollection(ArrayList::new));
            lists.add(mini);
        }
        return lists;
    }

}
