package com.company.leetcode;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String input= "(])";
        System.out.println(isValid(input));
    }

    private static boolean isValid(String input) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='}' && !stack.isEmpty()){
                if(stack.peek()=='{'){
                    stack.pop();
                }else {
                    stack.push(input.charAt(i));
                }
            }else if(input.charAt(i)==')' && !stack.isEmpty()){
                if(stack.peek()=='('){
                    stack.pop();
                }else{
                    stack.push(input.charAt(i));
                }
            }else if(input.charAt(i)==']' && !stack.isEmpty()){
                if(stack.peek()=='['){
                    stack.pop();
                }else{
                    stack.push(input.charAt(i));
                }
            }
            else {
                stack.push(input.charAt(i));
            }
        }

        return stack.isEmpty();

    }
}
