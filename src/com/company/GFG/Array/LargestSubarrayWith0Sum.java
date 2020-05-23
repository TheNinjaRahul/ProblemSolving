package com.company.GFG.Array;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class LargestSubarrayWith0Sum {
    public static void main(String[] args) {
        int data[] = {15, -2, 2, -8, 1, 7, -15};
        System.out.println(maxLen(data, data.length));
        Set<Integer> set=new LinkedHashSet<>();
        
    }

    public static int maxLen(int arr[], int n) {
        int result = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
//        map.put(0,-1);
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            Integer pri = map.get(sum);

            if (arr[i] == 0 && result == 0)
                result = 1;

            if (sum == 0)
                result = i + 1;

            if (pri == null) {
                map.put(sum, i);
            } else {
                result = Math.max(result, i - pri );
            }
        }
        return result;
    }
}
