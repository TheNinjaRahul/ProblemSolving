package com.company.Graph;

import jdk.internal.org.objectweb.asm.ClassReader;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TarjansAlgoFindSCC {
    public static void main(String[] args) {
        List<int[]> list = new LinkedList<>();
        list.add(new int[]{1});
        list.add(new int[]{2, 3});
        list.add(new int[]{});
        list.add(new int[]{4});
        list.add(new int[]{0, 5, 6});
        list.add(new int[]{6, 2});
        list.add(new int[]{5});

        System.out.println(findSCCUsingTarjansAlgo(list));
    }

    private static List<List<Integer>> findSCCUsingTarjansAlgo(List<int[]> list) {
        int timer = 0;
        int discoveryTime[] = new int[list.size()];
        Arrays.fill(discoveryTime, -1);
        int lowTime[] = new int[list.size()];
        boolean inStack[] = new boolean[list.size()];
        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> output = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            if (discoveryTime[i] == -1) {
                dfs(0, output, timer, discoveryTime, lowTime, inStack, stack, list);
            }
        }
        return output;
    }

    private static void dfs(int startPoint, List<List<Integer>> output, int timer, int[] discoveryTime, int[] lowTime, boolean[] inStack, Stack<Integer> stack, List<int[]> list) {
        timer++;
        discoveryTime[startPoint] = timer;
        lowTime[startPoint] = timer;
        stack.push(startPoint);
        inStack[startPoint] = true;

        for (int adj : list.get(startPoint)) {
            if (discoveryTime[adj] == -1) {
                dfs(adj, output, timer, discoveryTime, lowTime, inStack, stack, list);
                lowTime[startPoint] = Math.min(lowTime[startPoint], lowTime[adj]);
            } else {
                if (inStack[adj]) {
                    lowTime[startPoint] = Math.min(lowTime[startPoint], lowTime[adj]);
                }
            }
        }

        if (discoveryTime[startPoint] == lowTime[startPoint]) {
            List<Integer> ssc = new LinkedList<>();
            while (stack.peek() != startPoint) {
                inStack[stack.peek()] = false;
                ssc.add(stack.pop());
            }
            ssc.add(stack.pop());
            output.add(ssc);
            inStack[startPoint] = false;
        }
    }
}
