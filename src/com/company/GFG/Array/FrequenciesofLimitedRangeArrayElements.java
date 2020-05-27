package com.company.GFG.Array;

import java.util.ArrayList;

public class FrequenciesofLimitedRangeArrayElements {
    public static void main(String[] args) {


    }

    public static ArrayList<Integer> printFrequency(int arr[], int n) {
        ArrayList<Integer> list = new ArrayList<>();

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[arr[i]]++;
        }

        for (int i = 0; i < n; i++) {
            list.add(result[i]);
        }
        return list;
    }
}
