package com.company.GFG.Array;

import java.util.Arrays;

public class FindTriplet {
    public static void main(String[] args) {
        int data[] = {6, 4, 9, 7, 8};
        System.out.println(findTriplet(data, data.length));
    }

    public static long findTriplet(int arr[], int n) {
        Arrays.sort(arr);
        long result=0;
        for(int i=0;i<n-1;i++){

            int a=i+1,b=n-1;
            while(b>=i+2){
                if(arr[i]+arr[a]>arr[b]){
                    result+=(b-a);
                    a=i+1;
                    b--;
                }else{
                    a++;
                    if(a==b){
                        a=i+1;
                        b--;
                    }
                }
            }
        }
        return result;
    }
}
