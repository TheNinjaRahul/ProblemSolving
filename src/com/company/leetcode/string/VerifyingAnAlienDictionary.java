package com.company.leetcode.string;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class VerifyingAnAlienDictionary {
    public static void main(String[] args) {

        String[] s2 = {"wo", "wor", "word", "world", "row"};
        String order2 = "worldabcefghijkmnpqstuvxyz";
        System.out.println(isAlienSorted(s2, order2));


        String[] s = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(isAlienSorted(s, order));
    }

    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 1;
        for (char c : order.toCharArray()) {
            map.put(c, i++);
        }
        for (i = 0; i < words.length - 1; i++) {
            char[] str1 = words[i].toCharArray();
            char[] str2 = words[i + 1].toCharArray();
            int j = 0;
            while (j < str1.length && j < str2.length && str1[j] == str2[j]) {
                j++;
            }
            if (j >= str2.length) return false;
            if (j < str1.length && j < str2.length && map.get(str1[j]) > map.get(str2[j])) {
                return false;
            }

        }
        return true;
    }
}
