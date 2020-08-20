package com.company.leetcode.number;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalTriangleII {
    public static void main(String[] args) {
        System.out.println(getRow(3));
    }

    public static List<Integer> getRow(int rowIndex) {

        List<Integer> result = new ArrayList<>();

        result.add(1);
        if (rowIndex == 0) return result;
        result.add(1);
        if (rowIndex == 1) return result;

        rowIndex -= 1;
        while (rowIndex != 0) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int i = 0; i < result.size() - 1; i++) {
                list.add(result.get(i) + result.get(i + 1));
            }
            list.add(1);
            result = list;
            rowIndex--;
        }

        return result;


    }
}
