package com.company.leetcode.string;

import java.util.LinkedList;
import java.util.List;

public class CountSortedVowels {
    public static void main(String[] args) {
        CountSortedVowels c = new CountSortedVowels();
        System.out.println(c.countVowelStrings(33));
    }

    public int countVowelStrings(int n) {
        if (n == 1) return 5;
        char[] c = {'a', 'e', 'i', 'o', 'u'};
        StringBuilder sb = new StringBuilder();
        List<String> list = new LinkedList<>();
        rec(c, sb, list, n);
        System.out.println(list);
        return list.size();
    }

    public void rec(char[] c, StringBuilder sb, List<String> list, int n) {
        if (sb.length() > n) {
            return;
        }

        if (sb.length() == n) {
            list.add(sb.toString());
            return;
        }

        for (int i = 0; i < c.length; i++) {
            if (sb.length() == 0) {
                sb.append(c[i]);
                rec(c, sb, list, n);
                sb.setLength(sb.length() - 1);
            } else if (sb.charAt(sb.length() - 1) <= c[i]) {
                sb.append(c[i]);
                rec(c, sb, list, n);
                sb.setLength(sb.length() - 1);
            }
        }
    }
}
