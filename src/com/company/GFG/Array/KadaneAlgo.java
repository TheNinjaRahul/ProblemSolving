package com.company.GFG.Array;

public class KadaneAlgo {
    public static void main(String[] args) {
//        int data[]={8 ,-8, 9 ,-9 ,10 ,-11 ,12};
//        int a[]={4,-3,-2,2,3,1,-2,-3,4,2,-6,-3,-1,3,1,2};

        int data[]={-18,-2};
        System.out.println(maxRotation(data));
    }

    private static int maxRotation(int[] data) {
        int kadaneResult=kadanes(data);

        int maxSum=0;
        for(int i=0;i<data.length;i++){
            maxSum+=data[i];
            data[i]=-data[i];
        }

        maxSum=maxSum+kadanes(data);
        return  maxSum==0 ? kadaneResult : Math.max(kadaneResult,maxSum);

    }

    public static int kadanes(int arr[]){
        int n = arr.length;

        int i = 1;

        int res = arr[0];
        int temp = arr[0];
        while(i < n){
            //to handle the "all negative" case
            temp = Math.max(arr[i] + temp, arr[i]);
            res = Math.max(res, temp);
            i++;
        }
        return res;
//        System.out.println(start+" "+end);
//        System.out.println(max);

    }



}
