package com.company.GFG.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {

        int data[] = {3, 2, 5, 3, 7, 1, 2, 3};
        mergeSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }


    static void mergeSort(int arr[], int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr , m+1, r);
            merge(arr, l, m, r);
        }
    }
    static void merge(int a[], int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            merge(a, l, mid);
            merge(a, mid + 1, r);
            merge(a, l, mid, r);
        }
    }
    private static void merge2(int[] a, int l, int mid, int r) {
        int p1=l,p2=mid+1;
        int temp=-1;
        while(p1<=r && p2<=r){
            if(temp!=-1){
                if(temp<=a[p2]){
                    int temp2=a[p1];
                    a[p1++]=temp;
                    temp=temp2;
                }else{
                    int temp2=a[p1];
                    a[p1++]=a[p2];
//                    a[p2]=temp;
                    p2++;
                    temp=temp2;
                }
            }
            if(a[p2]<=a[p1]){
                temp=a[p1];
                a[p1]=a[p2];
                p1++;
                p2++;
            }else {
                temp=a[p1];
                a[p1]=a[p2];
                p1++;
                p2++;
            }

        }
        if(p1>r){
            a[p2]=temp;
        }else{
            a[p1]=temp;
        }

    }

    private static void merge(int[] a, int l, int mid, int r) {
        int p1 = l, p2 = mid+1;
//        p1=0;p2=0;
        int k=0;
        int [] tempp=new int[r-l+1];
        while(p1<=mid && p2<=r){
            if(a[p1]>a[p2]){
               tempp[k++]=a[p2++];
            }else{
                tempp[k++]=a[p1++];
            }
        }
        while(p1<=mid){
            tempp[k++]=a[p1++];
        }
        while(p2<=r){
            tempp[k++]=a[p2++];
        }

        p1=l;
        for(int i=0;i<tempp.length;i++){
            a[p1++]=tempp[i];
        }
    }
}
