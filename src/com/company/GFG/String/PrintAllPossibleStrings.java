package com.company.GFG.String;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/***
 * Print all possible strings
 * Given a string str your task is to complete the function printSpaceString which takes only one argument the string str and  prints all possible strings that can be made by placing spaces (zero or one) in between them.
 *
 * For eg .  for the string abc all valid strings will be
 *                 abc
 *                 ab c
 *                 a bc
 *                 a b c
 *
 *
 * Input:
 * The First line of input takes an integer T denoting the number of test cases . Then T test cases follow . Each line of test case contains a string str .
 *
 * Output:
 * For each test case output the strings possible in a single line  separated by a "$"
 *
 * Constraints:
 * 1<=T<=100
 * 1<=length of string str <=10
 *
 * Example:
 * Input
 * 1
 * abc
 *
 * Output
 * abc$ab c$a bc$a b c$
 *
 *
 */
public class PrintAllPossibleStrings {
    public static void main(String[] args) {
        printSpace("abcd");
    }

    static void printSpace(String str)
    {
        System.out.print(str+"$");
        for(int i=1;i<str.length();i++){
            List<String> result=getPossibleSpace(str.substring(i));
            for(String s:result){
                System.out.print(str.substring(0,i)+" "+s+"$");
            }

        }
    }

    private static List<String> getPossibleSpace(String str) {
        List<String> list=new LinkedList<>();
        if(str.length()==1){
            list.add(str);
            return list;
        }
        list.add(str);
        for(int i=1;i<str.length();i++){
            List<String> result=getPossibleSpace(str.substring(i));
            for(String s:result){
                list.add(str.substring(0,i)+" "+s);
            }
        }

        return list;
    }
}
