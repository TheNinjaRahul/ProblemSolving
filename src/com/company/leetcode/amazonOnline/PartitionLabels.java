package com.company.leetcode.amazonOnline;

import java.util.*;

public class PartitionLabels {
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

    public static List<Integer> partitionLabels(String s) {

        Map<Character, int[]> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                int[] a = new int[]{i, i};
                map.put(s.charAt(i), a);
            } else {
                map.get(s.charAt(i))[1] = i;
            }
        }

        for (Character c : map.keySet()) {
            System.out.println(c + "-->" + Arrays.toString(map.get(c)));
        }

        List<Integer> list = new LinkedList<>();

        int start = -1, end = -1;
        for (Character c : map.keySet()) {
            int a[] = map.get(c);
            if (end == -1) {
                start = a[0];
                end = a[1];
            }

            if (end >= a[0]) {
                end = Math.max(a[1], end);
            } else {
                list.add(end - start + 1);
                start = a[0];
                end = a[1];
            }
        }
        list.add(end - start + 1);
        System.out.println(list);
        return list;
    }
}
