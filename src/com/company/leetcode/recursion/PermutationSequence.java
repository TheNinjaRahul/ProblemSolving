package com.company.leetcode.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/permutation-sequence/
 */
public class PermutationSequence {
    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
    }

    static class MyCount {
        int k;

        public MyCount(int k) {
            this.k = k;
        }
    }

    public static String getPermutation(int n, int k) {

        String str = "";
        for (int i = 1; i <= n; i++) {
            str += i;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        char[] chars = new char[map.size()];
        int[] freq = new int[map.size()];
        int i = 0;
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            chars[i] = e.getKey();
            freq[i] = e.getValue();
            i++;
        }

        char[] result = new char[str.length()];
        MyCount mycount = new MyCount(0);
        MyCount targetCount = new MyCount(k);
        ArrayList<String> list = getItDone(str, result, chars, freq, 0, mycount, targetCount);
        return list.get(0);
    }

    private static ArrayList<String> getItDone(String str, char[] result, char[] chars, int[] freq, int level, MyCount mycount, MyCount targetCount) {
        ArrayList<String> list = new ArrayList<>();
        if (level == str.length()) {
            if (mycount.k + 1 == targetCount.k) {
                list.add(String.valueOf(result));
                return list;
            }
            mycount.k=mycount.k+1;
            return list;
        }

        for (int i = 0; i < chars.length; i++) {
            if (freq[i] == 0) continue;
            result[level] = chars[i];
            freq[i]--;
            list=getItDone(str, result, chars, freq, level + 1, mycount, targetCount);
            if(list.size()==1){
                return list;
            }
            freq[i]++;
        }
        return list;
    }
}
