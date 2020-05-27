package com.company.GFG.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int data[] = {57 ,38 ,91 ,10 ,38 ,28 ,79 ,41}                ;
        quickSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }

    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
        /* pi is partitioning index, arr[pi] is now
           at right place */
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);  // Before pi
            quickSort(arr, pi + 1, high); // After pi
        }
    }

    public static int partition2(int a[], int low, int high) {
        int i = 0, j = high - 1;
        int pivot = high;
        while (i < j) {
            while (i< high && a[i] < a[pivot]) {
                i++;
            }
            while (j >0 && a[j] > a[pivot]) {
                j--;
            }
            if (i < j) {
                int temp = a[i];
                a[i++] = a[j];
                a[j--] = temp;
            }
        }
        if(a[pivot]<a[i]){
            int temp = a[i];
            a[i] = a[pivot];
            a[pivot] = temp;
            return i;
        }

        return pivot;
    }

    public static int partition(int a[], int low, int high) {
        int i = low, j = high;
        int pivot = low;
        while (i < j) {
            while (i< high && a[i] <= a[pivot]) {
                i++;
            }
            while (j >0 && a[j] > a[pivot]) {
                j--;
            }
            if(i<j){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }

        }

            int temp = a[j];
            a[j] = a[pivot];
            a[pivot] = temp;

        return j;
    }
}
