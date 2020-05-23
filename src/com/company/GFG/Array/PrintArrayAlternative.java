package com.company.GFG.Array;

public class PrintArrayAlternative {
    public static void main(String[] args) {

    }

    public static void print(int ar[], int n) {
        for (int i = 0; i < ar.length; i = i + 2) {
            if (i == 0) {
                System.out.println(ar[i]);
            }
            System.out.println(" " + ar[i]);

        }
    }
}
