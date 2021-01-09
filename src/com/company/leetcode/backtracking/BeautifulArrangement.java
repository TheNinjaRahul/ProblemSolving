package com.company.leetcode.backtracking;

import java.util.LinkedList;

public class BeautifulArrangement {
    public static void main(String[] args) {
        BeautifulArrangement b = new BeautifulArrangement();
        System.out.println(b.countArrangement(3));
    }

    public int countArrangement(int n) {
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = i;
        }

        LinkedList<Integer> list = new LinkedList<>();
        backtracking(a, list);
        return a[0];
    }

    private void backtracking(int[] a, LinkedList<Integer> list) {
        if (list.size() == a.length - 1) {
            System.out.println(list);
            boolean f = true;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) % (j + 1) == 0 || (j + 1) % list.get(j) == 0) {
                    //do nothing
                } else {
                    f = false;
                    break;
                }
            }
            if (f) {
                a[0]++;
            }
            return;
        } else {
            for (int j = 1; j < a.length; j++) {
                if (list.contains(a[j])) continue;
                list.add(a[j]);
                backtracking(a, list);
                list.removeLast();
            }
        }
    }
}
