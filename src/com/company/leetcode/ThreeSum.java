package com.company.leetcode;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;
import org.omg.CORBA.INTERNAL;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {
    public static void main(String[] args) {
        int [] data={-1, 0, 1, 2, -1, -4};
        int [] data2={0,0,0,0};
        int [] data3={1,2,-2,-1};
//        System.out.println(threeSum2(data3));
        System.out.println(threeSum2(data));
//        System.out.println(threeSum2(data2));
    }

    public static  List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> listm=new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i ==0 || (i > 0 && nums[i] != nums[i-1])){
                int low=i+1;
                int high=nums.length-1;
                while(low<high){
                    int sum=nums[i]+nums[low]+nums[high];
                    if(sum==0){
                        System.out.println(nums[i]+" "+nums[low]+" "+nums[high]);
                        listm.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        while(low<high && nums[low]==nums[low+1]){
                            low++;
                        }
                        while(low<high && nums[high]==nums[high-1]){
                            high--;
                        }
                        low++;
                        high--;
                    } else  if(sum>0){
                        high--;
                    }else{
                        low++;
                    }
                }
            }


        }
        return listm;
    }


    public static  List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        Set<List<Integer>> set=new HashSet<>();
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                Integer val=map.get(nums[i]);
                val++;
                map.put(nums[i],val);
            }else{
                map.put(nums[i],1);
            }

        }

        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                int a=nums[i];
                int b=nums[j];
                int c=0-(a+b);
                if(map.containsKey(c)){
//                   if(removeFromMap(map,a,b,c)){
//                       System.out.println(a+" "+b+" "+c);
                       List<Integer> mini=new ArrayList<>();
                       mini.add(a);
                       mini.add(b);
                       mini.add(c);
                       Collections.sort(mini);
//                       System.out.println(mini);
                       set.add(mini);
//                   }

                }
            }

        }
        lists=set.stream().collect(Collectors.toList());
        return lists;

    }

    private static boolean removeFromMap(Map<Integer, Integer> map, int a, int b, int c) {

        Integer cval=map.get(c);
        Integer bval=map.get(b);
        Integer aval=map.get(a);
        if(cval==null||bval==null||aval==null){
            return false;
        }
        if(cval==1){
            map.remove(c);
        }else{
            map.put(c,(cval-1));
        }

        if(bval==1){
            map.remove(b);
        }else{
            map.put(b,(bval-1));
        }

        if(aval==1){
            map.remove(a);
        }else{
            map.put(a,(aval-1));
        }
    return true;
    }
}
