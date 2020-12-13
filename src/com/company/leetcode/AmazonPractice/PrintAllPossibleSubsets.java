package com.company.leetcode.AmazonPractice;

import java.util.LinkedList;
import java.util.List;

public class PrintAllPossibleSubsets {
    public static void main(String[] args) {
        PrintAllPossibleSubsets p = new PrintAllPossibleSubsets();
        System.out.println(p.getAllSubset(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> getAllSubset(int[] a) {
        List<List<Integer>> lists = new LinkedList<>();
        List<Integer> tempList = new LinkedList<>();
        backTrackOfSubSets(a, 0, tempList, lists);
        return lists;
    }

    private void backTrackOfSubSets(int[] a, int start, List<Integer> tempList, List<List<Integer>> lists) {
        lists.add(new LinkedList<>(tempList));
        for (int i = start; i < a.length; i++) {
            tempList.add(a[i]);
            backTrackOfSubSets(a, i + 1, tempList, lists);
            tempList.remove(tempList.size() - 1);
        }
    }


}
