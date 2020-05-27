package com.company.GFG.Array;

import java.util.Arrays;

public class RearrangeAnArrayWith1ExtraSpace {
    public static void main(String[] args) {
        long data[]={4 ,0 ,2 ,1 ,3};
        System.out.println(Arrays.toString(data));
        arrange(data,data.length);
        System.out.println(Arrays.toString(data));
    }

    static void arrange(long data[], int n){
        for(int i=0;i<data.length;i++){
            long value=(data[(int)data[i]]%data.length);
            data[i]=data[i]+value*data.length;
        }

        for(int i=0;i<data.length;i++)
            data[i]/=data.length;


    }
}
