package com.company.leetcode.sort;

import com.company.GFG.dp.ArrayUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class InsertInterval {

    public static void main(String[] args) {

        int[][] d3 = {{1, 5}};
        int[] nd3 = {5, 7};
        int[][] r3 = insert(d3, nd3);
        ArrayUtil.print(r3);
        System.out.println("*******************");
        int[][] d2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int nd2[] = {4, 8};
        int[][] r2 = insert(d2, nd2);
        ArrayUtil.print(r2);

        int[][] d1 = {{1, 3}, {6, 9}};
        int nd1[] = {2, 8};
        int[][] r1 = insert(d1, nd1);
        ArrayUtil.print(r1);
    }

    public static int[][] insert(int[][] in, int[] nin) {

        int[][] result = new int[in.length + 1][2];
        for (int i = 0; i < in.length; i++) {
            result[i] = in[i];
        }
        result[result.length - 1] = nin;
        Arrays.sort(result, (a, b) -> a[0] - b[0]);

        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < result.length; i++) {
            if (i == result.length - 1) {
                list.add(result[i]);
                break;
            }
            if (result[i][1] >= result[i + 1][0]) {
                int startIdex = i;
                int max = result[i][1];
                while (i + 1 < result.length && max >= result[i + 1][0]) {
                    max = Math.max(max, result[i + 1][1]);
                    i++;
                }
                result[startIdex][1] = max;
                list.add(result[startIdex]);
            } else {
                list.add(result[i]);
            }
        }

        int[][] r = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            r[i] = list.get(i);
        }

        return r;


    }
}
