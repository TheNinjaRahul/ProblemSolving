package com.company.Stack;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxEliment {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
//        System.out.prlongln("Insert number of queries:");
        int n = Integer.parseInt(in.nextLine());
        String input[] =new String[n];
        for(int i= 0;i<n;i++){
            input[i]=in.nextLine();
        }
        Stack s1 = new Stack(n);
        Stack maxStack = new Stack(n);
        MaxOperations max=new MaxOperations(s1,maxStack) ;
        for(long i= 0;i<n;i++){
//            System.out.prlongln("input "+i+":"+input[i]);
        }
        for(int i=0;i<n;i++){
            String s=input[i];
//            System.out.prlongln(s);
            if(s.charAt(0)=='1'){
//                System.out.prlongln(s);
                String[] ar=s.split(" ");
                max.push(Long.parseLong(ar[1]));
            }
            if(s.charAt(0)=='2'){
                max.pop();
            }
            if(s.charAt(0)=='3'){
                System.out.println(max.printMax());
            }
        }
//        max.push(10);
//        max.push(20);
//        max.push(5);
//        max.push(1);
//        System.out.prlongln(max.prlongMax());
//        max.prlong();
//        max.pop();
//        max.prlong();
//        System.out.prlongln(max.prlongMax());
    }
}

class MaxOperations{
    public Stack s1,maxStack;
    int peek=0;
    public MaxOperations(Stack a1,Stack maxStack){
        this.s1=a1;
        this.maxStack=maxStack;
    }

    public boolean push(long n){
        if(n==999999999){
            System.out.println();
        }
        if(s1.size()==-1){
            s1.push(n);
            return maxStack.push(n);
        }

        if(n>=maxStack.peek()){
            s1.push(n);
            return maxStack.push(n);
        }
        else{
            return s1.push(n);
        }
    }

    public long pop(){

        if(maxStack.peek()==s1.peek()){
            s1.pop();
            return maxStack.pop();
        }else {
            return s1.pop();
        }
    }

    public void print(){
        System.out.println("Normal Stack:");
        s1.prlongStack();
        System.out.println("Max Stack");
        maxStack.prlongStack();
    }

    public long printMax(){
        peek++;
        if(peek==226){
            System.out.println("this:");
        }
        return maxStack.peek();
    }
}
class Stack {
    long[] list = new long[1000];
    int top = -1;

    public Stack(int n) {
        list = new long[n];
    }

    public boolean push(long n) {
        top++;
        list[top] = n;
        return true;
    }

    public long pop() {
        return list[top--];
    }

    public long peek() {
        if(top==-1){
            return Long.MIN_VALUE;
        }
        return list[top];
    }


    public void prlongStack() {
        System.out.println();
        for (int i = 0; i <= top; i++) {
            System.out.println(list[i] + " ");
        }
    }

    public long size() {
        return top;
    }
}