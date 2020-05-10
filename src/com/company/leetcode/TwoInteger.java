package com.company.leetcode;

import java.util.*;

public class TwoInteger {
    public static void main(String[] args) {
//        int []data=new int[]{3,3};
//        int[] data2=twoSum(data,6);

//        int []data=new int[]{2,7,11,15};
//        int[] data2=twoSum(data,9);

//        int []data=new int[]{-1,-2,-3,-4,-5};
//        int[] data2=twoSum(data,-8);

        int []data=new int[]{230,863,916,585,981,404,316,785,88,12,70,435,384,778,887,755,740,337,86,92,325,422,815,650,920,125,277,336,221,847,168,23,677,61,400,136,874,363,394,199,863,997,794,587,124,321,212,957,764,173,314,422,927,783,930,282,306,506,44,926,691,568,68,730,933,737,531,180,414,751,28,546,60,371,493,370,527,387,43,541,13,457,328,227,652,365,430,803,59,858,538,427,583,368,375,173,809,896,370,789};
        int[] data2=twoSum(data,542);
        System.out.println(Arrays.toString(data2));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int keyint=nums[i];
            if (map.containsKey(keyint)) {
                List<Integer> value = map.get(keyint);
                value.add(i);
                map.put(keyint, value);
            } else {
                List<Integer> list=new ArrayList<>();
                list.add(i);
                map.put(keyint, list);
            }
        }
        System.out.println(map);

        int removedIndex=-1;
        int found=-1;
        for(Integer i:map.keySet()){

            int rem=(target-i);
            if(!(map.get(i).size()==1)){
                List<Integer> value=map.get(i);
                removedIndex=value.remove(0);
                map.put(i,value);
            }

            if(map.containsKey(rem)){
                found=map.get(rem).get(0);

                if(removedIndex!=-1 && found!=-1){
                    return new int[]{removedIndex,found};
                } else {
                    return new int[]{map.get(i).get(0), found};
                }
            }

            removedIndex=-1;
        }

        return null;

    }
}

