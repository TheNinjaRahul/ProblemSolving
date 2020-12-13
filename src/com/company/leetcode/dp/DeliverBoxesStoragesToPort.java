package com.company.leetcode.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DeliverBoxesStoragesToPort {
    public static void main(String[] args) {
        DeliverBoxesStoragesToPort d = new DeliverBoxesStoragesToPort();
        System.out.println("4=" + d.boxDelivering(new int[][]{{1, 1}, {2, 1}, {1, 1}},
                2, 3, 3));
    }

    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        Map<Integer, Integer> map = new HashMap<>();
        return rec(boxes, portsCount, maxBoxes, maxWeight, map, 0);
    }

    public int rec(int[][] boxes, int portsCount, int maxBoxes, int maxWeight, Map<Integer, Integer> map, int i) {
        if (i >= boxes.length) return Integer.MAX_VALUE;
        if (map.containsKey(i)) return map.get(i);
        int ans = Integer.MAX_VALUE;
        int current = Integer.MAX_VALUE;
        int j = i;
        Set<Integer> ports = new HashSet<>();
        for (j = i; j < boxes.length && j - i < maxBoxes + i; j++) {
            int w = 0;
            if (w + boxes[j][1] < maxWeight) {
                w += boxes[j][1];
                int next = rec(boxes, portsCount, maxBoxes, maxWeight, map, j + 1);
                if (next == Integer.MAX_VALUE) {
                    next = ports.size();
                }
                current = Math.min(current, next + 1);
            } else {
                break;
            }
        }
        ans = Math.min(ans, current);
        int nextSlot = rec(boxes, portsCount, maxBoxes, maxWeight, map, j + maxBoxes);
        if (nextSlot != Integer.MAX_VALUE) {
            ans += nextSlot;
        }
        map.put(i, ans);
        return ans;

    }
}
