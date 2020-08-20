package com.company.GFG.BackTracking;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class RatInAMaze {
    public static void main(String[] args) {
        int[][] data = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};

        System.out.println(printPath(data, 4));
    }

    public static ArrayList<String> printPath(int[][] m, int n) {


        boolean[][] visited = new boolean[m.length][m[0].length];
        ArrayList<String> result = new ArrayList<>();
        if (m.length == 0 || m[0][0]==0) return result;


        LinkedList<Character> sb = new LinkedList<>();
        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, -1, 1};
        char step[] = {'U', 'D', 'L', 'R'};
        dfs(sb, result, visited, 0, 0, m, x, y, step);
        Collections.sort(result);
        return result;
    }

    private static void dfs(LinkedList<Character> sb, ArrayList<String> result, boolean[][] visited, int i, int j, int[][] m, int[] x, int[] y, char[] step) {
        if (i == m.length - 1 && j == m[0].length - 1) {
            StringBuilder s = new StringBuilder();
            for (Character c : sb) {
                s.append(c);
            }
            result.add(s.toString());
            return;
        }


        for (int k = 0; k < 4; k++) {
            int xx = i + x[k];
            int yy = j + y[k];
            if (xx < m.length && xx >= 0 && yy < m[0].length && yy >= 0 && m[xx][yy] == 1 && !visited[xx][yy]) {
                sb.addLast(step[k]);
                visited[i][j] = true;
                dfs(sb, result, visited, xx, yy, m, x, y, step);
                visited[i][j] = false;
                sb.removeLast();
            }
        }
    }
}
