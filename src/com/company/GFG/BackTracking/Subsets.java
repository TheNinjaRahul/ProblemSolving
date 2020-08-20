package com.company.GFG.BackTracking;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Subsets {
    public static void main(String[] args) {
        System.out.println(AllSubsets(new int[]{8, 1, 8, 6, 8}, 5));
    }

    public static ArrayList<ArrayList<Integer>> AllSubsets(int arr[], int n) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int[] freq = new int[map.size()];
        int[] number = new int[map.size()];

        int i = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            freq[i] = e.getValue();
            number[i++] = e.getKey();
        }
        ArrayList<Integer> result = new ArrayList<>();
        list.add(new ArrayList<>(result));
        for (i = 0; i < freq.length; i++) {
            result.add(number[i]);
//            System.out.println(result);
            list.add(new ArrayList<>(result));
//            System.out.println(list);
            freq[i]--;
            dfsutil(result, freq, number, list, arr.length, i);
            result.remove(result.size() - 1);
            freq[i]++;
        }
//        System.out.println(list);
        return list;
    }

    private static void dfsutil(ArrayList<Integer> result, int[] freq, int[] number, ArrayList<ArrayList<Integer>> list, int length, int position) {
        for (int i = position; i < freq.length; i++) {
            if (!(freq[i] > 0)) {
                continue;
            }
            freq[i]--;
            result.add(number[i]);
//            System.out.println(result);
            list.add(new ArrayList<>(result));
//            System.out.println(list);
            dfsutil(result, freq, number, list, length, i);
            result.remove(result.size() - 1);
            freq[i]++;
        }

    }

}
