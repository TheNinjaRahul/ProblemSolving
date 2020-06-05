package com.company.leetcode.sort;

import java.util.Arrays;

public class TwoCityScheduling {
    public static void main(String[] args) {
        int a[][]={{10,20},{30,200},{400,50},{30,20}};
        twoCitySchedCost(a);
        System.out.println(twoCitySchedCost(a));
    }

    public static int twoCitySchedCost(int[][] a) {

        Arrays.sort(a,(o1, o2) -> {
            return (o1[0]-o1[1]) - (o2[0]-o2[1]);
        });

        int sum=0;

        for(int i=0;i<a.length;i++){
            sum+=i/2==0?a[i][0]:a[i][1];
        }

        return sum;
    }
}
