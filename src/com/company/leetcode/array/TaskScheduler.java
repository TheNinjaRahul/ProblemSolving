package com.company.leetcode.array;

import java.util.*;

public class TaskScheduler {
    public static void main(String[] args) {

        char[] char3 = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        System.out.println(leastInterval(char3, 2));

        char[] chars2 = {'A', 'A', 'A'};
        System.out.println(leastInterval(chars2, 0));

        char[] chars = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(leastInterval(chars, 1));

    }

    static class Schedule {
        char c;
        int freq;

        public Schedule(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }

        @Override
        public String toString() {
            return "Schedule{" +
                    "c=" + c +
                    ", freq=" + freq +
                    '}';
        }
    }

    public static int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        Map<Character, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Schedule> queue1 = new PriorityQueue<Schedule>((a, b) -> {
            return b.freq - a.freq;
        });
        PriorityQueue<Schedule> queue2 = new PriorityQueue<Schedule>((a, b) -> {
            return b.freq - a.freq;
        });

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            queue1.add(new Schedule(e.getKey(), e.getValue()));
        }
        List<Character> list = new LinkedList<>();
        while (!queue1.isEmpty()) {
            int idle = n + 1;
            while (!queue1.isEmpty() && idle > 0) {
                Schedule temp = queue1.remove();
                if (temp.freq == 1 && queue2.isEmpty()) {
                    list.add(temp.c);
                    continue;
                }
                list.add(temp.c);
                if (temp.freq != 1) {
                    temp.freq--;
                    queue2.add(temp);
                }
                idle--;
            }
            while (idle > 0 && (!queue1.isEmpty() || !queue2.isEmpty())) {
                list.add('$');
                idle--;
            }
            while (!queue2.isEmpty()) {
                queue1.add(queue2.remove());
            }
        }
        System.out.println(list);
        return list.size();
    }
}

