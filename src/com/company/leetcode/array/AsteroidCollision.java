package com.company.leetcode.array;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{10, -11})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{-2, -1, 1, 2})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5, 10, -5})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{8, -8})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{10, 2, -5})));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        if (asteroids.length == 0) return asteroids;
        stack.push(asteroids[0]);

        for (int i = 1; i < asteroids.length; i++) {
            int current = asteroids[i];
            while (true) {
                if (stack.isEmpty() || (stack.peek() < 0 && current < 0) || (stack.peek() > 0 && current > 0)) {
                    stack.push(current);
                    break;
                }

                if (stack.peek() > 0 && current < 0) {
                    current = Math.abs(current);
                    if (stack.peek() == current) {
                        stack.pop();
                        break;
                    } else if (stack.peek() > current) {
                        break;
                    } else if (stack.peek() < current) {
                        stack.pop();
                        current = -current;
                    }
                } else {
                    stack.push(current);
                    break;
                }
            }
        }
        int r[] = new int[stack.size()];
        int j = stack.size() - 1;
        while (!stack.isEmpty()) {
            r[j--] = stack.pop();
        }
        return r;
    }

    private void process(int i, int[] asteroids) {


    }
}
