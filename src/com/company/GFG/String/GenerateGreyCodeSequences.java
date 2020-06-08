package com.company.GFG.String;

import java.util.ArrayList;
import java.util.Arrays;

/***
 * Given a number N, your task is to complete the function which generates all n-bit grey code sequences,
 * a grey code sequence is a sequence such that successive patterns in it differ by one bit.
 *
 * Input:
 * The first line of input contains an integer T denoting the no of test cases.
 * Then T test cases follow. Each test case contains an integer N.
 *
 * Output:
 * For each test case in print the generated grey code sequences separated by space.
 *
 * Constraints:
 * 1<=T<=10
 * 1<=N<=10
 *
 * Example(To be used for expected output):
 * Input:
 * 2
 * 2
 * 1
 *
 *
 * Output:
 * 00 01 11 10
 * 0 1
 */
public class GenerateGreyCodeSequences {

    public static void main(String[] args){
        generateCode(1);
        generateCode(2);
        generateCode(3);
    }

    static void generateCode(int n){
        int count=1;
        String []old={"0","1"};
        for(int i=0;i<n-1;i++){
            String newstr[]=new String[old.length*2];
            int k=0;
            for(;k<old.length;k++){
                newstr[k]="0"+old[k];
            }

            for(int j=k-1;j>=0;j--){
                newstr[k++]="1"+old[j];
            }
            old=newstr;
        }

//        System.out.println(Arrays.toString(old));
    }
}
