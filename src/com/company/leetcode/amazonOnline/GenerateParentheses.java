package com.company.leetcode.amazonOnline;

import java.util.*;

public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
        System.out.println(g.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> output = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        dfs(0, 0, n, output, sb);
        return output;
    }

    public void dfs(int open, int close, int n, List<String> output, StringBuilder sb) {
        if (sb.length() == n * 2 && open == close) {
            output.add(sb.toString());
            return;
        }

        if (sb.length() == n * 2) return;

        if (open > close) {
            sb.append(")");
            dfs(open, close + 1, n, output, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        sb.append("(");
        dfs(open + 1, close, n, output, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
