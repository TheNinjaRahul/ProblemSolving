package com.company.GFG.Array;

import java.util.Arrays;

public class ThreeSomeCloset {
    public static void main(String[] args) {
        int arr[] ={-7 ,9 ,8 ,3 ,1, 1};
       // System.out.println(threeSomeCloset(arr,2));

        int a[]={5 ,2 ,7 ,5};
        System.out.println(threeSomeCloset(a,13));
    }

    public static int threeSomeCloset(int[] data, int f) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(data);
        for (int i = 0; i < data.length-2; i++) {
            int p1 = i + 1, p2 = data.length - 1;
            while(p1<p2){
                int sum=data[i]+data[p1]+data[p2];
                if(Math.abs(f-sum) < Math.abs(f-result) ){
                    result=sum;
                }
                if(sum > f){
                    p2--;
                }else{
                    p1++;
                }
            }
        }

        return result;
    }
}
