package com.company.leetcode.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class CatAndMouseII {
    public static void main(String[] args) {

    }

    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        int[] m = new int[2];
        int[] c = new int[2];

        char[][] g = new char[grid.length][grid[0].length()];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                char c1 = grid[i].charAt(j);
                if (c1 == 'M') {
                    m[0] = i;
                    m[1] = j;
                }
                if (c1 == 'C') {
                    c[0] = i;
                    c[1] = j;
                }
                g[i][j] = c1;
            }
        }

        Queue<int[]> mouse = new LinkedList<>();
        Queue<int[]> cat = new LinkedList<>();
        mouse.add(m);
        cat.add(c);

        while (!mouse.isEmpty()) {

        }

        while (!cat.isEmpty()) {

        }

        return false;

    }

}
