package com.company.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RightRotation {
    public static void main(String[] args) {
        System.out.println(circularArrayRotation(new int[]{1, 2, 3,4,5,6,7,8,9}, 2, new int[]{0, 1, 2}));
    }

    // Complete the circularArrayRotation function below.
    static int[] circularArrayRotation(int[] a, int k, int[] queries) {

        int rotation = k % a.length;
//        rotation++;


        List<Integer> data = new ArrayList<>();
        for (int i = a.length-rotation ;i < a.length; i++) {
            data.add(a[i]);
        }

        for (int i = 0;i < a.length-rotation ; i++) {
            data.add(a[i]);
        }

        int[] result = new int[queries.length];
        int j = 0;
        for (int i = 0;i < queries.length; i++) {
            result[i] = data.get(queries[j]);
            j++;
        }
         System.out.println(data);
        return result;
    }
}
