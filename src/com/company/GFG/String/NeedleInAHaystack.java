package com.company.GFG.String;

/***
 * Needle in a Haystack
 * Given 2 strings needle and haystack. Return the index of the first occurrence of needle in haystack.
 * If needle is not part of haystack return -1.
 * If needle is empty return 0.
 *
 * Input:
 * First line of input contains number of testcases T.
 * For each testcase, there will be two lines, first containing the string haystack
 * and second containing the string needle.
 *
 * Output:
 * Print the index of first occurance of needle in the haystack.
 *
 * User Task:
 * The task is to complete the function NeedleinHaystack that takes 2 strings needle and haystack
 *  as input and returns the position of its first occurance.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= haystack.length() <= 1000
 * 0 <= needle.length() <= 1000
 *
 * Example :
 * Input:
 * 2
 * geeksforgeeks
 * geeks
 * hellolola
 * lola
 * Output:
 * 0
 * 5
 */
public class NeedleInAHaystack {
    public static void main(String[] args) {
//        System.out.println(needleinHaystack("geeksforgeeks","geeks"));
//        System.out.println(needleinHaystack("hellolola","lola"));
        System.out.println(needleinHaystack("mississippi","issip"));
    }

    public static int needleinHaystack(String haystack, String needle) {
        int[] t = new int[needle.length()];

        int i = 0, j = 1;
        while (j < needle.length()) {
            if (needle.charAt(i) == needle.charAt(j)) {
                t[j] = i + 1;
                i++;
            } else {
                i = 0;
            }
            j++;
        }
        i=0;j=0;
        while(i<haystack.length()){
            if(j==needle.length()){
                return i-j;
            }
            if(haystack.charAt(i)==needle.charAt(j)){
                j++;
            }else{
               if(j!=0){
                   j=t[j-1];
                   continue;
               }
            }
            i++;
        }
        return j==needle.length() ? i-j : -1;
    }
}
