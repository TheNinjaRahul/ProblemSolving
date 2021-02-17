package com.company.leetcode.Graph;

import java.util.Arrays;

public class PathWithMinimumEffort {
    int ans = Integer.MAX_VALUE;
    int x[] = {1, -1, 0, 0};
    int y[] = {0, 0, 1, -1};

    public static void main(String[] args) {
        PathWithMinimumEffort pwm = new PathWithMinimumEffort();
        int a[][] = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        System.out.println(pwm.minimumEffortPath(a));
    }

    public int minimumEffortPath(int[][] a) {
        int start = 0, end = Integer.MAX_VALUE;
        int mid = 0;
        boolean[][] visited = new boolean[a.length][a[0].length];
        while (start <= end) {
            for (boolean[] b : visited) {
                Arrays.fill(b, false);
            }
            mid = start + (end - start) / 2;
            if (dfs2(0, 0, mid, a, visited)) {
                ans = Math.min(ans, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private boolean dfs2(int i, int j, int mid, int[][] a, boolean[][] visited) {
        if (i == a.length - 1 && j == a[0].length - 1) {
            return true;
        }
        boolean flag = false;
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int cx = i + x[k];
            int cy = j + y[k];
            if (isValid(i, j, cx, cy, a, mid) && !visited[cx][cy]) {
                flag |= dfs2(cx, cy, mid, a, visited);
            }
        }
        return flag;
    }

    private boolean isValid(int i, int j, int cx, int cy, int[][] a, int mid) {
        if (i >= 0 && i < a.length && j >= 0 && j < a[0].length &&
                cx >= 0 && cx < a.length && cy >= 0 && cy < a[0].length && Math.abs(a[i][j] - a[cx][cy]) <= mid) {
            return true;
        }
        return false;
    }

    public int minimumEffortPath2(int[][] a) {

        boolean[][] visited = new boolean[a.length][a[0].length];
        visited[0][0] = true;
        dfs(0, 0, 0, a, visited);

        return ans;
    }

    public void dfs(int i, int j, int diff, int[][] a, boolean[][] visited) {
        if (i == a.length - 1 && j == a[0].length - 1) {
            ans = Math.min(ans, diff);
            return;
        }


        for (int k = 0; k < 4; k++) {
            int cx = i + x[k];
            int cy = j + y[k];
            if (isValid(cx, cy, a) && !visited[cx][cy]) {
                visited[i][j] = true;
                dfs(cx, cy, Math.max(diff, Math.abs(a[i][j] - a[cx][cy])), a, visited);
                visited[i][j] = false;
            }
        }
    }

    public boolean isValid(int i, int j, int[][] a) {
        if (i < 0 || i > a.length - 1 || j < 0 || j > a[0].length - 1) return false;
        return true;
    }

    class Pair {
        int x;
        int y;
        int diff = 0;

        public Pair(int x, int y, int diff) {
            this.x = x;
            this.y = y;
            this.diff = diff;
        }
    }
}
