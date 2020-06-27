package com.company.GFG.Recursion;

public class TowerOfHenoi {
    public static void main(String[] args) {
        TOH(3,'A','C','B');
    }

    private static void TOH(int n, char source, char destination, char aux) {
        if(n==1){
            System.out.println("Move Disk "+n +" from  "+source+" to "+destination);
            return;
        }
        TOH(n-1,source,aux,destination);
        System.out.println("Move Disk "+n +" from  "+source+" to "+destination);
        TOH(n-1,aux,destination,source);
    }
}
