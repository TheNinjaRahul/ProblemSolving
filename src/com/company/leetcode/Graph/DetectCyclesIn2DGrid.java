package com.company.leetcode.Graph;

import com.company.leetcode.hash.MyHashSet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class DetectCyclesIn2DGrid {
    public static void main(String[] args) {
        char[][] c = {
                {'a', 'a'}, {'a', 'a'}
        };
        DetectCyclesIn2DGrid d = new DetectCyclesIn2DGrid();
//        System.out.println(d.containsCycle(c));

        char[][] c4 = {{'c', 'c', 'c', 'a'}, {'c', 'd', 'c', 'c'}, {'c', 'c', 'e', 'c'}, {'f', 'c', 'c', 'c'}};
        System.out.println(d.containsCycle(c4));

        char[][] c2 = {{'a', 'a', 'a', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'a', 'a', 'a'}};
        System.out.println(d.containsCycle(c2));
        char[][] c3 = {{'a', 'b', 'b'}, {'b', 'z', 'b'}, {'b', 'b', 'a'}};
        System.out.println(d.containsCycle(c3));
    }

    class MyPoint {
        int i, j;

        public MyPoint(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "MyPoint{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }

    public boolean containsCycle(char[][] grid) {

        Map<Character, MyPoint> map = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!map.containsKey(grid[i][j])) {
                    map.put(grid[i][j], new MyPoint(i, j));
                }
            }
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int x[] = {0, 0, 1, -1};
        int y[] = {1, -1, 0, 0};
        for (Map.Entry<Character, MyPoint> e : map.entrySet()) {
            if (detectCycle(e.getKey(), e.getValue(), grid, visited, x, y)) {
                return true;
            }
        }

        return false;
    }

    private boolean detectCycle(Character key, MyPoint value, char[][] grid, boolean[][] visited, int[] x, int[] y) {
        if (visited[value.i][value.j]) {
            return true;
        }

        Map<MyPoint, MyPoint> parentMap = new HashMap<>();
        Queue<MyPoint> queue = new LinkedList<>();
        queue.add(value);


        while (!queue.isEmpty()) {
            MyPoint temp = queue.remove();

            for (int i = 0; i < x.length; i++) {
                int xx = x[i] + temp.i;
                int yy = y[i] + temp.j;
                if (check(xx, yy, grid, key, parentMap.get(temp))) {
                    MyPoint p = parentMap.get(temp);
                    if (visited[xx][yy] && p != null && p.i != xx && p.j != yy) {
                        return true;
                    } else {
                        if (p == null || (p.i != xx || p.j != yy)) {
                            MyPoint a = new MyPoint(xx, yy);
                            parentMap.put(a, temp);
                            queue.add(a);
                        }

                    }
                }
            }
            visited[temp.i][temp.j] = true;
        }
        return false;
    }

    private boolean check(int xx, int yy, char[][] grid, Character key, MyPoint parent) {
        boolean result = xx >= 0 && xx < grid.length && yy >= 0 && yy < grid[0].length && grid[xx][yy] == key;
        return result;
    }
}