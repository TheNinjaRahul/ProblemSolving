package com.company.leetcode.string;

public class GoatLatin {
    public static void main(String[] args) {
        System.out.println(toGoatLatin("AA"));
    }

    public static String toGoatLatin(String S) {
        String str[] = S.split(" ");


        StringBuilder sb = new StringBuilder("ma");
        for (int i = 0; i < str.length; i++) {
            sb.append('a');
            char c = str[i].charAt(0);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                str[i] += sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder(str[i]);
                sb2.deleteCharAt(0);
                sb2.append(c);
                sb2.append(sb.toString());
                str[i] = sb2.toString();
            }
        }

        sb = new StringBuilder();

        for (int i = 0; i < str.length; i++) {
            if (i == str.length - 1) {
                sb.append(str[i]);
            } else {
                sb.append(str[i] + " ");
            }
        }
        return sb.toString();

    }
}
