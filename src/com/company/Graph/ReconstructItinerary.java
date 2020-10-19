package com.company.Graph;

import java.util.*;

public class ReconstructItinerary {
    public static void main(String[] args) {
        List<List<String>> tickets = new LinkedList<>();
        List<String> l1 = new LinkedList<>();
        l1.add("A");
        l1.add("B");

        List<String> l2 = new LinkedList<>();
        l2.add("A");
        l2.add("C");

        List<String> l3 = new LinkedList<>();
        l3.add("C");
        l3.add("A");

        tickets.add(l1);
        tickets.add(l2);
        tickets.add(l3);

        ReconstructItinerary rc = new ReconstructItinerary();
        System.out.println(rc.findItinerary(tickets));
    }

    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, List<String>> map = new HashMap<>();
        for (List<String> list : tickets) {
            if (!map.containsKey(list.get(0))) map.put(list.get(0), new LinkedList<>());
            map.get(list.get(0)).add(list.get(1));
        }

        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        System.out.println(map);

        List<String> output = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        dfs(map, stack, "A", output);

        List<String> output2 = new LinkedList<>();
        for (int i = output.size() - 1; i >= 0; i--) {
            output2.add(output.get(i));
        }
        return output2;
    }

    private void dfs(Map<String, List<String>> map, Stack<String> stack, String start, List<String> output) {
        stack.push(start);
        if (map.containsKey(start) && map.get(start).size() > 0) {
            String dest = map.get(start).remove(0);
            dfs(map, stack, dest, output);
        } else {
            output.add(stack.pop());
            while (!stack.isEmpty()) {
                dfs(map, stack, stack.pop(), output);
            }
        }
    }
}
