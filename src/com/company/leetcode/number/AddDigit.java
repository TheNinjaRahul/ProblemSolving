package com.company.leetcode.number;

public class AddDigit {
    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }

    public static int addDigits(int num) {
        while (true) {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num = num / 10;
            }
            if (sum / 10 == 0) {
                return sum;
            }
            num = sum;
        }
    }
}
