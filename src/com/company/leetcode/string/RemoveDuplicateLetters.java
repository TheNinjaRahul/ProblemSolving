package com.company.leetcode.string;

import java.util.*;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        RemoveDuplicateLetters rdl = new RemoveDuplicateLetters();
//        System.out.println(rdl.removeDuplicateLetters("cbacdcbc"));
        System.out.println(rdl.removeDuplicateLetters("abacb"));
//        System.out.println(rdl.removeDuplicateLetters("xyzxxxxxxaaaaabbbbbbcccxxyzxxxxxxaaaaabbbbbbcc"));

    }

    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        List<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (list.isEmpty()) {
                list.add(s.charAt(i));
                set.add(s.charAt(i));
                continue;
            }

            if (list.get(list.size() - 1) >= s.charAt(i)) {
                while (!set.contains(s.charAt(i)) && !list.isEmpty() && lastIndex[list.get(list.size() - 1) - 'a'] > i && list.get(list.size() - 1) >= s.charAt(i)) {
                    set.remove(list.get(list.size() - 1));
                    list.remove(list.size() - 1);
                }
            }
            if (!set.contains(s.charAt(i))) {
                list.add(s.charAt(i));
                set.add(s.charAt(i));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();

    }

}
