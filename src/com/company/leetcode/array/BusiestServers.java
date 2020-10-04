package com.company.leetcode.array;

import sun.awt.windows.WBufferStrategy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BusiestServers {
    public static void main(String[] args) {
        BusiestServers bs = new BusiestServers();

        int[] a1 = {1, 2, 3, 4, 5};
        int load[] = {5, 2, 3, 3, 3};
        System.out.println(bs.busiestServers(3, a1, load));
    }

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        int server[] = new int[k];
        int lastTime[] = new int[k];
        List<Integer> list = new LinkedList<>();

        int max = 0;
        for (int i = 0; i < load.length; i++) {
            int j = 0, jk = i % k;
            while (j < k) {
                j++;
                if (arrival[i] - lastTime[jk] >= 0) {
                    lastTime[jk] = load[i];
                    server[jk]++;
                    max = Math.max(server[jk], max);
                    break;
                }
                jk++;
                jk %= k;
            }
        }

        for (int i = 0; i < server.length; i++) {
            if (server[i] == max) {
                list.add(i);
            }
        }

        return list;
    }
}
