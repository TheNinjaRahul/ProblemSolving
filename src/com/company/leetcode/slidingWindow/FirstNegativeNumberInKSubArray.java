package com.company.leetcode.slidingWindow;

import java.util.LinkedList;
import java.util.List;

public class FirstNegativeNumberInKSubArray {
    public static void main(String[] args) {
        FirstNegativeNumberInKSubArray f = new FirstNegativeNumberInKSubArray();
        System.out.println(f.getFirstNegativeNumberInKSubArray(new int[]{-8, 2, 3, -6, 10}, 2));
    }

    public List<Integer> getFirstNegativeNumberInKSubArray(int[] a, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();

        int start = 0;
        for (int end = 0; end < a.length; end++) {
            if (a[end] < 0) {
                list.add(end);
            }
            if (end >= k - 1) {
                if (list.size() != 0) {
                    result.add(a[list.getFirst()]);

                    if (start == list.getFirst()) {
                        list.removeFirst();
                    }
                } else {
                    result.add(0);
                }
                start++;
            }
        }
//        System.out.println(list);
        return result;
    }
}
