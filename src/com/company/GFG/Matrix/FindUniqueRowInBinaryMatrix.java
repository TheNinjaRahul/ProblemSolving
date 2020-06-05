package com.company.GFG.Matrix;

public class FindUniqueRowInBinaryMatrix {
    public static void main(String[] args) {
        int[][] a = {{1, 1, 0, 1}, {1, 0, 0, 1}, {1, 1, 0, 1}};
        printMat(a, 1, 1);
//        System.out.println();
    }

    public static void printMat(int a[][], int r, int c) {
        Node root = new Node();
        printMatrix(a);
        for (int i = 0; i < a.length; i++) {
            insert(root, i, 0, a);
        }
        printTree(root,"");
    }

    private static void printTree(Node root,String str) {

        if (root.child[0]==null && root.child[1]==null) {
            System.out.println(str);
        } else {
            if (root.child[0] != null) {
                printTree(root.child[0],str+"0 ");
            }
            if (root.child[1] != null) {
                printTree(root.child[1],str+"1 ");
            }
        }
    }

    private static void insert(Node root, int row, int col, int[][] a) {
        if (col >= a[0].length) {
            return;
        }
        if (a[row][col] == 0) {
            if (root.child[0] != null) {
                insert(root.child[0], row, col+1, a);
            } else {
                root.child[0] = new Node();
                insert(root.child[0], row, col+1, a);
            }
        } else {
            if (root.child[1] != null) {
                insert(root.child[1], row, col+1, a);
            } else {
                root.child[1] = new Node();
                insert(root.child[1], row, col+1, a);
            }
        }
    }

    static class Node {
        Node child[] = new Node[2];
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
