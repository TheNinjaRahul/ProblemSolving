package com.company.leetcode.backtracking;

import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        int[] d = {2, 3, 6, 7};
        CombinationSum c = new CombinationSum();
        System.out.println(c.combinationSum(d, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> currentList = new LinkedList<>();

        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                currentList.add(candidates[i]);
                backTrack(candidates, target - candidates[i], currentList, result, i);
                currentList.removeLast();
            }
        }

        return result;
    }

    private void backTrack(int[] candidates, int target, LinkedList<Integer> currentList, List<List<Integer>> result, int startPoint) {
        if (target == 0) {
            List<Integer> l = new LinkedList<>();
            l.addAll(currentList);
            result.add(l);
            return;
        }

        for (int i = startPoint; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                currentList.add(candidates[i]);
                backTrack(candidates, target - candidates[i], currentList, result, i);
                currentList.removeLast();
            }
        }
    }

}
