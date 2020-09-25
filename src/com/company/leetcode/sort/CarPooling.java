package com.company.leetcode.sort;

import java.util.*;

public class CarPooling {
    public static void main(String[] args) {
        System.out.println(carPooling(new int[][]{{10, 5, 7}, {10, 3, 4}, {7, 1, 8}, {6, 3, 4}}, 24));
//        System.out.println(carPooling(new int[][]{{3, 2, 8}, {4, 4, 6}, {10, 8, 9}}, 11));
//        System.out.println(carPooling(new int[][]{{3, 2, 7}, {3, 7, 9}, {8, 3, 9}}, 11));
//        System.out.println(carPooling(new int[][]{{2, 1, 5}, {3, 5, 7}}, 3));
//        System.out.println(carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5));
//        System.out.println(carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4));

    }

    static class MyTripPojo implements Comparable<MyTripPojo> {
        int passenger;
        int startPoint;
        int endPoint;

        public MyTripPojo(int passenger, int startPoint, int endPoint) {
            this.passenger = passenger;
            this.startPoint = startPoint;
            this.endPoint = endPoint;
        }

        @Override
        public int compareTo(MyTripPojo o) {
            int r1 = this.endPoint - o.endPoint;
            return r1;
//            if (r1 == 0) {
//                return this.endPoint - o.endPoint;
//            } else {
//                return r1;
//            }
        }
    }

    public static boolean carPooling(int[][] t, int c) {
        Arrays.sort(t, (a, b) -> {
            int r = a[1] - b[1];
            if (r == 0) {
                return a[2] - b[2];
            } else {
                return r;
            }
        });

        for (int i = 0; i < t.length; i++) {
            System.out.println(Arrays.toString(t[i]));
        }

        Queue<MyTripPojo> queue = new PriorityQueue<>();
        for (int i = 0; i < t.length; i++) {
            while (queue.size() != 0) {

                int passengerCount = queue.peek().passenger;
                int startPoint = queue.peek().startPoint;
                int endPoint = queue.peek().endPoint;

                if (endPoint <= t[i][1]) {
                    c += passengerCount;
                    queue.remove();
                } else {
                    break;
                }
            }

            if (c >= t[i][0]) {
                c -= t[i][0];
                queue.add(new MyTripPojo(t[i][0], t[i][1], t[i][2]));
            } else {
                return false;
            }
        }
        return true;
    }
}
