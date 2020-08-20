package com.company.leetcode.number;

public class PowerOfFour {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(0));

        System.out.println(isPowerOfFour(1));
        System.out.println(isPowerOfFour(2));
    }

    private static boolean isPowerOfFour(int n) {
        if (n == 0) return true;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) != 0) {
                count++;
                if (i % 2 != 0) return false;
            }
        }
        return count == 1;
    }

    public static boolean isPowerOfFour2(int num) {
        while (num != 1) {
            if (num == 0) return false;
            if (num % 4 == 0) {
                num /= 4;

            } else {
                return false;
            }
        }
        return true;
    }
}
