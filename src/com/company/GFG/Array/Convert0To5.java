package com.company.GFG.Array;

public class Convert0To5 {
    public static void main(String[] args) {
        System.out.println(convertfive(10001));
    }


    static int convertfive(int num) {
        int result = 0;
        int count = 0;
        while (num > 0) {
            int mod = num % 10;
            num = num / 10;

            if (mod == 0) {
                result += ((Math.pow(10, count) * 5));
            } else {
                result += (Math.pow(10, count) * mod);
            }
            count++;
        }

        return result;
    }
}
