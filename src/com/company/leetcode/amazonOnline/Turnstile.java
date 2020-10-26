package com.company.leetcode.amazonOnline;

import java.util.*;

public class Turnstile {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(getTimes(5, new int[]{0, 1, 1, 3, 3}, new int[]{0, 1, 0, 0, 1})));
        System.out.println(Arrays.toString(getTimes(4, new int[]{0, 0, 1, 5}, new int[]{0, 1, 1, 0})));
    }

    public static int[] getTimes(int numCustomers, int[] arrTime, int[] direction) {
        int[] result = new int[numCustomers];

        Map<Integer, List<int[]>> map = new TreeMap<>();
        Queue<int[]> entryQ = new LinkedList<>();
        Queue<int[]> exitQ = new LinkedList<>();

        for (int i = 0; i < arrTime.length; i++) {
            if (!map.containsKey(arrTime[i])) map.put(arrTime[i], new LinkedList<>());
            map.get(arrTime[i]).add(new int[]{i, direction[i]});
        }

//        for (int key : map.keySet()) {
//            System.out.println(key + " -------");
//            for (int[] in : map.get(key)) {
//                System.out.println(Arrays.toString(in));
//            }
//        }

        int i = 0, j = 0;
        int turnstileDirection = -1;
        while (i <= arrTime[arrTime.length - 1]) {
            if (map.containsKey(i)) {
                for (int[] entries : map.get(i)) {
                    if (entries[1] == 1) {
                        exitQ.add(entries);
                    } else {
                        entryQ.add(entries);
                    }
                }
            }

            if (entryQ.isEmpty() && exitQ.isEmpty()) {
                i++;
                continue;
            }

            int[] current;
            if (!entryQ.isEmpty() && !exitQ.isEmpty()) {
                switch (turnstileDirection) {
                    case -1:
                        current = exitQ.remove();
                        turnstileDirection = 1;
                        result[j++] = current[0];
                        i++;
                        break;
                    case 1:
                        current = exitQ.remove();
                        turnstileDirection = 1;
                        result[j++] = current[0];
                        i++;
                        break;
                    case 0:
                        current = entryQ.remove();
                        turnstileDirection = 0;
                        result[j++] = current[0];
                        i++;
                        break;
                }
                continue;
            }

            if (!entryQ.isEmpty()) {
                current = entryQ.remove();
                turnstileDirection = 0;
                result[j++] = current[0];
                i++;
                continue;
            }

            if (!exitQ.isEmpty()) {
                current = exitQ.remove();
                turnstileDirection = 1;
                result[j++] = current[0];
                i++;
            }
        }
        return result;
    }
}
