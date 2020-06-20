package com.company.GFG.LinkList;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Count Pairs whose sum is equal to X
 * Given two linked list of size N1 and N2 respectively of distinct elements, your task is to complete the function countPairs(), which returns the count of all pairs from both lists whose sum is equal to the given value X.
 *
 * Input:
 * The function takes three arguments as input, reference pointer to the head of the two linked list (head1 and head2), and an variable X.
 * There will be T test cases and for each test case the function will be called separately.
 * Note : All elements in a linked list are unique.
 *
 * Output:
 * For each test case the function should return the count of all the pairs from both lists whose sum is equal to the given value X.
 *
 * Your Task:
 * You only need to implement the given function countPairs(). Do not read input, instead use the arguments given in the function.
 *
 * Expected Time Complexity: O(N+M)
 * Expected Auxiliary Space: O(N+M)
 *
 * Constraints:
 * 1<=T<=100
 * 1<=N1,N2<=10000
 * 1<=X<=10000
 *
 * Example:
 * Input:
 * 2
 * 6
 * 1 2 3 4 5 6
 * 3
 * 11 12 13
 * 15
 * 4
 * 7 5 1 3
 * 4
 * 3 5 2 8
 * 10
 *
 * Output:
 * 3
 * 2
 */
public class CountPairsWhoseSumIsEqualToX {
    public static void main(String[] args) {

    }
    public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2,
                                 int x) {
        Set<Integer> set=new HashSet<>();
        for(Integer i:head1){
            set.add(i);
        }
        int count=0;
        for(Integer i:head2){
            if(set.contains(x-i)){
                count++;
            }
        }
        return count;
    }
}
