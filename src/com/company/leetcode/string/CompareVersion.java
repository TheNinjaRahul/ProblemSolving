package com.company.leetcode.string;

public class CompareVersion {
    public static void main(String[] args) {
//        System.out.println(Integer.parseInt("00010"));
        System.out.println(compareVersion("1", ""));
        System.out.println(compareVersion("0", ""));
        System.out.println(compareVersion("1.0.1", "1"));
        System.out.println(compareVersion("1.001.1.3", "1.01.1"));
        System.out.println(compareVersion("1.0", "1.0.0"));
        System.out.println(compareVersion("1.0.1", "1.001.1"));
        System.out.println(compareVersion("1.01.1", "1.001.1.3"));

    }


    public static int compareVersion(String version1, String version2) {
        if (version1.length() == 0 && version2.length() == 0) {
            return 0;
        }
        if (version1.length() == 0 && version2.length() != 0) {
            int j = 0;
            String[] v2 = version2.split("\\.");
            while (j != v2.length) {
                if (Integer.parseInt(v2[j]) != 0) {
                    return -1;
                }
                j++;
            }
            return 0;
        }
        if (version1.length() != 0 && version2.length() == 0) {
            int j = 0;
            String[] v2 = version1.split("\\.");
            while (j != v2.length) {
                if (Integer.parseInt(v2[j]) != 0) {
                    return 1;
                }
                j++;
            }
            return 0;
        }

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int i = 0, j = 0;

        while (i < v1.length && j < v2.length) {
            if (Integer.parseInt(v1[i]) != Integer.parseInt(v2[j])) {
                return Integer.parseInt(v1[i]) - Integer.parseInt(v2[j]);
            } else {
                i++;
                j++;
            }
        }
        while (i != v1.length) {
            if (Integer.parseInt(v1[i]) != 0) {
                return 1;
            }
            i++;
        }

        while (j != v2.length) {
            if (Integer.parseInt(v2[j]) != 0) {
                return -1;
            }
            j++;
        }

        return 0;
/*

        while (i < v1.length && j < v2.length) {
            int x = 0, y = 0;
            while (x < v1[i].length() && v1[i].charAt(x) == '0') {
                x++;
            }

            if (x == v1[i].length()) {
                x--;
            }
            while (y < v2[j].length() && v2[j].charAt(y) == '0') {
                y++;
            }

            if (y == v2[j].length()) {
                y--;
            }

            if (x < v1[i].length() && y < v2[j].length() && v1[i].length() != 0 && v2[j].length() != 0 && v1[i].charAt(x) != v2[j].charAt(y)) {
                return v1[i].charAt(x) - v2[j].charAt(y);
            } else {
                i++;
                j++;
            }

        }
*/
//        while (i != v1.length) {
//            int x = 0;
//            while (x < v1[i].length() && v1[i].charAt(x) == '0') {
//                x++;
//            }
//            if (x == v1[i].length()) {
//                x--;
//            }
//            if (v1[i].charAt(x) != '0') {
//                return 1;
//            }
//            if (i + 1 == v1.length) {
//                return 0;
//            }
//            i++;
//        }
//
//
//        while (j != v2.length) {
//            int y = 0;
//            while (y < v2[j].length() && v2[j].charAt(y) == '0') {
//                y++;
//            }
//            if (y == v2[j].length()) {
//                y--;
//            }
//            if (v2[j].charAt(y) != '0') {
//                return -1;
//            }
//            if (j + 1 == v2.length) {
//                return 0;
//            }
//            j++;
//        }
//
//
//        return 0;
    }
}
