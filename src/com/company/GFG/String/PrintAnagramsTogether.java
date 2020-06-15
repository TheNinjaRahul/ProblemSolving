package com.company.GFG.String;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.*;

/***
 * Print Anagrams Together
 * Given an array of strings, return all groups of strings that are anagrams. The groups must be created in order of their appearance in the original array. Look at the sample case for clarification.
 *
 * Input:
 * First line of input contains number of testcases T. For each testcase, there will be two lines. First line contains N, denoting the number of words in array. Second line consists of N words in the array.
 *
 * Output:
 * Print groups of anagrams together.
 *
 * Your Task:
 * The task is to complete the function Anagrams() that takes a list of strings as input and returns a list of groups such that each group consists of all the strings that are anagrams.
 *
 * Constraints:
 * 1<=T<=100
 * 1<=N<=100
 *
 * Example:
 * Sample Input:
 * 1
 * 5
 * act god cat dog tac
 *
 * Sample Output:
 * god dog
 * act cat tac
 *
 * Explanation:
 * There are 2 groups of anagrams -
 * god, dog make group 1.
 * act, cat, tac make group 2.
 */
public class PrintAnagramsTogether {
    public static void main(String[] args) {
        String data[]={"act","god","cat","dog","tac"};
        System.out.println(Anagrams(data));
    }

    public static List<List<String>> Anagrams(String[] string_list) {

        List<List<String>> masterList=new ArrayList<>();
        Map<String,List<String>> map=new LinkedHashMap<>();
        for (String s : string_list) {
            char[] si=s.toCharArray();
            Arrays.sort(si);
            String key=String.valueOf(si);
            if(map.containsKey(key)){
                map.get(key).add(s);
            }else{
                List<String> list=new ArrayList<>();
                list.add(s);
                map.put(key,list);
            }
        }
        for(Map.Entry<String,List<String>> e:map.entrySet()){
            masterList.add(e.getValue());
        }

        return masterList;
    }
}
