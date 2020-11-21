package com.company.leetcode.array;

import java.util.*;

public class CountNumberOfTeams {
    public static void main(String[] args) {
        CountNumberOfTeams cn = new CountNumberOfTeams();
        System.out.println(cn.numTeams(new int[]{2, 5, 3, 4, 1}));
    }

    int res = 0;

    public int numTeams(int[] rating) {
        res = 0;
        helper(rating, 0, new ArrayList<Integer>());
        return res;
    }

    public void helper(int[] rating, int start, ArrayList<Integer> list) {

        if (list.size() == 3) {
            System.out.println(list);
            if (((list.get(0) > list.get(1)) && (list.get(1) > list.get(2))) ||
                    ((list.get(0) < list.get(1)) && (list.get(1) < list.get(2)))) {
                System.out.println(list);
                res++;
                return;
            } else {
                return;
            }
        }

        if (start >= rating.length) return;

        for (int i = start; i < rating.length; i++) {
            list.add(rating[i]);
            helper(rating, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

}
