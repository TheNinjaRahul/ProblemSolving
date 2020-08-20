package com.company.GFG.BackTracking;

import java.util.*;

public class PossibleWordFromKeypad {
    public static void main(String[] args) {
        String s = "rahul";
        String s2 = "Chirag";

        List<String> l1 = new LinkedList<>();
        l1.add(s);
        l1.add(s2);
        System.out.println(l1);

        System.out.println(s);
        System.out.println(possibleWords(new int[]{2, 3, 4}, 3));
    }

    static ArrayList<String> possibleWords(int a[], int N) {

        ArrayList<String> list = new ArrayList<>();
        Map<Integer, char[]> map = new HashMap<>();
        map.put(2, new char[]{'a', 'b', 'c'});
        map.put(3, new char[]{'d', 'e', 'f'});
        map.put(4, new char[]{'g', 'h', 'i'});
        map.put(5, new char[]{'j', 'k', 'l'});
        map.put(6, new char[]{'m', 'n', 'o'});
        map.put(7, new char[]{'p', 'q', 'r', 's'});
        map.put(8, new char[]{'t', 'u', 'v'});
        map.put(9, new char[]{'w', 'x', 'y', 'z'});

        LinkedList<char[]> chars = new LinkedList<>();
        for (int i = 0; i < a.length; i++) {
            chars.add(map.get(a[i]));
        }


        char[] removed = chars.get(0);
        for (char c : removed) {
            LinkedList<Character> sb = new LinkedList<>();
            sb.add(c);
            list.addAll(dfs(0, sb, map, a, chars));
            sb.removeLast();
        }
        return list;
    }

    private static ArrayList<String> dfs(int current, LinkedList<Character> sb, Map<Integer, char[]> map, int[] a, LinkedList<char[]> chars) {
        ArrayList<String> list = new ArrayList<>();
        if (sb.size() == a.length) {
            StringBuffer s = new StringBuffer("");
            for (Character c : sb) {
                s.append((c));
            }
            list.add(s.toString());
            return list;
        }

        for (int i = current + 1; i < a.length; i++) {

            char[] removed = chars.get(i);
            for (char c : removed) {
                sb.add(c);
                list.addAll(dfs(i, sb, map, a, chars));
                sb.removeLast();
            }
        }
        return list;
    }
}

