package com.company.GFG.Array;

import java.util.Arrays;

public class ConvertArrayTowave {
    public static void main(String[] args) {
        int data[]={1,2,3,4,5};
        convertToWave(data,data.length);
        System.out.println(Arrays.toString(data));
    }

    static void swap(int arr[], int a, int b) {
        if(b>=arr.length) return;
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

   static void convertToWave(int a[], int n) {
        for(int i=0;i<n;i=i+2){
            swap(a,i,i+1);
        }
    }
}


