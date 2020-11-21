package com.company.leetcode.amazonOnline;

import sun.font.CreatedFontTracker;

import java.util.*;

public class ReorderLogFiles {
    public static void main(String[] args) {
        String[] s = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        ReorderLogFiles r = new ReorderLogFiles();
        System.out.println(Arrays.toString(r.reorderLogFiles(s)));

    }

    public String[] reorderLogFiles(String[] logs) {

        Comparator<String> c = new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {

                int a = s1.indexOf(" ");
                int b = s2.indexOf(" ");

                String id1 = s1.substring(a);
                String main1 = s1.substring(a + 1);

                String id2 = s2.substring(a);
                String main2 = s2.substring(a + 1);

                if (Character.isLetter(main1.charAt(0)) && Character.isLetter(main2.charAt(0))) {
                    return main1.compareTo(main2) == 0 ? s1.compareTo(s2) : main1.compareTo(main2);
                } else if (Character.isLetter(main1.charAt(main1.length() - 1))) {
                    return -1;
                } else if (Character.isLetter(main2.charAt(main2.length() - 1))) {
                    return 1;
                }
                return 0;
            }
        };
        Arrays.sort(logs, c);
        return logs;
    }
}
