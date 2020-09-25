package com.company.leetcode.Math;

import java.util.HashMap;
import java.util.Map;

public class RobotBoundedInCircle {
    public static void main(String[] args) {
        System.out.println(isRobotBounded("GLRLLGLL"));
        System.out.println(isRobotBounded("GGLLGG"));
        System.out.println(isRobotBounded("GG"));
        System.out.println(isRobotBounded("GL"));
    }


    public static boolean isRobotBounded(String instructions) {
        Map<Character, char[]> map = new HashMap<>();
        map.put('N', new char[]{'W', 'E'});
        map.put('S', new char[]{'E', 'W'});
        map.put('W', new char[]{'S', 'N'});
        map.put('E', new char[]{'N', 'S'});

        Map<Character, int[]> direction = new HashMap<>();
        direction.put('N', new int[]{0, 1});
        direction.put('S', new int[]{0, -1});
        direction.put('W', new int[]{-1, 0});
        direction.put('E', new int[]{1, 0});


        int[] currentPoint = {0, 0};
        char currentDirection = 'N';

        for (int i = 0; i < instructions.length(); i++) {
            char ins = instructions.charAt(i);
            switch (ins) {
                case 'G':
                    currentPoint[0] += direction.get(currentDirection)[0];
                    currentPoint[1] += direction.get(currentDirection)[1];
                    break;
                case 'L':
                    currentDirection = map.get(currentDirection)[0];
                    break;
                case 'R':
                    currentDirection = map.get(currentDirection)[1];
                    break;
            }
        }

        if (currentPoint[0] == 0 && currentPoint[1] == 0 && currentDirection == 'N') return true;

        return currentDirection != 'N';
    }
}
