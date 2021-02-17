package com.company.leetcode.string;

import java.util.LinkedList;

public class ShortestDistanceToCharacter {
    public static void main(String[] args) {
        System.out.println(shortestToChar("cizokxcijwbyspcfcqws", 'c'));
    }


    public static int[] shortestToChar(String s, char c) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                list.add(i);
            }
        }

        int[] ans = new int[s.length()];
        int i = 0;
        int last = Integer.MAX_VALUE - 1000;
        while (list.size() != 1) {
            if (i == list.getFirst()) {
                last = list.removeFirst();
            } else {
                if (last != Integer.MAX_VALUE - 1000) {
                    ans[i] = Math.abs(Math.min(last - i, Math.min(Math.abs(i - list.get(0)), Math.abs(i - list.get(1)))));
                } else {
                    ans[i] = Math.min(Math.abs(i - list.get(0)), Math.abs(i - list.get(1)));
                }

            }
            i++;
        }
        while (i < s.length()) {
            ans[i] = Math.min(Math.abs(i - list.get(0)), Math.abs(i - last));
            i++;
        }
        return ans;
    }

    public int[] shortestToChar2(String s, char c) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                list.add(i);
            }
        }

        int[] ans = new int[s.length()];

        int i = 0;
        while (list.size() != 1) {
            if (i == list.getFirst()) {
                list.removeFirst();
            } else {
                ans[i] = Math.min(Math.abs(i - list.get(0)), Math.abs(i - list.get(1)));
            }
            i++;
        }
        while (i < s.length()) {
            ans[i] = Math.abs(i - list.get(0));
            i++;
        }
        return ans;
    }
}
