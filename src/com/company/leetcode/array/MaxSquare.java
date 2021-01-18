package com.company.leetcode.array;

import java.util.Collections;
import java.util.TreeMap;

public class MaxSquare {
    public static void main(String[] args) {

    }

    public int countGoodRectangles(int[][] r) {
        TreeMap<Integer,Integer> map=new TreeMap<>(Collections.reverseOrder());

        for(int[] a:r){
            int min=Math.min(a[0],a[1]);
            map.put(min,map.getOrDefault(min,0)+1);
        }
        for(int key:map.keySet()){
            return map.get(key);
        }
        return 0;
    }
}
