package com.company.GFG.BackTracking;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(allParenthesis(2));
    }

    public static List<String> allParenthesis(int n) {
        return generate("", 0, 0, n);
    }

    private static List<String> generate(String s, int open, int close, int n) {
        List<String> r = new LinkedList<>();
        if (s.length() == n * 2) {
            r.add(s);
            return r;
        } else {
            if (open < n) {
                r.addAll(generate(s + "(", open + 1, close, n));
            }
            if (open > close) {
                r.addAll(generate(s + ")", open, close + 1, n));
            }

        }


        return r;
    }
}
