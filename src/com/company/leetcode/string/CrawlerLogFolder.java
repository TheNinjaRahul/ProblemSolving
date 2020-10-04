package com.company.leetcode.string;

public class CrawlerLogFolder {
    public static void main(String[] args) {
        String[] s = {"d1/", "d2/", "../", "d21/", "./"};
        System.out.println(minOperations(s));
    }

    public static int minOperations(String[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i].equals("../")) {
                if (count == 0) {
                    continue;
                } else {
                    count--;
                }
            } else if (a[i].equals("./")) {
                continue;
            } else {
                count++;
            }
        }
        return count;
    }
}
