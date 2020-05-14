package com.company.leetcode.string;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PermutationOfNumber {
    public static void main(String[] args) {

        int[] data = new int[]{1, 2, 3};
        System.out.println(printPermutationOF2(data));


    }

    public static List<List<Integer>> printPermutationOF2(int[] nums)
    {
        List<List<Integer>> output = new ArrayList<List<Integer>>();

        dfs(output, new ArrayList<Integer>(), nums);
        return output;
    }

    public static void  dfs(List<List<Integer>> output, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            output.add(new ArrayList<Integer>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (temp.contains(nums[i])) {
                    continue;
                }
                temp.add(nums[i]);
                dfs(output, temp, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }


    private static List<List<Integer>> printPermutationOF(int[] data) {
        List<List<Integer>> result = new ArrayList<>();

//        Map<Integer,Long> map=new HashMap<>();

        Map<Integer, Long> map = Arrays.stream(data).boxed().
                collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));

        int[] input = new int[map.size()];
        int[] freq = new int[map.size()];

        int k = 0;
        for (Map.Entry<Integer, Long> e : map.entrySet()) {
            input[k] = e.getKey();
            freq[k++] = e.getValue().intValue();
        }

        result.addAll(getAllCombination2(input, freq, 0, new int[data.length]));
        return result;
    }

    private static List<List<Integer>> getAllCombination2(int input[], int fre[], int level,
                                                          int[] result) {
        if (result.length == level) {
            List<List<Integer>> data = new ArrayList<>();
            List<Integer> intList = new ArrayList<Integer>(result.length);
            for (int i : result) {
                intList.add(i);
            }
            data.add(intList);
            return data;
        }

        List<List<Integer>> list = new ArrayList<>();
        int k = 0;
        while (true) {
            if (k == input.length) {
                break;
            }
            if (fre[k] > 0) {
                fre[k] = fre[k] - 1;
                result[level] = input[k];
                list.addAll(getAllCombination2(input, fre, level + 1, result));
                fre[k] = fre[k] + 1;
                k++;
            } else {
                k++;
            }
        }
        return list;
    }


    private static List<String> getAllCombination(char input[], int fre[], int level,
                                                  char[] result) {
        if (result.length == level) {
            System.out.println(String.valueOf(result));
            return Arrays.asList(String.valueOf(result));
        }

        List<String> list = new ArrayList<>();
        int k = 0;
        while (true) {
            if (k == input.length) {
                break;
            }
            if (fre[k] > 0) {
                fre[k] = fre[k] - 1;
                result[level] = input[k];
                list.addAll(getAllCombination(input, fre, level + 1, result));
                fre[k] = fre[k] + 1;
                k++;
            } else {
                k++;
            }
        }
        return list;
    }


}
