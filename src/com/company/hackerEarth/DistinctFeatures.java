package com.company.hackerEarth;

import java.util.*;

public class DistinctFeatures {

    public static void main(String[] args) {
        DistinctFeatures distinctFeatures = new DistinctFeatures();
        System.out.println(distinctFeatures.getDistinctCount(new int[]{5, 0, 1, 2, 1}, 1, 1));
    }

    public int getDistinctCount(int[] arr, int k, int itr) {
        int maxFreq = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] temp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(temp);
        for (int i = 0; i < temp.length; i++) {
            int freq = 1;
            while (i + 1 < temp.length && temp[i + 1] == temp[i]) {
                i++;
                freq++;
            }
            if (map.containsKey(freq))
                map.get(freq).add(temp[i]);
            else {
                List<Integer> list = new ArrayList<>();
                list.add(temp[i]);
                map.put(freq, list);
            }
            if (freq > maxFreq)
                maxFreq = freq;
        }
        int mul = k;
        int counter = 2;
        while (mul <= maxFreq && itr > 0) {
            if (map.containsKey(mul)) {
                List<Integer> list = map.get(mul);
                int size = list.size() * (counter - 1);
                if (itr > size) {
                    itr -= list.size();
                    map.remove(mul);
                } else {
                    while (itr > 0) {
                        int diff = itr - (counter - 1);
                        if (diff >= 0) {
                            list.remove(list.size() - 1);
                            itr -= counter - 1;
                        } else
                            itr = 0;
                    }
                }
            }
            mul = k * counter++;
        }
        int distinctNos = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            distinctNos += entry.getValue().size();
        }
        return distinctNos;
    }
}