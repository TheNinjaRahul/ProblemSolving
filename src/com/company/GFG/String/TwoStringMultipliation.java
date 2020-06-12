package com.company.GFG.String;

/**
 * Given two numbers as stings s1 and s2 your task is to multiply them. You are required to complete the function multiplyStrings which takes two strings s1 and s2 as its only argument and returns their product as strings.
 *
 * Input:
 * The first line of input contains an integer T denoting the no of test cases. Then T test cases follow . Each test case contains two strings s1 and s2 .
 *
 * Output:
 * For each test case in a new line the output will be a string denoting the product of the two strings s1 and s2.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= length of s1 and s2 <= 103
 *
 * Expected time complexity: O( n1 * n2 )
 * Expected auxiliary space: O( n1 + n2 ) ; where n1 and n2 are sizes of strings s1 and s2 respectively.
 *
 * Example(To be used only for expected output) :
 * Input:
 * 2
 * 33 2
 * 11 23
 * Output:
 * 66
 * 253
 */
public class TwoStringMultipliation {
    public static void main(String[] args) {
//        System.out.println(multiply("7","29"));
        System.out.println(multiply("4416","-333"));
//        System.out.println("0123".substring(0));
    }

    public static String multiply(String a, String b) {
        int m = a.length();
        int n = b.length();
        if (m == 0 || n == 0) return "0";

        int nagative = 0;
        if (a.charAt(0) == '-') {
            nagative++;
            a = a.substring(1);
        }
        if (b.charAt(0) == '-') {
            nagative++;
            b = b.substring(1);
        }
        boolean isNagative = false;
        if (nagative == 1) {
            isNagative = true;
        }

        int result[] = new int[m + n];
        int i = 0, j = n - 1;
        int carry = 0;

        for (; i < a.length(); i++) {
            int k = m + n - 1;
            int z = a.length() - i - 1;
            carry=0;
            while (z > 0) {
                result[k] = result[k] + 0;
                z--;
                k--;
            }
            for (j = b.length() - 1; j >= 0; j--) {
                int mul = (a.charAt(i) - '0') * (b.charAt(j) - '0');
                result[k] = result[k] + carry + mul;
                carry = result[k] / 10;
                result[k] = result[k] % 10;
                k--;
            }
            if (carry > 0) {
                while(carry!=0){
                    result[k] = result[k] + carry;
                    carry = result[k] / 10;
                    result[k] = result[k] % 10;
                    k--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean anyNumberAccured = false;
        for (i = 0; i < result.length; ++i) {
            if (result[i] != 0) {
                anyNumberAccured = true;
            }
            if (anyNumberAccured) {
                sb.append(result[i]);
            }
        }

        return sb.length() > 0 ?  isNagative ? "-"+sb.toString(): sb.toString() : "0";
    }
}
