package com.company.leetcode;

public class ConvertRomanNumberToInteger {
    public static void main(String[] args) {
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000

//        System.out.println("3 = " + convertToRoman("IIII"));
//        System.out.println("58 = " + convertToRoman("LVIII"));
        System.out.println("1994 = " + convertToRoman("MCMXCIV"));
    }

    private static int convertToRoman2(String s) {

        return 0;
    }

    private static int convertToRoman(String s) {
        int result = 0;
        int last = 0;
        for (int i = 0; i < s.length(); i++) {
            int local = 0;
            switch (s.charAt(i)) {
                case 'I':
                    local = 1;
                    last=1;
                    break;
                case 'V':
                    switch (last) {
                        case 1:
                            local = 5-2;
                            last = 5-2;
                            break;
                        default:
                            local = 5;
                            last = 5;
                    }
                    break;


                case 'X':
                    switch (last) {
                        case 1:
                            local = 10-2;
                            last = 10-2;
                            break;
                        case 5:
                            local = 10-10;
                            last = 10-10;
                            break;
                        default:
                            local = 10;
                            last = 10;
                            break;
                    }
                    break;

                case 'L':
                    switch (last) {
                        case 1:
                            local = 50-2;
                            last = 50-2;
                            break;
                        case 5:
                            local = 50-10;
                            last = 50-10;
                            break;
                        case 10:
                            local = 50-20;
                            last = 50-20;
                            break;
                        default:
                            local = 50;
                            last = 50;
                            break;
                    }
                    break;
                case 'C':
                    switch (last) {
                        case 1:
                            local = 100-2;
                            last = 100-2;
                            break;
                        case 5:
                            local = 100-10;
                            last = 100-10;
                            break;
                        case 10:
                            local = 100-20;
                            last = 100-20;
                            break;
                        case 50:
                            local = 100-100;
                            last = 100-100;
                            break;
                        default:
                            local = 100;
                            last = 100;
                            break;
                    }
                    break;
                case 'D':
                    switch (last) {
                        case 1:
                            local = 500-2;
                            last = 500-2;
                            break;
                        case 5:
                            local = 500-10;
                            last = 500-10;
                            break;
                        case 10:
                            local = 500-20;
                            last = 500-20;
                            break;
                        case 50:
                            local = 500-100;
                            last = 500-100;
                            break;
                        case 100:
                            local = 500-200;
                            last = 500-200;
                            break;
                        default:
                            local = 500;
                            last = 500;
                            break;
                    }
                    break;
                case 'M':
                    switch (last) {
                        case 1:
                            local = 1000-2;
                            last = 1000-2;
                            break;
                        case 5:
                            local = 1000-10;
                            last = 1000-10;
                            break;
                        case 10:
                            local = 1000-20;
                            last = 1000-20;
                            break;
                        case 50:
                            local = 1000-100;
                            last = 1000-1000;
                            break;
                        case 100:
                            local = 1000-200;
                            last = 1000-200;
                            break;
                        case 500:
                            local = 1000-1000;
                            last = 1000-1000;
                            break;
                        default:
                            local = 1000;
                            last = 1000;
                            break;
                    }
                    break;
            }
            result += local;
        }
        return result;
    }
}
//            I             1
//            V             5
//            X             10
//            L             50
//            C             100
//            D             500
//            M             1000