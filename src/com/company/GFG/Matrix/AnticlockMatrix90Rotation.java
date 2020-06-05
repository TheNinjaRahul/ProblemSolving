package com.company.GFG.Matrix;

public class AnticlockMatrix90Rotation {
    public static void main(String[] args) {
        int[][] a = {{0, 1}, {2, 3}};
        int[][] b = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        int[][] c = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15}};
        int[][] d = {{0, 1, 2, 3, 4}, {5, 6, 7, 8, 9}, {10, 11, 12, 13, 14}, {15, 16, 17, 18, 19},{20,21,22,23,24}};

//        rotate(a);
//        System.out.println("-----------------------------------");
//        rotate(b);
//        System.out.println("-----------------------------------");
//        rotate(c);
        System.out.println("-----------------------------------");
        rotate(d);
        System.out.println("-----------------------------------");
    }

    private static void rotate(int[][] a) {
//        printMatrix(a);

        int level = 0;
        int length = a.length - 1;
        int totalLevel = a.length / 2;
        while (level < totalLevel) {
            for (int i = level; i < length; i++) {
                swap(a, level, i, length - i + level, level);
                swap(a, level, i, length, length - i + level);
                swap(a, level, i, i, length);
//                System.out.println("----------- Step:"+i);
//                printMatrix(a);
            }
            level++;
            length--;
        }

//        System.out.println("------------ OUTPUT------------");
//        printMatrix(a);
    }

    private static void swap(int[][] a, int p1, int p2, int q1, int q2) {
        int temp = a[p1][p2];
        a[p1][p2] = a[q1][q2];
        a[q1][q2] = temp;
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
