package com.company.leetcode.array;

import java.util.*;

public class MostVisitedSectorInACircularTrack {
    public static void main(String[] args) {
        MostVisitedSectorInACircularTrack m = new MostVisitedSectorInACircularTrack();

        int[] d2 = {2, 1, 2, 1, 2, 1, 2, 1, 2};
        System.out.println(m.mostVisited(2, d2));

        int[] d = {1, 3, 1, 2};
        System.out.println(m.mostVisited(4, d));
    }

    class myData {
        int round;
        int fre;

        public myData(int round, int fre) {
            this.round = round;
            this.fre = fre;
        }

        @Override
        public String toString() {
            return "myData{" +
                    "round=" + round +
                    ", fre=" + fre +
                    '}';
        }
    }

    public List<Integer> mostVisited(int n, int[] rounds) {
        Map<Integer, myData> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new myData(i, 0));
        }

        map.get(rounds[0]).fre++;
        System.out.println(map);
        for (int i = 0; i + 1 < n; i++) {
            int start = rounds[i];
            int end = rounds[i + 1];
            if (start < end) {
                for (int j = start + 1; j <= end; j++) {
                    map.get(j).fre++;
                }
            } else {
                int steps = n - start;
                steps += end - 0;
                while (steps > 0) {
                    start++;
                    if (start <= n) {
                        map.get(start).fre++;
                    } else {
                        int current = (start % n);
                        map.get(current).fre++;
                    }
                    steps--;
                }
            }
//            System.out.println(map);
        }

//        System.out.println(map);
        /*for (int i = 0; i + 1 < n; i++) {
            int start = rounds[i];
            int end = rounds[i + 1];
            int steps = 0;
            if (start < end) {
                steps = end - start;
            } else {
                steps = n - start;
                steps += end - 0;
            }
            while (steps >= 0) {
                if (map.containsKey(start - 1)) {
                    map.get(start - 1).fre++;
                    start++;
                    start %= n;
                    steps--;
                } else {
                    System.out.println("Key not found: " + (start - 1));
                    break;
                }

            }

        }*/

        PriorityQueue<myData> set = new PriorityQueue<>((o1, o2) -> -(o1.fre - o2.fre));

        for (int key : map.keySet()) {
            set.add(map.get(key));
        }
        Set<Integer> res = new TreeSet<>();
        int latest = set.peek().fre;
        System.out.println(set);
        while (!set.isEmpty() && set.peek().fre == latest) {
            res.add(set.remove().round);
        }
        return new LinkedList<>(res);

    }
}
