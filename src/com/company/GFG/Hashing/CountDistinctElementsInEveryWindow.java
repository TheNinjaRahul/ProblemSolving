package com.company.GFG.Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountDistinctElementsInEveryWindow {
    public static void main(String[] args) {
        int a[]={1 ,2 ,1 ,3 ,4 ,2 ,3};
        System.out.println(countDistinct(a,a.length,4));
    }
    public static ArrayList<Integer> countDistinct(int A[], int n, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        int lastIndex=0;
        for(int i=0;i<k;i++){
            if(map.containsKey(A[i])){
                Integer v=map.get(A[i]);
                v++;
                map.put(A[i],v);
            }else {
                map.put(A[i],1);
            }
        }
        list.add(map.size());
        for(int i=k;i<A.length;i++){
            if(map.get(A[lastIndex])==1){
                map.remove(A[lastIndex]);
            }else {
                Integer v=map.get(A[lastIndex]);
                v--;
                map.put(A[lastIndex],v);
            }
            lastIndex++;
            if(map.containsKey(A[i])){
                Integer v=map.get(A[i]);
                v++;
                map.put(A[i],v);
            }else {
                map.put(A[i],1);
            }
            list.add(map.size());
        }
        return list;
    }
}
