package com.company.leetcode.string;

public class ChangeMinimumCharactersToSatisfyOneOfThreeConditions {
    public static void main(String[] args) {
        System.out.println(minCharacters("dabadd", "cda"));
    }


    public static int minCharacters(String a, String b) {
        char max = 'a';
        for (char c : a.toCharArray()) {
            max = (char) Math.max((int) c, (int) max);
        }
        int ansa = 0;
        System.out.println(max);
        for (char c : b.toCharArray()) {
            if (c <= max) ansa++;
        }

        max = 'a';
        for (char c : b.toCharArray()) {
            max = (char) Math.max((int) c, (int) max);
        }
        System.out.println(max);
        int ansb = 0;
        for (char c : a.toCharArray()) {
            if (c <= max) ansb++;
        }
        return Math.min(ansa, ansb);
    }

}
