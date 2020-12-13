package com.company.leetcode.AmazonPractice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PrintPermutationOfGivenNumber {
    public static void main(String[] args) {
        PrintPermutationOfGivenNumber p = new PrintPermutationOfGivenNumber();
        System.out.println(p.getPermutation("123"));
        System.out.println(p.getKthPermutation(4, 14));
    }

    public List<String> getPermutation(String s) {
        List<String> result = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        char[] chars = new char[map.size()];
        int[] freq = new int[map.size()];
        int i = 0;

        for (char c : map.keySet()) {
            chars[i] = c;
            freq[i] = map.get(c);
            i++;
        }
        StringBuffer sb = new StringBuffer();
        getPermutationOf(chars, freq, result, sb, s);
        return result;
    }

    private void getPermutationOf(char[] chars, int[] freq, List<String> result,
                                  StringBuffer sb, String s) {
        if (sb.length() == s.length()) {
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (freq[i] > 0) {
                sb.append(chars[i]);
                freq[i]--;
                getPermutationOf(chars, freq, result, sb, s);
                freq[i]++;
                sb.setLength(sb.length() - 1);
            }
        }
    }

    public String getKthPermutation(int no, int k) {
        List<Integer> list = new LinkedList<>();

        for (int i = 1; i <= no; i++) {
            list.add(i);
        }

        StringBuffer sb = new StringBuffer();
        while (list.size() != 1) {
            int n = list.size();
            int nMinusOneFact = fact(n - 1);
            int index = k / nMinusOneFact;

            if (k % nMinusOneFact == 0) {
                index--;
            }
            sb.append(list.remove(index));
            k -= index * nMinusOneFact;
        }
        sb.append(list.get(0));
        return sb.toString();
    }

    public int fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }
}
