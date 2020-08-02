package com.company.GFG.graph;

import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {

        String[] str2 = {"caa", "aaa", "aab"};
        System.out.println(findOrder(str2, 0, 0));

        String[] str = {"baa", "abcd", "abca", "cab", "cad"};
        System.out.println(findOrder(str, 0, 0));
    }

    public static String findOrder(String[] dict, int N, int K) {

        if (dict.length == 1) return dict[0];
        Map<Character, Set<Character>> map = new HashMap<>();

//        for (int i = 0; i < dict.length; i++) {
//            map.put(dict[i].charAt(0), new HashSet<>());
//        }

        for (int i = 0; i < dict.length - 1; i++) {
            String str1 = dict[i];
            String str2 = dict[i + 1];

            int len = Math.min(str1.length(), str2.length());

            for (int k = 0; k < len; k++) {
                if (str1.charAt(k) != str2.charAt(k)) {
                    if (!map.containsKey(str1.charAt(k))) {
                        map.put(str1.charAt(k), new HashSet<>());
                    }
                    map.get(str1.charAt(k)).add(str2.charAt(k));
                    break;
                }
            }

        }
        System.out.println(map);

        return topologicalShort(map);
    }

    private static String topologicalShort(Map<Character, Set<Character>> map) {
        Set<Character> visited = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        for (Map.Entry<Character, Set<Character>> e : map.entrySet()) {
            dfs(e.getKey(), visited, stack, map);
        }

        System.out.println(stack);

        char[] c = new char[stack.size()];
        int j = 0;
        while (!stack.isEmpty()) {
            c[j++] = stack.pop();
        }

        return String.valueOf(c);
    }

    private static void dfs(Character c, Set<Character> visited, Stack<Character> stack, Map<Character, Set<Character>> map) {
        if (visited.contains(c)) return;
        visited.add(c);
        if (map.containsKey(c)) {
            for (Character child : map.get(c)) {
                dfs(child, visited, stack, map);
            }
        }
        stack.add(c);
    }
}
