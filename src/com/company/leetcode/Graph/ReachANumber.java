package com.company.leetcode.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ReachANumber {
    public static void main(String[] args) {
        System.out.println(reachNumber(3));
    }

    public static int reachNumber(int target) {
        int n = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int jump = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.remove();
                if (temp == target) return jump;
                if (!set.contains(temp - n)) queue.add(temp - n);
                if (!set.contains(temp + n)) queue.add(temp + n);
            }
            n++;
            jump++;
        }
        return 0;
    }

}
