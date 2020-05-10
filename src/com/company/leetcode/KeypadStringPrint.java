package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeypadStringPrint {
    public static void main(String[] args) {
        System.out.println(findKeypadString("234"));
    }

    private static List<String> findKeypadString(String s) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '2':
                    list.add("abc");
                    break;
                case '3':
                    list.add("def");
                    break;
                case '4':
                    list.add("ghi");
                    break;
                case '5':
                    list.add("jkl");
                    break;
                case '6':
                    list.add("mno");
                    break;
                case '7':
                    list.add("pqrs");
                    break;
                case '8':
                    list.add("tuv");
                    break;
                case '9':
                    list.add("wxyz");
                    break;
            }

        }
        return getAllStringPossible(list, 0, "");
    }

    private static List<String> getAllStringPossible(List<String> list, int current, String previous) {

        if (current == list.size()) {
            return Arrays.asList(previous);
        }

        List<String> result = new ArrayList<>();

//        for (int i = 0; i < list.size(); i++) {
//            if(i==current){
//                continue;
//            }
//            String currentString = list.get(current);

            for (int j = 0; j < list.get(current).length(); j++) {
                result.addAll(getAllStringPossible(list, current + 1, previous + String.valueOf(list.get(current).charAt(j))));
//            }
        }

        return result;
    }
}
