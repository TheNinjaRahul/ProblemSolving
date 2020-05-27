package com.company.GFG.sort;

import java.util.Arrays;

public class Sort012 {
    public static void main(String[] args) {
//        int []data={0 ,2 ,1 ,2 ,0};
        int[] data={1,0,1,2,1,1,0,0,1,2,1,2,1,2,1,0,0,1,1,2,2,0,0,2,2,2,1,1,1,2,0,0,0,2,0,1,1,1,1,0,0,0,2,2,1,2,2,2,0,2,1,1,2,2,0,2,2,1,1,0,0,2,0,2,2,1,0,1,2,0,0,0,0,2,0,2,2,0,2,1,0,0,2,2};
        segragate012(data,data.length);
        System.out.println(Arrays.toString(data));
    }

    public static void segragate012(int a[], int N){

        int low=0,mid=1,high=N-1;

        while(mid<=high){

            switch (a[mid]){
                case 0:
                    swapa(a,mid,low);
                    mid++;
                    low++;
                    break;
                case 1:
                    mid++;break;
                case 2:
                    swapa(a,mid,high);
                    high--;
                    break;
            }

        }
    }

    private static void swapa(int[] a, int low, int high) {
        int temp=a[low];
        a[low]=a[high];
        a[high]=temp;
    }
}
