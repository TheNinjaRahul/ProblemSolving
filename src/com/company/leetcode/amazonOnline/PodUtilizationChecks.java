package com.company.leetcode.amazonOnline;

import java.util.*;

public class PodUtilizationChecks {
    public static void main(String[] args) {
        int[] cpu = {25, 23, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 76, 80};
        System.out.println(finalInstances(2, cpu));
    }

    public static int finalInstances(int instances, int[] averageUtil) {
        double limit = 2 * Math.pow(10, 8);
        for (int i = 0; i < averageUtil.length; i++) {
            if (averageUtil[i] < 25) {
                instances = (instances / 2) + (instances % 2 == 0 ? 0 : 1);
                i += 10;
            } else if (averageUtil[i] > 60) {
                int newinstance = 2 * instances;
                if (newinstance <= limit) {
                    instances = newinstance;
                    i += 10;
                }
            }
        }
        return instances;
    }
}
