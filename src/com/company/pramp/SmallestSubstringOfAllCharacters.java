package com.company.pramp;

import java.util.HashSet;
import java.util.Set;

public class SmallestSubstringOfAllCharacters {
    public static void main(String[] args) {
        char arr[] = {'x', 'y', 'z'};
        String str = "xyyzyzyx";
        System.out.println(getShortestUniqueSubstring(arr,str));
    }


    static String getShortestUniqueSubstring(char[] arr, String str) {
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for (Character c : arr) set1.add(c);
        int i = 0, j = 0, min = Integer.MAX_VALUE;
        String result = "";

        while (j < str.length()) {
            while (j < str.length()) {
                while (set1.size() != 0) {
                    if (set1.contains(str.charAt(j))) {
                        set2.add(str.charAt(j));
                        set1.remove(str.charAt(j));
                    }
                    j++;
                }
                if (j - i + 1 < min) {
                    result = str.substring(i, j);
                    min = result.length();
                }
                while (i < j && set1.size() == 0) {
                    if (set2.contains(str.charAt(i))) {
                        set1.add(str.charAt(i));
                        set2.remove(str.charAt(i));
                    }
                    i++;
                }
            }
        }

        return result;

    }

}
