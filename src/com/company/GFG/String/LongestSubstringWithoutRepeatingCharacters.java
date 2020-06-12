package com.company.GFG.String;

/**
 * Longest Substring Without Repeating Characters
 * Given a string S, find the length of its longest substring that does not have any repeating characters.
 * <p>
 * Input:
 * The first line of input contains the number of test cases T. Followed by T lines, each containing a string S.
 * <p>
 * Output:
 * Print the length of the longest substring that does not have any repeating characters.
 * <p>
 * Your Task:
 * Complete SubsequenceLength function that takes string s as input and returns the length of the longest substring that does not have any repeating characters.
 * <p>
 * Constraints:
 * 1<=T<=100
 * 0<= S.length() <= 10^5
 * <p>
 * Example:
 * Input:
 * 2
 * geeksforgeeks
 * abbcdb
 * Output:
 * 7
 * 3
 * Explanation:
 * TestCase 1: The longest substring without repeated characters is "ksforge".
 * TestCase 2: The longest substring is "bcd". Here "abcd" is not a substring of the given string.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(subsequenceLength("abac"));
        System.out.println(subsequenceLength("aabbcadba"));
        System.out.println(subsequenceLength("geeksforgeeks"));
        System.out.println(subsequenceLength("abbcdb"));

    }

    public static int subsequenceLength(String s) {

        if(s.length()==0){
            return 0;
        }

        int max = 0;
        int start = 0, end = 0;
        int alp[] = new int[26];
        int i = 0, j = 0;
        if (alp[s.charAt(i) - 'a'] == 0) {
            alp[s.charAt(i) - 'a']++;
        }
        while (j < s.length()) {
            if (i == j) {
                j++;
                continue;
            }

            if (alp[s.charAt(j) - 'a'] > 1) {
                alp[s.charAt(i) - 'a']--;
                i++;j++;
            } else {
                alp[s.charAt(j) - 'a']++;
                if (alp[s.charAt(j) - 'a'] == 1) {
                    start = i;
                    end = j;
                    if (max < (j - i)) {
                        max = j - i;
                    }
                    j++;
                }
            }
        }
        return max+1;
    }

}
