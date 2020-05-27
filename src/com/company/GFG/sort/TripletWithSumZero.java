package com.company.GFG.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TripletWithSumZero {
    public static void main(String[] args) {
        int[] data = {4, -16, 43, 4, 7, -36, 18};
        System.out.println(findTriplets(data, data.length));
    }

    public static boolean findTriplets(int a[], int n) {

        Arrays.sort(a);

        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int rem = 0 - (a[i] + a[j]);
                if (set.contains(rem)) {
                   if(rem!= a[i] && rem!=a[j]){
                       return true;
                   }
                }
            }
        }
        return false;

    }
}
