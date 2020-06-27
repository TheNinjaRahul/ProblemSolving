package com.company.GFG.stack;

import java.util.Stack;

public class EvaluationOfPostfixExpression {
    public static void main(String[] args) {

    }

    public static int evaluatePostFix(String exp){
        Stack<Integer> stack=new Stack<>();

        for(char c:exp.toCharArray()){
            if(Character.isDigit(c)){
                stack.push(Integer.parseInt(String.valueOf(c)));
            }else{
                int b=stack.pop();
                int a=stack.pop();
                switch (c){
                    case '+':stack.push(a+b);break;
                    case '-':stack.push(a-b);break;
                    case '*':stack.push(a*b);break;
                    case '/':stack.push(a/b);break;
                    default:
                        System.out.println("Symbol not found:"+c);
                }
            }

        }
        return stack.peek();
    }
}
