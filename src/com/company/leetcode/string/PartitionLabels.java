package com.company.leetcode.string;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.*;

public class PartitionLabels {
    public static void main(String[] args) {
        System.out.println(partitionLabels("eccbbbbdec"));
    }

    public static List<Integer> partitionLabels(String S) {
        Map<Character, int[]> map = new LinkedHashMap<>();
        for (int i = 0; i < S.length(); i++) {
            if (!map.containsKey(S.charAt(i))) {
                map.put(S.charAt(i), new int[]{i, i});
            } else {
                map.get(S.charAt(i))[1] = i;
            }
        }
        for (Map.Entry<Character, int[]> e : map.entrySet()) {
            System.out.println(e.getKey() + " " + Arrays.toString(e.getValue()));
        }
        List<Integer> list = new LinkedList<>();
        int end = -1, start = -1;
        for (Map.Entry<Character, int[]> e : map.entrySet()) {
            if (end == -1) {
                start = e.getValue()[0];
                end = e.getValue()[1];
                System.out.println("start:" + start);
                System.out.println("end:" + end);
                continue;
            }
            if (e.getValue()[0] < end) {
                end = Math.max(end, e.getValue()[1]);
            } else {
                list.add(end - start + 1);
                start = e.getValue()[0];
                end = e.getValue()[1];
            }
        }
        list.add(end - start + 1);
        System.out.println(list);
        return list;
    }
}
