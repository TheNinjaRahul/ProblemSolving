package com.company.GFG.Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


/**
 * Maximum of all subarrays of size k
 * Given an array A and an integer K. Find the maximum for each and every contiguous subarray of size K.
 * <p>
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. The first line of each test case contains a single integer N denoting the size of array and the size of subarray K. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
 * <p>
 * Output:
 * For each testcase, in a new line, print the maximum for every subarray of size k.
 * <p>
 * Your Task:
 * This is a function problem. You only need to complete the function max_of_subarrays that returns an array of answer. The printing is automatically done by the driver code.
 * <p>
 * Expected Time Complexity : O(n)
 * Expected Auxilliary Space : O(n)
 * <p>
 * Constraints:
 * 1 ≤ T ≤ 200
 * 1 ≤ N ≤ 107
 * 1 ≤ K ≤ N
 * 0 ≤ A[i] <= 107
 * <p>
 * Example:
 * Input:
 * 2
 * 9 3
 * 1 2 3 1 4 5 2 3 6
 * 10 4
 * 8 5 10 7 9 4 15 12 90 13
 * Output:
 * 3 3 4 5 5 5 6
 * 10 10 10 15 15 90 90
 * <p>
 * Explanation:
 * Testcase 1: Starting from first subarray of size k = 3, we have 3 as maximum. Moving the window forward, maximum element are as 3, 4, 5, 5, 5 and 6.
 * Testcase 2: Starting from first subarray of size k =, we have 10 as maximum. Moving the window forward maximum elements are as follows 10 10 10 15 15 90 90.
 */
public class MaximumOfAllSubarraysOfSizeK {
    public static void main(String[] args) {
//        int data[]={1,2,3,1,4,5,2,3,6};

//        int data[]={1,3,-1,-3,5,3,6,7};
        int data[]={9,10,9,-7,-4,-8,2,-6}
        ;
        System.out.println(Arrays.toString(maxSlidingWindow(data,5)));
    }

    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        int maxIndex = 0;
        int i = 0;
        ArrayList<Integer> output=new ArrayList<>();
        Deque<Integer> q = new LinkedList<>();
        while (i < k) {
            if (q.isEmpty() || arr[q.getLast()] >= arr[i]) {
                q.addLast(i);
            } else {
                while (!q.isEmpty() && arr[i] >= arr[q.getLast()]) {
                    q.removeLast();
                }
                q.addLast(i);
            }
            i++;
        }
        output.add(arr[q.getFirst()]);
        for (i = k; i < arr.length; i++) {
            if (i-k == q.getFirst()) {
                q.removeFirst();
            }
            if (q.isEmpty() || arr[q.getLast()] >= arr[i]) {
                q.addLast(i);
            } else {
                while (!q.isEmpty() && arr[i] >= arr[q.getLast()]) {
                    q.removeLast();
                }
                q.addLast(i);
            }
            output.add(arr[q.getFirst()]);
        }
        return output;
    }


    public static int[] maxSlidingWindow(int[] arr, int k) {
        int maxIndex = 0;
        int i = 0;
        int[] output=new int[arr.length-k+1];
        int oi=0;
        Deque<Integer> q = new LinkedList<>();
        while (i < k) {
            if (q.isEmpty() || arr[q.getLast()] >= arr[i]) {
                q.addLast(i);
            } else {
                while (!q.isEmpty() && arr[i] >= arr[q.getLast()]) {
                    q.removeLast();
                }
                q.addLast(i);
            }
            i++;
        }
        output[oi++]=(arr[q.getFirst()]);
        for (i = k; i < arr.length; i++) {
            if (i-k == q.getFirst()) {
                q.removeFirst();
            }
            if (q.isEmpty() || arr[q.getLast()] >= arr[i]) {
                q.addLast(i);
            } else {
                while (!q.isEmpty() && arr[i] >= arr[q.getLast()]) {
                    q.removeLast();
                }
                q.addLast(i);
            }
            output[oi++]=(arr[q.getFirst()]);
        }
        return output;
    }
}
