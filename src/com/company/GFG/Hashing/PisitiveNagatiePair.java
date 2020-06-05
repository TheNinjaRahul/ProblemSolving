package com.company.GFG.Hashing;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/***
 * Positive Negative Pair
 * Given an array of distinct integers, find all the pairs having negative and positive value of a number that exists in the array.
 *
 * Input:
 * First line of input contains number of testcases T. For each testcase, first line contains an integer N, number of elements in the array. Next line contains N space separated array elements.
 *
 * Output:
 * Print the pairs of negative and positive that have the same absolute value in order of their occurrences. Print 0 if no such pair exists.
 *
 * Your Task:
 * Complete the function findPairs() which takes the array A[] and the size of the array, N, as input parameters and returns an array of integers.
 * Elements in the array should contain the pairs according to order of their occurrence. Within the pair the negative integer should appear before positive integer. Return empty integer list if no such pair exists.
 *
 * Expected Time Complexity: O(N)
 * Expected Auxiliary Space: O(N)
 *
 * Constraints:
 * 1 <= T <= 50
 * 1 <= N <= 106
 * -106 <= arr[i] <= 106
 *
 * Example:
 * Sample Input:
 * 2
 * 8
 * 1 3 6 -2 -1 -3 2 7
 * 3
 * 3 2 1
 *
 * Sample Output:
 * -1 1 -3 3 -2 2
 * 0
 *
 * Explanation:
 * Testcase 1: 1, 3 and 2 are present pairwirse postive and negative. 6 and 7 have no pair.
 * Testcase 2: No such pair exists so the output is 0.
 */

public class PisitiveNagatiePair {
    public static void main(String[] args) {
        int[] data={1,-44,27,15,16,-97,21,-5,-48,-64,29,-62,62,-76,-68,89,96,7,-27,20,-73,3,-2,90,55,34,71,56,76,-87,-20,39,-58,59,23,35,83,99,40,-14,98,88,24,-77,18,84,-60,44,94,-33,41,11,-36};
        System.out.println(findPairs(data,0));
    }

    public static ArrayList<Integer> findPairs(int arr[], int n) {
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int value = Math.abs(arr[i]);
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        ArrayList<Integer> list=new ArrayList<>();
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            if(e.getValue()==2){
                list.add(-e.getKey());
                list.add(e.getKey());
            }
        }

        return list;

    }
}
