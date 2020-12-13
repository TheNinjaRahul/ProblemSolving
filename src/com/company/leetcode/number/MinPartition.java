package com.company.leetcode.number;

import java.util.LinkedList;

public class MinPartition {
    public static void main(String[] args) {
        

    }

    public int minPartitions(String n) {
        LinkedList<String> list = new LinkedList<>();
        list.add("0");
        String last = "1";
        list.add(last);
        int l = 1;
        while (last.length() != n.length() + 1) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                last = "1" + list.get(i);
                list.add(last);
            }
        }
        list.removeFirst();
        System.out.println(list);
        return 0;
    }
}
