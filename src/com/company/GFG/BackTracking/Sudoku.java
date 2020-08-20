package com.company.GFG.BackTracking;

import sun.swing.StringUIClientPropertyKey;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sudoku {
    public static void main(String[] args) {
        int[][] data1 = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        System.out.println(SolveSudoku(data1));
        printGrid(data1);
    }


    static Map<Integer, int[]> map = new HashMap<>();

    static {
        map.put(1, new int[]{0, 0, 2, 2});
        map.put(2, new int[]{0, 3, 2, 5});
        map.put(3, new int[]{0, 6, 2, 8});
        map.put(4, new int[]{3, 0, 5, 2});
        map.put(5, new int[]{3, 3, 5, 5});
        map.put(6, new int[]{3, 1, 5, 8});
        map.put(7, new int[]{6, 0, 8, 2});
        map.put(8, new int[]{6, 3, 8, 5});
        map.put(9, new int[]{6, 6, 8, 8});
    }

    static boolean SolveSudoku(int grid[][]) {

        int row = -1;
        int col = -1;
        boolean isAnyEmpty = true;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    row = i;
                    col = j;
                    isAnyEmpty = false;
                    break;
                }
            }
            if (!isAnyEmpty) {
                break;
            }
        }

        if (isAnyEmpty) return true;

        for (int k = 1; k <= 9; k++) {
            if (validate(k, row, col, grid)) {
                grid[row][col] = k;
                if (SolveSudoku(grid)) {
                    return true;
                } else {
                    grid[row][col] = 0;
                }
            }
        }
        return false;
    }


    private static boolean validate(int k, int row, int col, int[][] grid) {


        //check column
        for (int i = 0; i < 9; i++) {
            if (grid[i][col] == k) {
                return false;
            }
        }

        //check row
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == k) {
                return false;
            }
        }

        //check block
        int blkrow = (row / 3) * 3, blkcol = (col / 3) * 3;

        // Remove 3x3 grid values
        for (int i = blkrow; i < blkrow + 3; i++) {
            for (int j = blkcol; j < blkcol + 3; j++) {
                if (grid[i][j] == k) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[] findBlock(int row, int col) {
        for (Map.Entry<Integer, int[]> e : map.entrySet()) {
            int[] block = e.getValue();
            if (row >= block[0] && col >= block[1] && row <= block[2] && col <= block[3]) {
                return block;
            }
        }
        return new int[]{};
    }

    static void printGrid(int grid[][]) {
        for (int[] i : grid) {
            System.out.println(Arrays.toString(i));
        }
    }

}
