package com.company.GFG.Hashing;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public static void main(String[] args) {

    }
    public boolean keypair(int[] A, int N, int X) {
       Set<Integer> set=new HashSet<>();

       for(int i=0;i<N;i++){
           if(set.contains(X-A[i])){
               return true;
           }else{
               set.add(A[i]);
           }
       }

       return false;

    }
}
