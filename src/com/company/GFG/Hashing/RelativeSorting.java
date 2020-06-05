package com.company.GFG.Hashing;

import java.util.*;


/****
 * Relative Sorting
 * Given two integer arrays. Sort the first array such that all the relative positions of the elements in the first array is same as the elements in the second array.
 *
 * Input:
 * First line of input contains number of testcases. For each testcase, first line of input contains length of arrays N and M and next two line contains N and M elements respectively.
 *
 * Output:
 * For each testcase, in a new line, print the elements of A1 sorted relatively according to A2.
 *
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function sortA1ByA2() which takes the array A1[], array A2[] and their respective size N and M as inputs and sorts the array A1[] such that the relative positions of the elements in A1[] is same as the elements in A2[]. For the elements not present in A2[] but in A1[], it appends them at the last in increasing order.
 *
 * Expected Time Complexity: O(NlogN).
 * Expected Auxiliary Space: O(N).
 *
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ N,M  ≤ 106
 * 1 ≤ A1[], A2[] <= 106
 *
 * Example:
 * Input:
 * 2
 * 11 4
 * 2 1 2 5 7 1 9 3 6 8 8
 * 2 1 8 3
 * 11 4
 * 2 1 2 5 7 1 9 3 6 8 8
 * 99 22 444 56
 *
 * Output:
 * 2 2 1 1 8 8 3 5 6 7 9
 * 1 1 2 2 3 5 6 7 8 8 9
 *
 * Explanation:
 * Testcase 1: Array elements of A1[] are sorted according to A1[]. So 2 comes first, then 1 comes, then comes, then finally 3 comes, now we append remaining elements in sorted order.
 * Testcase 2: No A2 elements are in A1 so we cannot sort A1 according to A2. Hence we sort the elements in non decreasing order.
 */
public class RelativeSorting {
    public static void main(String[] args) {
        int [] a={2 ,1, 2 ,5 ,7 ,1 ,9 ,3, 6 ,8, 8};
        int[]b={2 ,1 ,8 ,3};
        sortA1ByA2(a,a.length,b,b.length);
        System.out.println(Arrays.toString(a));
    }
    public static void sortA1ByA2(int A1[], int N, int A2[], int M)
    {
        Map<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<N;i++){
            map.put(A1[i],map.getOrDefault(A1[i],0)+1);
        }
        int k=0;
        for(int i=0;i<M;i++){
            if(map.containsKey(A2[i])){
                int j=0;
                while(j<map.get(A2[i])){
                    A1[k++]=A2[i];
                    j++;
                }
                map.remove(A2[i]);
            }
        }

        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            int j=0;
            while(j<e.getValue()){
                A1[k++]=e.getKey();
                j++;
            }
        }

    }
}
