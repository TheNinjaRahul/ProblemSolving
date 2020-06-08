package com.company.GFG.String;

/***
 * Run Length Encoding
 * Given a string, Your task is to  complete the function encode that returns the run length encoded string for the given string.
 * eg if the input string is “wwwwaaadexxxxxx”, then the function should return “w4a3d1e1x6″.
 * You are required to complete the function encode that takes only one argument the string which is to be encoded and returns the encoded string.
 *
 *
 * Input:
 * The first line contains T denoting no of test cases . Then T test cases follow . Each test case contains a string str which is to be encoded .
 *
 * Output:
 * For each test case output in a single line the so encoded string .
 *
 * Constraints:
 * 1<=T<=100
 * 1<=length of str<=100
 *
 * Example:
 * Input(To be used only for expected output)
 * 2
 * aaaabbbccc
 * abbbcdddd
 *
 * Output
 * a4b3c3
 * a1b3c1d4
 */
public class RunLengthEncoding {
    public static void main(String[] args) {

    }

    static String encode(String str) {
       int count=1;
       String result="";
       for(int i=1;i<str.length();i++){
           if(str.charAt(i-1)!=str.charAt(i)){
               result=result+str.charAt(i-1)+count;
               count=1;
               continue;
           }
           count++;
       }
       result=result+str.charAt(str.length()-1)+count;
       return result;
    }
}
