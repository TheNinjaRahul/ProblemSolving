package com.company.leetcode.matrix;

public class SearchInMatrix {

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5));
        System.out.println(searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 18));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int first = -1;
        int last = -1;

        for (int i = 0; i < n; i++) {
            if (target >= matrix[0][i] && target <= matrix[m - 1][i]) {
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] >= target && target <= matrix[i][m - 1]) {
                int left = first, right = last;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (matrix[i][mid] == target) return true;
                    if (matrix[i][mid] > target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }

        return false;
    }
}
