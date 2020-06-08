package com.company.GFG.String;

import java.util.HashMap;
import java.util.Map;

/***
 * String Permutations
 * Given a string S. The task is to print all permutations of a given string.
 *
 * Input Format:
 * The first line of input contains an integer T, denoting the number of test cases. Each test case contains a single string S in capital letter.
 *
 * Output Format:
 * For each test case, print all permutations of a given string S with single space and all permutations should be in lexicographically increasing order.
 *
 * Your Task:
 * This is a function problem. You only need to complete the function permutation that takes S as parameter and prints the permutations in lexicographically increasing order. The newline is automatically added by driver code.
 *
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ size of string ≤ 5
 *
 * Example:
 * Input:
 * 2
 * ABC
 * ABSG
 *
 * Output:
 * ABC ACB BAC BCA CAB CBA
 * ABGS ABSG AGBS AGSB ASBG ASGB BAGS BASG BGAS BGSA BSAG BSGA GABS GASB GBAS GBSA GSAB GSBA SABG SAGB SBAG SBGA SGAB SGBA
 *
 * Explanation:
 * Testcase 1: Given string ABC has permutations in 6 forms as ABC, ACB, BAC, BCA, CAB and CBA .
 */
public class PermutationOfString {

    public static void main(String[] args) {
        permutation("abc");
    }

    public static void permutation(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        char c[] = new char[map.size()];
        int f[] = new int[map.size()];
        int i = 0;
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            c[i] = e.getKey();
            f[i++] = e.getValue();
        }

        permutation(c, f, new char[s.length()], 0);
//        for (int j = 0; j < c.length; j++) {
//            String result = "";
//            result += c[j];
//            f[j] = f[j] - 1;
//            permutation(c, f, result, s);
//            f[j] = f[j] + 1;
//        }
    }

    private static void permutation(char[] c, int[] f, char[] result, int level) {
        if (result.length == level) {
            System.out.print(String.valueOf(result) + " ");
            return;
        }
        for (int j = 0; j < c.length; j++) {
            if (f[j] != 0) {
                result[level] = c[j];
                f[j] = f[j] - 1;
                permutation(c, f, result, level + 1);
                f[j] = f[j] + 1;
            }
        }
    }
}
