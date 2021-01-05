package com.company.leetcode.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class JumpGameIII {
    public static void main(String[] args) {
        int[] a = {4, 2, 3, 0, 3, 1, 2};
        System.out.println(canReach(a, 5));
    }

    public static boolean canReach(int[] a, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        Set<Integer> set = new HashSet<>();
        set.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.remove();
                if (a[temp] == 0) return true;
                int suma = temp + a[temp];
                if (suma >= 0 && suma < a.length) {
                    if (!set.contains(suma)) {
                        queue.add(suma);
                        set.add(suma);
                    }
                }
                int minusa = Math.abs(a[temp] - temp);
                if (minusa >= 0 && minusa < a.length) {
                    if (!set.contains(minusa)) {
                        queue.add(minusa);
                        set.add(minusa);
                    }
                }
            }
        }
        return false;

    }
}
