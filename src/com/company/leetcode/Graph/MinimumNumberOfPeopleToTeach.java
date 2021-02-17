package com.company.leetcode.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumNumberOfPeopleToTeach {
    public static void main(String[] args) {

    }

    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int ans = n;
        Map<Integer, Set<Integer>> langToUserMap = new HashMap<>();
        for (int i = 0; i < languages.length; i++) {
            int[] a = languages[i];
            for (int l : a) {
                if (!langToUserMap.containsKey(l)) {
                    langToUserMap.put(l, new HashSet<>());
                }
                langToUserMap.get(l).add(i);
            }
        }

        int p = languages.length;
        for (Set<Integer> set : langToUserMap.values()) {
            ans = Math.min(p - set.size(), ans);
        }

        return ans;
    }

}
