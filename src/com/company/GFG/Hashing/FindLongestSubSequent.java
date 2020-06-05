package com.company.GFG.Hashing;

import java.util.Set;
import java.util.TreeSet;

/**
 * Longest consecutive subsequence
 * Given an array of positive integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.
 *
 * Input:
 * The first line of input contains T, number of test cases. First line of line each test case contains a single integer N.
 * Next line contains N space separated values of the array.
 *
 * Output:
 * Print the output of each test case in a seprate line.
 *
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function findLongestConseqSubseq() which takes the array arr[] and the size of the array as inputs and returns the length of the longest subsequence of consecutive integers.
 *
 * Expected Time Complexity: O(N).
 * Expected Auxiliary Space: O(N).
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 105
 * 0 <= a[i] <= 105
 *
 * Example:
 * Input:
 * 2
 * 7
 * 2 6 1 9 4 5 3
 * 7
 * 1 9 3 10 4 20 2
 * Output:
 * 6
 * 4
 *
 * Explanation:
 * Testcase 1:  The consecutive numbers here are 1, 2, 3, 4, 5, 6. These 6 numbers form the longest consecutive subsquence.
 * Testcase2: 1, 2, 3, 4 is the longest consecutive subsequence.
 */
public class FindLongestSubSequent {
    public static void main(String[] args) {
        int []d={8,9,1,2,3,1};
        System.out.println(findLongestConseqSubseq(d,d.length));
    }


    static int findLongestConseqSubseq(int arr[], int N)
    {
        Set<Integer> set=new TreeSet<>();

        for(int i=0;i<N;i++){
            set.add(arr[i]);
        }

        int count=0,max=-1;int prev=0;
        int k=0;
        for(Integer i:set){
            if(k==0){
                prev=i;
                k++;
                count++;
                continue;
            }

            if(prev+1!=i){
                if(max<count){
                    max=count;
                }
                count=0;
            }
            prev=i;
            count++;
        }

        return count>max? count : max;

    }
}
