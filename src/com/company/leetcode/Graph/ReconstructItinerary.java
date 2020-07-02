package com.company.leetcode.Graph;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class ReconstructItinerary {
    public static void main(String[] args) {
//        Test 1
       String[] s11 = {"MUC", "LHR"};
        List<String> s1 = Arrays.asList(s11);
        String[] s22 = {"JFK", "MUC"};
        List<String> s2 = Arrays.asList(s22);
        String[] s33 = {"SFO", "SJC"};
        List<String> s3 = Arrays.asList(s33);
        String[] s44 = {"LHR", "SFO"};
        List<String> s4 = Arrays.asList(s44);

//        String[] s22={"JFK", "KUL"};
//        List<String> s2=Arrays.asList(s22);
//        String[] s33={"JFK","NRT"};
//        List<String> s3=Arrays.asList(s33);
//        String[] s44={"NRT","JFK"};
//        List<String> s4=Arrays.asList(s44);

        List<List<String>> list = new ArrayList<>();
//        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        System.out.println(findItinerary(list));
    }


    public static List<String> findItinerary(List<List<String>> tickets) {
//        System.out.println(tickets);
        Map<String, List<String>> map = new HashMap<>();
        List<String> output = new ArrayList<>();
        for (List<String> route : tickets) {
            if (map.get(route.get(0)) == null) map.put(route.get(0), new ArrayList<>());

            map.get(route.get(0)).add(route.get(1));
        }
        for (Map.Entry<String, List<String>> e : map.entrySet()) {
            Collections.sort(e.getValue());
        }
        System.out.println(map);
        String startFrom = "JFK";
        Stack<String> stack = new Stack<>();
        while (map.size()!=0 && map.containsKey(startFrom)) {
            while (map.get(startFrom) != null) {
                stack.push(startFrom);
                String prev = startFrom;
                startFrom = map.get(startFrom).remove(0);
                if (map.get(prev).size() == 0) {
                    map.remove(prev);
                }
            }
            stack.push(startFrom);
            while (stack.size() != 0) {
                String o = stack.pop();
                output.add(o);
                if (map.size() != 0 && stack.size() != 0 && map.get(stack.peek()) !=null && map.get(stack.peek()).size() != 0) {
                    startFrom = map.get(stack.peek()).remove(0);
                    if (map.get(stack.peek()).size() == 0) {
                        map.remove(stack.peek());
                    }
                    break;
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = output.size() - 1; i >= 0; i--) {
            result.add(output.get(i));
        }
//        System.out.println(result);
        return result;
    }
}
