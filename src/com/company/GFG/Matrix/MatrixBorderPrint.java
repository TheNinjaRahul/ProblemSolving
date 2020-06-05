package com.company.GFG.Matrix;

public class MatrixBorderPrint {
    public static void main(String[] args) {
//        int[][] c = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15}};
////        boundaryTraversal(c.length,c[0].length,c);
//        int[][] d = {{0, 1, 2, 3}, {4, 5, 6, 7}};
//        boundaryTraversal(d.length,d[0].length,d);
//        int[][] e = {{0, 1},{2,3},{4,5}};
//        boundaryTraversal(e.length,e[0].length,e);

        int[][] e = {{1, 2, 3, 4}};
//        boundaryTraversal(e.length, e[0].length, e);

        int[][] f = {{1}, {2}, {3}, {4}};
        boundaryTraversal(f.length, f[0].length, f);


    }


    static void boundaryTraversal(int n1, int m1, int a[][]) {
//        printMatrix(a);
        int i = 0;
        for (i = 0; i < m1; i++) {
            System.out.print(a[0][i] + " ");
        }
        int j = 1;
        for (j = 1; j < n1; j++) {
            System.out.print(a[j][m1 - 1] + " ");
        }
        int k = 0;
        for (k = m1 - 2; k >= 0 && n1 > 1; k--) {
            System.out.print(a[j - 1][k] + " ");
        }
        int last = 0;
        for (last = n1 - 2; last > 0 && m1 >1; last--) {
            System.out.print(a[last][k + 1] + " ");
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
