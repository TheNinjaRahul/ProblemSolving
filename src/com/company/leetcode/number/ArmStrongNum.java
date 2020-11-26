package com.company.leetcode.number;

public class ArmStrongNum {
    public static void main(String[] s) {
        ArmStrongNum myClass = new ArmStrongNum();
        System.out.println(myClass.isArmStrongNum(-153));
    }

    public boolean isArmStrongNum(int num) {
        int temp = num;
        if (num > 999) return false;
        int sum = 0;
        while (num > 0) {
            int n = num % 10;
            num = num / 10;
            sum += (n * n * n);
        }
        return temp == sum;
    }
}
