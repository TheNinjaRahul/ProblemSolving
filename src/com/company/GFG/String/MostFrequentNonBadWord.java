package com.company.GFG.String;

import java.util.*;

/**
 * Most Frequent Non Bad word
 * Given a paragraph and a list of bad words, return the most frequent word that is not in the list of bad words. It is guaranteed that the answer exists and is unique. Ignore the punctuation in the paragraph.
 * <p>
 * Keep in mind the following points:
 * 1. Bad words are given in lowercase and are free of punctuation.
 * 2. Words in the paragraph are not case sensitive.
 * 3. The answer is in lowercase.
 * <p>
 * Input:
 * The first line of input contains the number of test cases T. For each test case, there will be three lines. The first contains the paragraph. Second lines take N as input which denotes the number of bad words. The third line contains N space-separated bad words.
 * <p>
 * Output:
 * The most frequent non-bad word.
 * <p>
 * User Task:
 * The task is to complete the function MostFrequent that takes the paragraph and list of bad words as arguments and returns the most common non-bad word. Do not print the output just return the desired output.
 * <p>
 * Constraints:
 * 1 <= paragraph.length <= 1000.
 * 0 <= bad.length <= 100.
 * 1 <= bad[i].length <= 10.
 * <p>
 * Example:
 * Input:
 * 1
 * Geeks like to code. The code on GEEKS for GEEKS is curated by in-office geeks.
 * 1
 * geeks
 * Output:
 * code
 * Explanation:
 * Since "geeks" is a bad word. The result discards all its variations ie- "Geeks", "GEEKS", "geeks". The most frequent word that is not in the bad word list is, therefore "code".
 */
public class MostFrequentNonBadWord {
    public static void main(String[] args) {

        String p = "Geeks like to code. The code on GEEKS for GEEKS is curated by in-office geeks.";
        List<String> list = new ArrayList<>();
        list.add("geeks");
//        System.out.println(list.get(0).substring(0,list.get(0).length()-1));
        System.out.println(mostFrequent(p, list));
    }


    static String mostFrequent(String paragraph, List<String> taboo) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>(taboo);
        String[] words = paragraph.split(" ");

        String result=null;
        int maxfreq=0;
        for (String s : words) {
            s = s.toLowerCase();
            char c = s.charAt(s.length() - 1);
            if (!Character.isLetter(c)) {
                s = s.substring(0, s.length() - 1);
            }

            if (!taboo.contains(s)) {
                map.put(s, map.getOrDefault(s, 0) + 1);
                if(map.get(s)>maxfreq){
                    maxfreq=map.get(s);
                    result=s;
                }
            }
        }

        return result;
    }

}
