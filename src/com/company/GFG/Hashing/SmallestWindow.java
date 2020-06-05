package com.company.GFG.Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Smallest window in a string containing all the characters of another string
 * Given two strings. Find the smallest window in the first string consisting of all the characters of the second string.
 * <p>
 * Input:
 * First line of the input contains an integer T, denoting the number of test cases. Then T test case follows. Each test contains 2 lines having a string S (the first string) and next line contains a string P (the second string).
 * <p>
 * Output:
 * Output the smallest window of the string containing all the characters of the text. If such window doesn`t exist or this task can not be done then print -1.
 * <p>
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function smallestWindow() which takes two string S and P as inputs and returns the smallest window in string S having all the characters of the string P. In case there are multiple such windows of same length, return the one with the least starting index. Return "-1" in case there's no such window present.
 * <p>
 * Expected Time Complexity: O(|S|).
 * Expected Auxiliary Space: O(1).
 * <p>
 * Constraints:
 * 1 <= T <= 100
 * 1 <= |S|, |P| <= 1000
 * <p>
 * Example:
 * Input:
 * 2
 * timetopractice
 * toc
 * zoomlazapzo
 * oza
 * Output:
 * toprac
 * apzo
 * <p>
 * Explanation:
 * Testcase 1: toprac is the smallest subset in which toc can be found.
 * Testcase 2: To find oza in the zoomlazapzo the smallest subset is apzo.
 */
public class SmallestWindow {
    public static void main(String[] args) {

        String l3 = "aa";
        String l4 = "aa";
        System.out.println(smallestWindow(l3, l4));

        String l1 = "a";
        String l2 = "b";
        System.out.println(smallestWindow(l1, l2));

        String ra = "aaabbbxycabc";
        String rb = "abc";
        System.out.println(smallestWindow(ra, rb));

        String x = "zoomlazapzo";
        String y = "oza";
        System.out.println(smallestWindow(x, y));

        String c = "a";
        String d = "a";
        System.out.println(smallestWindow(c, d));

        String a = "ab";
        String b = "a";
        System.out.println(smallestWindow(a, b));

        String s = "timetopractice";
        String p = "toc";
        System.out.println(smallestWindow(s, p));


    }



    public static String smallestWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "-1";
        }
        String result = "";
        Map<Character, Integer> sourceMap = new HashMap<>();
        Map<Character, Integer> targetMap = new HashMap<>();

        int start = 0, end = -1, min = Integer.MAX_VALUE;
        int lastIndex = 0;
        int targetCount = 0;
        for (int i = 0; i < t.length(); i++) {
            if(targetMap.containsKey(t.charAt(i))){
                targetMap.put(t.charAt(i), targetMap.getOrDefault(t.charAt(i), 0) + 1);
            }else{
                targetCount++;
                targetMap.put(t.charAt(i), targetMap.getOrDefault(t.charAt(i), 0) + 1);
            }



        }

        for (int i = 0; i < s.length(); i++) {
            sourceMap.put(s.charAt(i), sourceMap.getOrDefault(s.charAt(i), 0) + 1);

            if (targetMap.containsKey(s.charAt(i))) {
                if (sourceMap.get(s.charAt(i)) == 1) {
                    targetCount--;
                }
            }

            while (targetCount == 0) {
                if(min>(i-lastIndex)){
                    start = lastIndex;
                    end = i + 1;
                    min=end-start;
                }

                if (targetMap.containsKey(s.charAt(lastIndex)) &&
                        sourceMap.get(s.charAt(lastIndex)) == 1) {
                    targetCount++;
                    sourceMap.remove(s.charAt(lastIndex));
                    lastIndex++;
                } else {
                    int v = sourceMap.get(s.charAt(lastIndex));
                    if (v > 1) {
                        sourceMap.put(s.charAt(lastIndex), v - 1);
                        lastIndex++;
                    } else {
                        if (v == 1) {
                            sourceMap.remove(s.charAt(lastIndex));
                            lastIndex++;
                        }
                    }
                }
            }
        }
        return end==-1 ? "" : s.substring(start, end);
    }

    public static String smallestWindow2(String S, String P) {

        if (P.length() > S.length()) {
            return "-1";
        }
        String result = "";
        Map<Character, Integer> sourceMap = new HashMap<>();
        Map<Character, Integer> targetMap = new HashMap<>();

        int start = 0, end = -1, min = Integer.MAX_VALUE;
        int lastIndex = 0;
        for (int i = 0; i < P.length(); i++) {
            if (sourceMap.containsKey(S.charAt(i))) {
                Integer v = sourceMap.get(S.charAt(i));
                v++;
                sourceMap.put(S.charAt(i), v);
            } else {
                sourceMap.put(S.charAt(i), 1);
            }

            if (targetMap.containsKey(P.charAt(i))) {
                Integer v = targetMap.get(P.charAt(i));
                v++;
                targetMap.put(P.charAt(i), v);
            } else {
                targetMap.put(P.charAt(i), 1);
            }

            if (check(sourceMap, targetMap) && min == Integer.MAX_VALUE) {
                start = 0;
                end = i;
                if (min > end - start) {
                    min = end - start;
                }
            }
        }

        lastIndex = 0;

        for (int i = P.length(); i < S.length(); i++) {
            if (sourceMap.containsKey(S.charAt(i))) {
                Integer v = sourceMap.get(S.charAt(i));
                v++;
                sourceMap.put(S.charAt(i), v);
            } else {
                sourceMap.put(S.charAt(i), 1);
            }

            while (true) {

                Integer v = sourceMap.get(S.charAt(lastIndex));
                if (v == 1) {
                    sourceMap.remove(S.charAt(lastIndex));
                } else {
                    v--;
                    sourceMap.put(S.charAt(lastIndex), v);
                }

                if (check(sourceMap, targetMap)) {
                    start = lastIndex + 1;
                    end = i + 1;
                    if (min > end - start) {
                        min = end - start;
                    }
                    lastIndex++;
                } else {
                    sourceMap.put(S.charAt(lastIndex), sourceMap.getOrDefault(S.charAt(lastIndex), 0) + 1);
                    break;
                }

            }
            if (check(sourceMap, targetMap) && min == Integer.MAX_VALUE) {
                start = 0;
                end = i;
                if (min > end - start) {
                    min = end - start;
                }
            }
        }
        return end == -1 ? "-1" : S.substring(start, end);
    }

    private static boolean check(Map<Character, Integer> sourceMap, Map<Character, Integer> targetMap) {
        for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
            if (!sourceMap.containsKey(entry.getKey())) {
                return false;
            }
        }
        return true;
    }

}
