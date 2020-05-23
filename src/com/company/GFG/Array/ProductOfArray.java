package com.company.GFG.Array;

import java.util.Arrays;

public class ProductOfArray {
    public static void main(String[] args) {
        int data[]={10 ,3 ,5 ,6, 2};
        System.out.println(Arrays.toString(productExceptSelf(data,data.length)));
    }

    public static long[] productExceptSelf(int arr[], int n)
    {
        long [] result=new long[n];
        for (int j = 0; j < n; j++)
            result[j] = 1;
        long mul=1;
        long temp=1l;
        for(int i=0;i<n;i++){
            result[i]=temp;
            temp*=arr[i];
        }
        temp=1l;
        for(int i=n-1;i>=0;i--){
            result[i]*=temp;
            temp*=arr[i];
        }

        return result;

    }
}
