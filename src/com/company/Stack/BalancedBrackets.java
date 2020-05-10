package com.company.Stack;


import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.Stack;
import java.util.regex.*;

public class BalancedBrackets {

    /*
     * Complete the equalStacks function below.
     */
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();

        int sh1 = 0, sh2 = 0, sh3 = 0;
        for (int i = h1.length - 1; i >= 0; i--) {
            sh1 += h1[i];
            s1.push(sh1);
        }

        for (int i = h2.length - 1; i >= 0; i--) {
            sh2 += h2[i];
            s2.push(sh2);
        }

        for (int i = h3.length - 1; i >= 0; i--) {
            sh3 += h3[i];
            s3.push(sh3);
        }

        while (true) {
            if (s1.empty() || s2.empty() || s3.empty()) {
                return 0;
            }

            sh1 = s1.peek();
            sh2 = s2.peek();
            sh3 = s3.peek();

            if (sh1==sh2 && sh2==sh3) {
                return s1.peek();
            }

            if (sh1 >= sh2 && sh1 >= sh3) {
                s1.pop();
            } else if (sh2 >= sh1 && sh2 >= sh3) {
                s2.pop();
            } else if (sh3 >= sh2 && sh3 >= sh2) {
                s3.pop();
            }

        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);
        System.out.println(result);

    }
}
