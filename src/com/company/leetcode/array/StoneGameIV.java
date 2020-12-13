package com.company.leetcode.array;

public class StoneGameIV {
    public static void main(String[] args) {
        System.out.println(stoneGameVII(new int[]{7, 90, 5, 1, 100, 10, 10, 2}));
        System.out.println(stoneGameVII(new int[]{5, 3, 1, 4, 2}));
    }

    public static int stoneGameVII(int[] stones) {
        int a = 0, b = 0, sum = 0, left = 0, right = stones.length - 1;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }

        boolean aturn = true;
        while (left < right) {
            if (aturn) {
                if (stones[left] < stones[right]) {
                    sum -= stones[left];
                    left++;
                } else {
                    sum -= stones[right];
                    right--;
                }
                a += sum;
            } else {
                int suml = b + sum - stones[left];
                int sumr = b + sum - stones[right];
                if (a - suml < a - sumr) {
                    sum -= stones[left];
                    left++;
                    b = suml;
                } else {
                    sum -= stones[right];
                    right--;
                    b = sumr;
                }
            }
            aturn = !aturn;
        }
        return a - b;

    }

}
