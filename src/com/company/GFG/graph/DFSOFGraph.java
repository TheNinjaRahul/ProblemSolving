package com.company.GFG.graph;

import java.util.*;

public class DFSOFGraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(0);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(0);
        list3.add(4);
        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(0);
        ArrayList<Integer> list5 = new ArrayList<>();
        list5.add(2);
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        list.add(list5);
        System.out.println(dfs(list, 0));
    }


    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g, int N) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int i = 0;
        for (ArrayList<Integer> e : g) {
            map.put(i++, e);
        }
        System.out.println(map);
        ArrayList<Integer> list = new ArrayList<>();

        Set<Integer> inprogress = new HashSet<>();
        Set<Integer> completed = new HashSet<>();
        dfs(0, inprogress, completed, list, map);

        return list;
    }

    private static void dfs(int vertex, Set<Integer> inprogress, Set<Integer> completed, ArrayList<Integer> list, Map<Integer, ArrayList<Integer>> map) {
        if (inprogress.contains(vertex) || completed.contains(vertex)) return;
        list.add(vertex);
        inprogress.add(vertex);
        if (map.get(vertex) != null) {
            for (Integer i : map.get(vertex)) {
                dfs(i, inprogress, completed, list, map);
            }
        }
        completed.add(vertex);
    }

}
