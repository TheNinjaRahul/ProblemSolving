package com.company.leetcode;

public class RegularExpressionMatching {
    public static void main(String[] args) {
//        "aab"
//        "c*a*b"
//        String s = "a";
//        String p = "aa";
//        System.out.println( "Expected : false " + isMatchDp(s, p));
        String s2 = "ab";
        String p2 = ".*";
        System.out.println("Expected : true " + isMatchDp(s2, p2));
//        String s3="aab";
//        String p3="c*a*b";
//        System.out.println("Expected : true " +isMatchDp(s3, p3));
//        String s4="mississippi";
//        String p4="mis*is*p*.";
//        System.out.println("Expected : false " + isMatchDp(s4, p4));
//        String s5="xaabyc";
//        String p5="xa*b.c";
//        System.out.println("Expected : true " + isMatchDp(s5, p5));

    }

    private static boolean isMatchDp(String string, String pattern) {
        boolean[][] table = new boolean[string.length() + 1][pattern.length() + 1];

        table[0][0] = true;
        printTable(table, string, pattern);


        //Deals with patterns like a* or a*b* or a*b*c*
        for (int i = 1; i < table[0].length; i++) {
            if (pattern.charAt(i-1) == '*') {
                table[0][i] = table[0][i - 2];
            }
        }
        for (int i = 1; i < table.length; i++) {
            char s = string.charAt(i - 1);
            for (int j = 1; j < table[0].length; j++) {
                char p = pattern.charAt(j - 1);
                if (s == p || p == '.') {
                    table[i][j] = table[i - 1][j - 1];
                } else if (p == '*') {
                    table[i][j] = table[i][j - 2];
                    if (s == pattern.charAt(j - 2) || pattern.charAt(j-2)=='.') {
                        table[i][j] = table[i - 1][j] || table[i][j];
                    }
                } else {
                    table[i][j] = false;
                }

            }
        }

        printTable(table, string, pattern);

        return table[string.length()][pattern.length()];
    }

    private static void printTable(boolean[][] table, String s, String p) {
        System.out.println("   ");
        System.out.print("   ");
        for (int i = 0; i < table[0].length; i++) {
            if (i != 0) {
                System.out.print("  " + p.charAt(i - 1));
            } else System.out.print("  ");
        }
        System.out.println();
        for (int i = 0; i < table.length; i++) {
            if (i != 0) {
                System.out.print(" " + s.charAt(i - 1));
            } else System.out.print("  ");

//            System.out.print(" "+s.charAt(i-1));
            for (int j = 0; j < table[0].length; j++) {
                char ch = table[i][j] ? 'T' : 'F';
                System.out.print(" " + " " + ch);
            }
            System.out.println();
        }
    }

    private static boolean isMatch(String s, String p) {

        if (p.length() == 0) return s.length() == 0;

        boolean firstMatch = (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));

        if (p.length() >= 2 && (p.charAt(1) == '*')) {
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    private static boolean isMatch3(String string, String pattern) {
        if (string.length() == 0 && pattern.length() == 0) {
            return true;
        }
        if (pattern.length() == 2) {
            if (pattern.charAt(0) == '.') {
                return isMatch("", pattern.substring(1, pattern.length()));
            }
            if (pattern.charAt(1) == '*') {
                return isMatch("", pattern.substring(2, pattern.length()));
            }
        }

        if (pattern.length() == 1) {
            if (pattern.charAt(0) == '.') {
                return isMatch("", pattern.substring(1, pattern.length()));
            }
            if (pattern.charAt(0) == '*') {
                return true;
            }
        }
        if (string.length() == 0 && pattern.length() != 0) {
            return false;
        }
        if (string.length() != 0 && pattern.length() == 0) {
            return false;
        }

//        int s = 0, p = 0;
        char pc = pattern.charAt(0);
        char pc2 = ' ';
        if (pattern.length() > 1) {
            pc2 = pattern.charAt(1);
        }

        char sc = string.charAt(0);
        if (pc == '.') {
            return isMatch(string.substring(1, string.length()), pattern.substring(1, pattern.length())) || isMatch(string.substring(0, string.length()), pattern.substring(1, pattern.length()));
        } else if (pc2 == '*') {
            int i = 0;

            while (true) {
                if (sc == pc) {
                    i++;
                    if (string.length() > i) {
                        sc = string.charAt(i);
                    } else {
                        return true;
                    }

                } else {
                    break;
                }
            }
            if (i == 0) {
                return false;
            }
            return isMatch(string.substring(i, string.length()), pattern.substring(2, pattern.length()));
        } else {
            if (pc == sc) {
                return isMatch(string.substring(1, string.length()), pattern.substring(1, pattern.length()));
            }
            if (pc == '*') {
                return isMatch(string.substring(1, string.length()), pattern.substring(1, pattern.length()))
                        || isMatch(string.substring(1, string.length()), pattern.substring(0, pattern.length()));
            }
        }

        return false;
    }

    private static boolean isMatch2(String string, String pattern) {
        if (string.length() == 0 && pattern.length() == 0) {
            return true;
        }
        if (string.length() == 0 && pattern.length() != 0) {
            return false;
        }
        if (string.length() != 0 && pattern.length() == 0) {
            return false;
        }

//        int s = 0, p = 0;
        char pc = pattern.charAt(0);
        char pc2 = pattern.charAt(1);
        char sc = string.charAt(0);
        if (pc == '.') {
            return isMatch(string.substring(1, string.length()), pattern.substring(1, pattern.length()));
        } else if (pc == '*') {
            return (isMatch(string.substring(1, string.length()), pattern.substring(1, pattern.length())) || isMatch(string.substring(1, string.length()), pattern.substring(0, pattern.length())));
        } else {
            if (pc == sc) {
                return isMatch(string.substring(1, string.length()), pattern.substring(1, pattern.length()));
            }
        }

        return false;
    }
}