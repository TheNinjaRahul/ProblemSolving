package com.company.leetcode.array;

import java.util.*;

public class LargestTimeForGivenDigits {
    public static void main(String[] args) {
        int[] d = {0, 2, 3, 0};
        System.out.println(largestTimeFromDigits(d));
    }

    public static String largestTimeFromDigits(int[] a) {
        Set<String> possibleList = new HashSet<>();
        findAllPossilbeString(possibleList, a);
        System.out.println(possibleList);
        possibleList = filterValidTime(possibleList);
        System.out.println(possibleList);
        if (possibleList.size() == 0) return "";
        List<String> list = new LinkedList<>(possibleList);
        return list.get(list.size() - 1).substring(0, 2) + ":" + list.get(list.size() - 1).substring(2, 4);
    }

    private static Set<String> filterValidTime(Set<String> possibleList) {
        System.out.println(possibleList);
        Set<String> set = new TreeSet<>();
        for (String s : possibleList) {
            if (isValid(s)) {
                set.add(s);
            }
        }
        return set;
    }

    private static boolean isValid(String s) {
        if (s.charAt(0) > '2') {
            return false;
        }
        if (s.charAt(0) == '2') {
            if (s.charAt(1) >= '4') {
                return false;
            }
        }
        if (s.charAt(2) >= '6') {
            return false;
        }
        return true;
    }

    private static void findAllPossilbeString(Set<String> possibleList, int[] a) {
        StringBuilder sb = new StringBuilder();
        boolean visited[] = new boolean[a.length];
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
            visited[i] = true;
            rec(sb, possibleList, a, visited);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static void rec(StringBuilder sb, Set<String> possibleList, int[] a, boolean[] visited) {
        if (sb.length() == a.length) {
            possibleList.add(sb.toString());
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (!visited[i]) {
                sb.append(a[i]);
                visited[i] = true;
                rec(sb, possibleList, a, visited);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
