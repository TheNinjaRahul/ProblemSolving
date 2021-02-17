package com.company.leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

public class LetterCasePermutation {
    public static void main(String[] args) {
        LetterCasePermutation letterCasePermutation = new LetterCasePermutation();

        System.out.println(letterCasePermutation.letterCasePermutation("a1b2"));
    }

    public List<String> letterCasePermutation(String S) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new LinkedList<>();
        backTracking(S, sb, 0, list);
        return list;
    }

    public void backTracking(String s, StringBuilder sb, int i, List<String> list) {
        if (i == s.length()) {
            list.add(sb.toString());
//            System.out.println(list);
            return;
        }

        char c = s.charAt(i);
        if (Character.isLetter(c)) {
            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
                backTracking(s, sb, i + 1, list);
                sb.setLength(sb.length() - 1);
                sb.append(c);
                backTracking(s, sb, i + 1, list);
                sb.setLength(sb.length() - 1);
            } else {
                sb.append(Character.toUpperCase(c));
                backTracking(s, sb, i + 1, list);
                sb.setLength(sb.length() - 1);
                sb.append(c);
                backTracking(s, sb, i + 1, list);
                sb.setLength(sb.length() - 1);
            }
        } else {
            sb.append(c);
            backTracking(s, sb, i + 1, list);
            sb.setLength(sb.length() - 1);
        }
    }
}
