package com.company.GFG.String;

import java.math.BigInteger;

/***
 * Implement Atoi
 * Your task  is to implement the function atoi. The function takes a string(str) as argument and converts it to an integer and returns it.
 *
 * Input:
 * The first line of input contains an integer T denoting the no of test cases . Then T test cases follow. Each test case contains a string str .
 *
 * Output:
 * For each test case in a new line output will be an integer denoting the converted integer, if the input string is not a numerical string then output will be -1.
 *
 * Constraints:
 * 1<=T<=100
 * 1<=length of (s,x)<=10
 *
 * Example(To be used only for expected output) :
 * Input:
 * 2
 * 123
 * 21a
 *
 * Output:
 * 123
 * -1
 */
public class AtoI {
    public static void main(String[] args) {
        System.out.println(atoi("-12"));
    }

    public static int atoi(String str)
    {
        int result=0;
        boolean isNegative=false;
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(c=='-'){
                isNegative=true;
                continue;
            }
            if(c>='0' && c<='9')
            {
                int num=c-'0';
                result = (int) ((result * 10) + num);
            }
            else{
                return -1;
            }
        }
        return isNegative ? -result : result;
    }

}
