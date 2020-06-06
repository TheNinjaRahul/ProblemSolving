package com.company.GFG.String;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

/***
 * Anagram of String
 * Given two strings S1 and S2 in lowercase, the task is to make them anagram. The only allowed operation is to remove a character from any string. Find the minimum number of characters to be deleted to make both the strings anagram. Two strings are called anagram of each other if one of them can be converted into another by rearranging its letters.
 *
 * Input Format:
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of 2 strings to make the anagrams.
 *
 * Output Format:
 * For each testcase, in a new line, output the minimum number of characters to be deleted to make both the strings anagram.
 *
 * Your Task:
 * Since this is a function problem, you don't need to take any input. Just complete the provided function.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= |S1|, |S2| <= 105
 *
 * Example:
 * Input:
 * 2
 * bcadeh
 * hea
 * cddgk
 * gcd
 * Output:
 * 3
 * 2
 */
public class AnagramOfString {
    public static void main(String[] args) {
        String s="bcadeh";
        String s2="hea";

        String s3="cddgk";
        String s4="gcd";
        System.out.println(remAnagrams(s,s2));
        System.out.println(remAnagrams(s3,s4));

        String s5="basgadhbfgvhads";
        String s6="sjdhgvbjdsbhvbvd";
        System.out.println(remAnagrams(s5,s6));
    }


    public static int remAnagrams(String s,String s1)
    {
        if(s.length()<s1.length()){
            return remAnagrams(s1,s);
        }

        int str1[]=new int[26];
        int str2[]=new int[26];

        for(int i=0;i<s.length();i++){
            str1[s.charAt(i)%26]++;
        }
        for(int i=0;i<s1.length();i++){
            str2[s1.charAt(i)%26]++;
        }

        int count=0;
        for(int i=0;i<26;i++){
            count+=Math.abs(str1[i]-str2[i]);
        }
        return count;
    }
}
