package com.company.GFG.Matrix;

public class SpiralPrint {
    public static void main(String[] args) {
//        int[][] x={{1},{2},{3}};
//        spirallyTraverse(0,0,x);
//        int[][] a={{1,2},{3,4}};
//        spirallyTraverse(0,0,a);
        int[][] c = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15}};
        spirallyTraverse(c.length,c[0].length,c);
//        int[][] d={{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
//        spirallyTraverse(0,0,d);
    }

    //Complete this function
    static void spirallyTraverse(int m, int n, int a[][]) {
        printMatrix(a);

        int k=0,l=0;

        while(k<m && l<n){
            for(int i=k;i<n;i++){
                System.out.print(a[k][i] + " ");
            }
            k++;
            for(int j=k;j<m;j++){
                System.out.print(a[j][n-1] + " ");
            }
            n--;

            if(k<m){
                for(int i=n-1;i>=l;i--){
                    System.out.print(a[m-1][i] + " ");
                }
                m--;
            }

            if(l<n){
                for(int i=m-1;i>=k;i--){
                    System.out.print(a[i][l] + " ");
                }
                l++;
            }

        }

//        for (int level = 0; level <= cols/ 2; level++) {
//            int i = 0;
//            for (i = level; i < cols - level; i++) {
//                System.out.print(a[level][i] + " ");
//            }
//            int j = level;
//            for (j = level; j < rows - level; j++) {
//                System.out.print(a[j][i] + " ");
//            }
//            int k = rows - i;
//            for (k = cols - level; k > level; k--) {
//                System.out.print(a[j][k] + " ");
//            }
//            int last = rows - level;
//            for (last = rows - level; last >level; last--) {
//                System.out.print(a[last][k] + " ");
//            }
//        }

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
