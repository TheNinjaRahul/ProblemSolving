package com.company.leetcode.amazonOnline;

import java.util.*;

public class Data {

    public static List<String> kSubstring(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        List<String> res = new LinkedList<>();
        //awaglk
        int left = 0;
        ;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (right - left == k - 1) {
                //System.out.println(right);
                String g = (toString(s, left, right));
                //  System.out.println(g);
                // int count=0;


                //   if(count==1)
                res.add(g);
                left++;

            }
        }

        List<String> op = new LinkedList<>();
        for (String m : res) {


            int count = 0;
            //   System.out.println("********"  + m + "    " + count);
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < m.length(); i++) {

                boolean f = set.add(m.charAt(i));
                //  System.out.println(f);
                if (!f)
                    count++;

            }
            //  System.out.println(count  + " " + set);
            if (count == 1)
                op.add(m);
        }
        return op;
    }

    public static String toString(String s, int left, int right) {

        StringBuilder sb = new StringBuilder();
        int i = left;
        while (i <= right) {
            sb.append(s.charAt(i));
            i++;
        }
        return sb.toString();
    }
}
