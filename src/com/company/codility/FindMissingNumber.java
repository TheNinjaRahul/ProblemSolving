package com.company.codility;

import java.util.Set;
import java.util.TreeSet;

public class FindMissingNumber {
    public static void main(String[] args) {

    }

    public int solution(int[] A) {
        if(A.length==0) return 1;

        Set<Integer> set=new TreeSet<>();
        for(int i:A){
            set.add(i);
        }

        int i=1;
        for(int j:set){
            if(i!=j) return i;
            i++;
        }

        return i;
    }
}
