package com.company.GFG.Hashing;

import java.util.*;

/***
 * Find All Four Sum Numbers
 * Given an array of integers and another number. Find all the unique quadruples from the given array that sums up to the given number.
 *
 * Input:
 * The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains two lines. The first line of input contains two integers N and K. Then in the next line are N space separated values of the array.
 *
 * Output:
 * For each test case in a new line print, all the quadruples present in the array separated by space which sums up to the value of K. Each quadruple is unique which are separated by a delimiter "$" and are in increasing order.
 *
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function fourSum() which takes the array arr[] and the integer k as its input and returns an array containing all the quadruples in lexicographical manner. Also note that all the quadruples should be internally sorted, ie for any quadruple [q1, q2, q3, q4] the following should follow: q1 <= q2 <= q3 <= q4.
 *
 * Expected Time Complexity: O(N3).
 * Expected Auxiliary Space: O(N2).
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 100
 * -1000 <= K <= 1000
 * -100 <= A[] <= 100
 *
 * Example:
 * Input:
 * 2
 * 5 3
 * 0 0 2 1 1
 * 7 23
 * 10 2 3 4 5 7 8
 * Output:
 * 0 0 1 2 $
 * 2 3 8 10 $2 4 7 10 $3 5 7 8 $
 */
public class FindAllFourSumNumbers {
    public static void main(String[] args) {
        int[] a = {0, 0, 2, 1, 1};
        System.out.println(fourSum(a, 3));
    }

    public static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<ArrayList<Integer>> list = new LinkedHashSet<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = 0; i < arr.length - 3; i++) {
            for (int j = i + 1; j < arr.length - 2; j++) {
                for (int l = j + 1; l < arr.length - 1; l++) {
                    int sum = k - (arr[i] + arr[j] + arr[l]);
                    int innercount=0;
                    for(int m=i;m<=l;m++){
                        if(arr[m]==sum){
                            innercount++;
                        }
                    }
                    if (map.containsKey(sum) && innercount<map.get(sum)) {
                        ArrayList<Integer> mini = new ArrayList<>();
                        mini.add(arr[i]);
                        mini.add(arr[j]);
                        mini.add(arr[l]);
                        mini.add(sum);
                        Collections.sort(mini);
                        list.add(mini);
                    }
                }
            }
        }
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        for(ArrayList<Integer> i:list){
            result.add(i);
        }
        return result;
    }

}
