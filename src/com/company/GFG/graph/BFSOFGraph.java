package com.company.GFG.graph;

import java.util.*;

public class BFSOFGraph {

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
        System.out.println(bfs(list, list.size()));
    }

    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> g, int N) {
        boolean[] visited = new boolean[N];
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int temp = queue.remove();
            if (!visited[temp]) {
                list.add(temp);
            }
            visited[temp] = true;
            for (Integer i : g.get(temp)) {
                if (!visited[i]) {
                    queue.add(i);
                }
            }
        }
        return list;
    }
}
