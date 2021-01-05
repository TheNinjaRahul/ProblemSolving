package com.company.leetcode.string;

public class StringHalvesALike {
    public static void main(String[] args) {
        StringHalvesALike a = new StringHalvesALike();
        System.out.println(a.halvesAreAlike("book"));
    }

    public boolean halvesAreAlike(String s) {
        int n = s.length();
        if (n % 2 != 0) return false;
        return (getVowelsCount(s, 0, (n / 2) - 1) == getVowelsCount(s, ((n / 2) - 1) + 1, n - 1));
    }

    public int getVowelsCount(String s, int p, int j) {
        int count = 0;
        for (int i = p; i <= j; i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                    c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                count++;
            }
        }
        return count;
    }
}
