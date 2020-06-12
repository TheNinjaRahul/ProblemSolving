package com.company.GFG.String;

/**
 * Given three strings A, B and C your task is to complete the function isInterleave which returns true if C is an interleaving of A and B else returns false. C is said to be interleaving A and B, if it contains all characters of A and B and order of all characters in individual strings is preserved.
 * <p>
 * Input:
 * The first line of input contains an input T denoting the no of test cases. Then T test cases follow. Each test case contains three space separated strings A, B, C.
 * <p>
 * Output:
 * For each test case output will be 1 if C is interleaving of string A and B else 0.
 * <p>
 * Constraints:
 * 1<=T<=100
 * 1<=length of A, B, C <=100
 * <p>
 * Example(To be used only for expected output):
 * Input:
 * 2
 * YX  X  XXY
 * XY X XXY
 * <p>
 * Output
 * 0
 * 1
 * <p>
 * Explanation:
 * 1. For first test case XXY is not interleaving of YX and X
 * 2. For the sec test case XXY is interleaving of XY and X.
 */
public class InterleavedStrings {
    public static void main(String[] args) {
        System.out.println(isInterLeave("YX", "X", "XXY"));
        System.out.println(isInterLeave("XY", "X", "XXY"));
        System.out.println(isInterLeave("YXXYXX", "YYYXX", "YXXYYXXXXYX"));
    }


    private static boolean isInterLeave(String a, String b, String c) {
        if ((a.length() + b.length()) != c.length()) {
            return false;
        }
        boolean[][] table = new boolean[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0 && j == 0) {
                    table[0][0] = true;
                    continue;
                }
                int targetIndex = i + j;
                if (i == 0) {
                    if (c.charAt(targetIndex - 1) == b.charAt(j - 1)) {
                        table[i][j] = table[i][j - 1];
                    }
                } else if (j == 0) {
                    if (c.charAt(targetIndex - 1) == a.charAt(i - 1)) {
                        table[i][j] = table[i - 1][j];
                    }
                } else {
                    table[i][j] = (c.charAt(targetIndex - 1) == a.charAt(i - 1) ? table[i - 1][j] : false) || (c.charAt(targetIndex - 1) == b.charAt(j - 1) ? table[i][j - 1] : false);
                }
            }
        }
        return table[a.length()][b.length()];
    }

    public static boolean isInterLeave2(String a, String b, String c) {
        if (a.length() + b.length() != c.length()) return false;
        return checkInterleaving(a, b, c, 0, 0, 0);
    }

    private static void printMatrix(boolean[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print((a[i][j] ? "1" : "0") + " ");
            }
            System.out.println();
        }
    }

    private static boolean checkInterleaving(String a, String b, String c, int i, int j, int k) {

        if (i > a.length()) return false;
        if (j > b.length()) return false;
        if (k == c.length()) return true;

        if (i == a.length()) {
            if (b.charAt(j) == c.charAt(k)) {
                return checkInterleaving(a, b, c, i, j + 1, k + 1);
            } else {
                return false;
            }
        }

        if (j == b.length()) {
            if (a.charAt(i) == c.charAt(k)) {
                return checkInterleaving(a, b, c, i + 1, j, k + 1);
            } else {
                return false;
            }
        }

        if (a.charAt(i) == b.charAt(j)) {
            if (a.charAt(i) == c.charAt(k)) {
                return checkInterleaving(a, b, c, i, j + 1, k + 1) || checkInterleaving(a, b, c, i + 1, j, k + 1);
            } else {
                return false;
            }
        }

        if (a.charAt(i) == c.charAt(k)) {
            return checkInterleaving(a, b, c, i + 1, j, k + 1);
        }

        if (b.charAt(j) == c.charAt(k)) {
            return checkInterleaving(a, b, c, i, j + 1, k + 1);
        }

        return false;
    }

}
