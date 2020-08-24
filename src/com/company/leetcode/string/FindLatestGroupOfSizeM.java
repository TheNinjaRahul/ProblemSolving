package com.company.leetcode.string;

import com.company.leetcode.Heap.FindMedian;

import java.util.HashMap;
import java.util.Map;

public class FindLatestGroupOfSizeM {
    public static void main(String[] args) {
        FindLatestGroupOfSizeM s = new FindLatestGroupOfSizeM();

        int[] d4 = {2, 1};
        System.out.println(s.findLatestStep(d4, 2));

        int[] d3 = {1};
        System.out.println(s.findLatestStep(d3, 1));

        int[] d2 = {3, 1, 5, 4, 2};
        System.out.println(s.findLatestStep(d2, 5));
        int[] d = {3, 5, 1, 2, 4};
        System.out.println(s.findLatestStep(d, 1));

    }

    public int findLatestStep(int[] arr, int m) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            sb.append("0");
        }

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count++;
            sb.setCharAt(arr[i] - 1, '1');

            if (count >= m) {
                setValues(map, sb, i, m);
            }
        }
        return map.containsKey(m) ? map.get(m) : -1;
    }

    private void setValues(Map<Integer, Integer> map, StringBuilder sb, int step, int m) {
        int count = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '1') {
                while (i < sb.length() && sb.charAt(i) != '0') {
                    count++;
                    i++;
                }
                if (count == m) {
                    map.put(count, step + 1);
                }
                count = 0;
            }
        }
//        System.out.println(map);
    }
}
