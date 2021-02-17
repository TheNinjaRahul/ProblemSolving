package com.company.leetcode.string;

import java.util.LinkedList;

public class SimplifyPath {

    public static void main(String[] args) {
        System.out.println(simplifyPath("/..hidden"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home/"));
    }


    public static String simplifyPath(String path) {
        int i = 0;
        LinkedList<String> list = new LinkedList<>();
        while (i < path.length()) {
            char c = path.charAt(i);
            if (c == '/') {
                while (i < path.length() && path.charAt(i) == '/') {
                    i++;
                }
                continue;
            } else if (c == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < path.length() && path.charAt(i) != '/') {
                    sb.append(path.charAt(i));
                    i++;
                }
                if (sb.length() == 2) {
                    i += 1;
                    if (list.size() > 0) {
                        list.removeLast();
                    }
                } else if (sb.length() == 1) {
                    // do nothing
                } else {
                    list.add(sb.toString());
                }
            } else {
                StringBuilder sb = new StringBuilder();
                while (i < path.length()) {
                    if (c == '/' || c == '.') {
                        break;
                    }
                    sb.append(c);
                    i++;
                    if (i >= path.length()) break;
                    c = path.charAt(i);
                }
                list.add(sb.toString());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append("/" + s);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }

}
