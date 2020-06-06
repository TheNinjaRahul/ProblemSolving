package com.company.leetcode.array;

import com.sun.org.apache.bcel.internal.generic.ARETURN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * suppose you have a random list of people standing in a queue.
 * Each person is described by a pair of integers (h, k),
 * where h is the height of the person and k is the number of people in front of this
 * person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 *
 * Note:
 * The number of people is less than 1,100.
 *
 *
 * Example
 *
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class QueueReconstructionByHeight {
    public static void main(String[] args) {
        int data[][]={{5,0}, {7,0}, {5,2}, {6,1}, {4,4}, {7,1}};
        System.out.println(Arrays.toString(reconstructQueue(data)));

        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(0,i);
        }
        System.out.println(list);
    }
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a, b)-> a[0]==b[0] ? a[1]-b[1] : b[0]-a[0]);
        for(int[] p:people){
            System.out.println(Arrays.toString(p));
        }
        System.out.println("--------------------------------");
        List<int[]> list=new ArrayList<>();
        for(int[] p: people){
            list.add(p[1],p);
        }
        for(int[] p:list){
            System.out.println(Arrays.toString(p));
        }
//        System.out.println(list);
        return list.toArray(new int[list.size()][]);

    }


}
