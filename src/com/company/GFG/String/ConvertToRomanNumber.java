package com.company.GFG.String;

/***
 * Convert to Roman No
 * Given an integer n, your task is to complete the function convertToRoman which prints the corresponding roman number of n. Various symbols and their values are given below.
 *
 * I 1
 * V 5
 * X 10
 * L 50
 * C 100
 * D 500
 * M 1000
 *
 * Input: The first line of each test case contains the no of test cases T. Then T test cases follow. Each test case contains a single integer n.
 *
 * Output: Complete convertToRoman function and return the roman number representation of n.
 *
 * Constraints:
 *
 * 1<=T<=100
 * 1<=n<=3999
 *
 * Example:
 * Input
 * 2
 * 5
 * 3
 *
 * Output
 * V
 * III
 */

public class ConvertToRomanNumber {
    public static void main(String[] args) {
        ConvertToRomanNumber(3794);
    }

    static void  ConvertToRomanNumber(int n)
    {

        String result="";
        if (n >=1000) {
            for(int i=0;i<n/1000;i++){
                result+="M";
            }
            n=n%1000;
        }
        if(n >= 900){
            n=n%900;
            result+="CM";
        }
        if(n>=500){
            n=n%500;
            result+="D";
        }
        if(n>=400){
            n=n%400;
            result+="CD";
        }
        if(n>=100){
            for(int i=0;i<n/100;i++){
                result+="C";
            }
            n=n%100;
        }
        if(n>=90){
            n=n%90;
            result+="XC";
        }
        if(n>=50){
            n=n%50;
            result+="L";
        }
        if(n>=40){
            n=n%40;
            result+="XL";
        }
        if(n>=10){
            for(int i=0;i<n/10;i++){
                result+="X";
            }
            n=n%10;
        }
        if(n==9){
            result+="IX";
            n=n%9;
        }
        if(n>=5){
            n=n%5;
            result+="V";
        }
        if(n==4){
            n=0;
            result+="IV";
        }
        if(n>=1){
            for(int i=0;i<n;i++){
                result+="I";
            }
        }

        System.out.println(result);

    }

}
