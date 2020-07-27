package com.company.GFG.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.geeksforgeeks.org/find-whether-path-two-cells-matrix/
 */
public class CheckIfPathExist {
    public static void main(String[] args) {
        int[][] data = {{3, 0, 0, 0}, {0, 3, 3, 0}, {0, 1, 0, 3}, {0, 2, 3, 3}};
        System.out.println(is_possible(data, data.length));
    }


    public static int is_possible(int M[][], int N) {

        int sr = -1, sc = -1;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    sr = i;
                    sc = j;
                }
            }
        }

        Set<String> set = new HashSet<>();

        if (dfs(sr, sc, M, set)) {
            return 1;
        }
        return 0;
    }

    private static boolean dfs(int sr, int sc, int[][] m, Set<String> set) {

//        if (sr < 0 || sr >= m.length || sc < 0 || sc >= m[0].length) return false;
        if (m[sr][sc] == 2) return true;

        if (set.contains(sr + "" + sc)) return false;
        set.add(sr + "" + sc);

        boolean l = false, r = false, t = false, b = false;
        if (isValid(sr + 1, sc, m) && (m[sr + 1][sc] == 3 || m[sr + 1][sc] == 2)) {
            b = dfs(sr + 1, sc, m, set);
        }
        if (isValid(sr - 1, sc, m) && (m[sr - 1][sc] == 3 || m[sr - 1][sc] == 2)) {
            t = dfs(sr - 1, sc, m, set);
        }
        if (isValid(sr, sc + 1, m) && (m[sr][sc + 1] == 3 || m[sr][sc + 1] == 2)) {
            r = dfs(sr, sc + 1, m, set);
        }
        if (isValid(sr, sc - 1, m) && (m[sr][sc - 1] == 3 || m[sr][sc - 1] == 2)) {
            l = dfs(sr, sc - 1, m, set);
        }
        return b || t || r || l;

    }

    private static boolean isValid(int sr, int sc, int[][] m) {
        if (sr < 0 || sr >= m.length || sc < 0 || sc >= m[0].length) return false;
        return true;
    }


}
