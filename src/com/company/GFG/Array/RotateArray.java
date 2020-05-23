package com.company.GFG.Array;

import java.util.Arrays;
import java.util.List;

public class RotateArray {
    public static void main(String[] args) {
//        int data[] = {1, 2, 3, 4, 5, 6, 7,8,9,10,11,12,13,14,15,16,17};
        int data[]={51,69,72,74,32,82,31,34,95,61,64,100,82,100,97,60,74,14,69,91,96,27,67,85,41,91,85,77,43,37,8,46,57,80,19,88,13,49,73,60,10,37,11,43,88,7,2,14,73,22,56,20,100,22,5,40,12,41,68,6,29,28,51,85,59,21,25,23,70,97,82,31,85,93,73,73,51,26,86,23,100,41,43,99,14,99,91,25,91,10,82,20,37,33,56,95,5,80,70,74};
        rotateArr(data, 80, data.length);

        int[] data3={1,2,3,4,5,6,7,8,9,10};
        rotateArr(data3, 2, data3.length);
       for(int i=0;i<data.length;i++){
           System.out.print(data[i]+" ");
       }
    }

    static void rotateArr(int a[], int d, int n) {
        d = d % a.length;

        int count = 0, pi = -1, ni = 0, temp = a[0],lastIteration=-1;
        while (count < a.length) {
            if(lastIteration==pi){
                pi++;
                temp = a[pi];
                lastIteration=pi;
            }
            ni=pi-d;
            if(ni<0){
                ni=a.length-(Math.abs(ni));
            }

//            ni = (pi + d) % a.length;
            int temp2 = a[ni];
            a[ni] = temp;
            temp = temp2;
            count++;
            pi=ni;
        }
    }

}
