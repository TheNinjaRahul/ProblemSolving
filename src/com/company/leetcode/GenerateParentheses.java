package com.company.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParentheses2(3));
    }

    public static List<String> generateParentheses2(int n){
        return  startGenerating2("",n,0,0);
    }

    private static List<String> startGenerating2(String s, int n, int open, int close) {
        ArrayList<String> result=new ArrayList<>();
        if(open==n && close==n){
            result.add(s);
            System.out.println(s);
            return result;
        } else {
            if(close <= open){
                if(open>close){
                    result.addAll(startGenerating2(s+")",n,open,close+1));
                }
                if(open<n){
                    result.addAll(startGenerating2(s+"(",n,open+1,close));
                }
            }
        }

        return result;
    }

    private static List<String> startGenerating(String s, int n, int open, int close) {
        ArrayList<String> result=new ArrayList<>();
        if(open==n && close==n){
            result.add(s);
            System.out.println(s);
            return result;
        } else {
            if(close <= open){
                if(open<n){
                    result.addAll(startGenerating(s+"(",n,open+1,close));
                }
                if(close<n){
                    result.addAll(startGenerating(s+")",n,open,close+1));
                }
            }
        }

        return result;
    }


    public static List<String> generateParentheses(int n) {
        List<String> set = new ArrayList<>();
        if (n == 1) {
            set.add("()");
            return set;
        }
        if (n == 0) {
            set.add("");
            return set;
        }

        String input = "";
        for (int i = 0; i < n; i++) {
            input += "()";
        }

        return generateParentheses(input, 0);
    }

    private static List<String> generateParentheses(String input, int pos) {

        Set<String> result = new HashSet<>();
        if (isValid(input)) {
            result.add((input));
        }

        for (int i = pos; i < input.length() - 2; i++) {

//            String newName = myName.substring(0,4)+'x'+myName.substring(5);
//            String begin = input.substring(0, i);
//            String replace1 = input.substring(i + 1, i + 2);
//            String replace2 = input.substring(i, i + 1);
//            String end = input.substring(i + 2);

            String s = input.substring(0, i) + input.substring(i + 1, i + 2) + input.substring(i, i + 1) + input.substring(i + 2);
            result.addAll(generateParentheses(s, i + 1));
//            System.out.println(s);
        }
        return result.stream().collect(Collectors.toList());
    }

    private static boolean isValid(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ')' && !stack.isEmpty()) {
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(input.charAt(i));
                }
            } else {
                stack.push(input.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
