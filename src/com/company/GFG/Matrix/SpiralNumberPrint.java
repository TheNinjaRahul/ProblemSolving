package com.company.GFG.Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralNumberPrint {
    public static void main(String[] args) {
        int[][] c = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15}};
//        System.out.println(findK(c,4,4,8));

        int[][] d = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(findK(d,3,3,4));
    }

    static int findK(int a[][], int no, int mo, int input)
    {
        printMatrix(a);
        int m=a.length;
        int n=a[0].length;
        int l=0,k=0;
        int count=0;
        while(l<m && k<n){

            for(int i=k;i<n;i++){
                count++;
                if(count==input){
                    return a[k][i];
                }
                // System.out.print(a[k][i]+" ");

            }

            k++;

            for(int i=k;i<m;i++){
                count++;
                if(count==input){
                    return a[i][n-1];
                }
                // System.out.print(a[i][n-1]+" ");

            }

            n--;

            if(k<m){
                for(int i=n-1;i>=l;i--){
                    count++;
                    if(count==input){
                        return a[m-1][i];
                    }
                    // System.out.print(a[m-1][i]+" ");

                }
                m--;
            }


            if(l<n){
                for(int i=m-1;i>l;i--){
                    count++;
                    if(count==input){
                        return a[i][l];
                    }
                    // System.out.print(a[i][l]+" ");

                }
                l++;
            }
        }
        return 0;

    }

    private static void printMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static List<Integer> spiralOrder(int[][] a) {

        printMatrix(a);
        List<Integer> list=new ArrayList<>();
        int m=a.length;
        int n=a[0].length;
        int l=0,k=0;

        while(l<m && k<n){

            for(int i=k;i<n;i++){
                System.out.print(a[k][i]+" ");
                list.add(a[k][i]);
            }

            k++;

            for(int i=k;i<m;i++){
                System.out.print(a[i][n-1]+" ");
                list.add(a[i][n-1]);
            }

            n--;

            if(k<m){
                for(int i=n-1;i>=l;i--){
                    System.out.print(a[m-1][i]+" ");
                    list.add(a[m-1][i]);
                }
                m--;
            }


            if(l<n){
                for(int i=m-1;i>l;i--){
                    System.out.print(a[i][l]+" ");
                    list.add(a[i][l]);
                }
                l++;
            }
        }
        return list;
    }
}
