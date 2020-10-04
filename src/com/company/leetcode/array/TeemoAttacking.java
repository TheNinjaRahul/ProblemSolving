package com.company.leetcode.array;

public class TeemoAttacking {
    public static void main(String[] args) {


        int d2[] = {1, 2};
        System.out.println(findPoisonedDuration(d2, 2));

        int d[] = {1, 4};
        System.out.println(findPoisonedDuration(d, 2));
    }

    public static int findPoisonedDuration(int[] t, int duration) {

        if (t.length == 0) return 0;
        int d = duration;
        int endTime = t[0] + duration;
        for (int i = 1; i < t.length; i++) {
            if (endTime < t[i]) {
                endTime = t[i] + duration;
                d += duration;
            } else {
                int temp = endTime - t[i];
                d += duration - temp;
                endTime += duration - temp;
            }
        }
        return d;
    }
}
