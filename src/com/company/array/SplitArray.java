package com.company.array;

import java.util.Arrays;

public class SplitArray {
    public static void main(String[] args) {

        int[] data={1,2,3,4,5,6,7,8,9,10};
        int d[]= Arrays.copyOfRange(data,0,5);
        int d2[]=Arrays.copyOfRange(data,5,10);
        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.toString(d2));
    }

}
