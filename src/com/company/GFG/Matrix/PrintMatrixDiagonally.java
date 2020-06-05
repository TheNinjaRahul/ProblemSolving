package com.company.GFG.Matrix;

import javax.swing.plaf.ListUI;

public class PrintMatrixDiagonally {
    public static void main(String[] args) {
        int[][] a={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        printMatrixDiagonal(a,a.length);

    }

    static void printMatrixDiagonal(int a[][], int n)
    {
        int i=0,j=0;
        boolean flag=true;
        for(int no=0;no<n*n;){
            if(flag){
                for(;i>=0 && j < n ; i--,j++){
                    System.out.print(a[i][j]+ " ");
                    no++;
                }
                if(i==-1 && j<n){
                    i=0;
                }
                if(j==n){
                    j--;
                    i+=2;
                }
//                System.out.print(a[i][j]+ " ");
            }else{
                for(;j>=0 && i < n ; i++,j--){
                    System.out.print(a[i][j]+ " ");
                    no++;
                }
                if(j==-1 && i<n){
                    j=0;
                }
                if(i==n){
                    i--;
                    j+=2;
                }
            }
            flag=!flag;
        }
    }
    private static void printMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
