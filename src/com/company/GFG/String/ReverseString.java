package com.company.GFG.String;

import java.util.Arrays;

/***
 * Reverse words in a given string
 * Given a String of length S, reverse the whole string without reversing the individual words in it. Words are separated by dots.
 *
 * Input:
 * The first line contains T denoting the number of testcases. T testcases follow. Each case contains a string S containing characters.
 *
 * Output:
 * For each test case, in a new line, output a single line containing the reversed String.
 *
 * User Task:
 * The task is to complete the function reverseWords() which reverse words from the given string and prints the answer. The newline is automatically appended by the driver code.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= |S| <= 2000
 *
 * Example:
 * Input:
 * 2
 * i.like.this.program.very.much
 * pqr.mno
 * Output:
 * much.very.program.this.like.i
 * mno.pqr
 *
 * Explanation:
 * Testcase 1: After reversing the whole string(not individual words), the input string becomes much.very.program.this.like.i.
 * Testcase 2: After reversing the whole string , the input string becomes mno.pqr.
 */
public class ReverseString {
    public static void main(String[] args) {
        String input="Hi";
        reverseWords(input);
    }

    public static void reverseWords(String sd) {


        char input[]=sd.toCharArray();
        int k=0,p=0,q=0;
        boolean foundDot=false;
        while(k<input.length){
            if(input[k]=='.'){
                foundDot=true;
                if(k!=input.length-1){
                    q=k-1;
                }
                while(q>p){
                    char temp=input[q];
                    input[q]=input[p];
                    input[p]=temp;
                    q--;p++;
                }
                p=k+1;
                q=input.length-1;
            }
            k++;
        }




        if(foundDot){
            while(q>p){
                char temp=input[q];
                input[q]=input[p];
                input[p]=temp;
                q--;p++;
            }
            p=0;
            q=input.length-1;
            while(q>p){
                char temp=input[q];
                input[q]=input[p];
                input[p]=temp;
                q--;p++;
            }
        }

        System.out.print(String.valueOf(input));

    }
//    }
}
