package com.company.leetcode.string;

public class DetectCapital {
    public static void main(String[] args) {
        System.out.println(detectCapitalUse("g"));
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("FlaG"));
        System.out.println(detectCapitalUse("Flag"));
    }

    public static boolean detectCapitalUse(String word) {
        if (word.length() == 0 || word.length() == 1) return true;

        int i = 0;
        if (word.charAt(i) - 'A' >= 0 && word.charAt(i) - 'A' < 26) {
            i++;
            if (word.charAt(i) - 'A' >= 0 && word.charAt(i) - 'A' < 26) {
                i++;
                for (int k = i; k < word.length(); k++) {
                    if (!(word.charAt(k) - 'A' >= 0 && word.charAt(k) - 'A' < 26)) {
                        return false;
                    }
                }
                return true;
            }
        }
        for (int k = i; k < word.length(); k++) {
            if (!(word.charAt(k) - 'a' >= 0 && word.charAt(k) - 'a' < 26)) {
                return false;
            }
        }
        return true;
    }
}
