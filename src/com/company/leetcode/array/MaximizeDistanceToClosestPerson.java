package com.company.leetcode.array;

public class MaximizeDistanceToClosestPerson {
    public static void main(String[] args) {
        MaximizeDistanceToClosestPerson m = new MaximizeDistanceToClosestPerson();
        StringBuilder sb=new StringBuilder();
        
        System.out.println(m.maxDistToClosest(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}));
    }

    public int maxDistToClosest(int[] seats) {
        int start = -1, end = -1;
        int i = 0;
        int max = -1;
        while (i < seats.length) {
            if (seats[i] == 0) {
                int s = i;
                int e = i;
                while (i < seats.length && seats[i] == 0) {
                    e = i;
                    i++;
                }
                System.out.println(s + " " + e);
                if ((e - s) >= (end - start)) {
                    start = s;
                    end = e;
                }
                if (i == seats.length) {
                    if ((e - s) > (end - start) / 2) {
                        start = s;
                        end = e;
                    }
                }
                if (s == 0) {
                    max = e - s + 1;
                }
            }
            i++;
        }

        System.out.println(start + " " + end);
        if (end == seats.length - 1) {
            max = Math.max(end - start + 1, max);
        }
        return Math.max(((end - start) / 2), max);
    }
}
