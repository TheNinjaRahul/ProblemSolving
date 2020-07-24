package com.company.GFG.Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReArrangeCharacter {
    public static void main(String[] args) {
        System.out.println(rearrangeCharacters("bbbabaaacd"));
        System.out.println(rearrangeCharacters("geeksforgeeks"));
        System.out.println(rearrangeCharacters("bbbbb"));

    }


    static class ReArrange {
        char c;
        int fre = 0;

        public ReArrange(char c, int fre) {
            this.c = c;
            this.fre = fre;
        }
    }

    static boolean rearrangeCharacters(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<ReArrange> queue = new PriorityQueue<>((a, b) -> -(a.fre - b.fre));
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            queue.add(new ReArrange(e.getKey(), e.getValue()));
        }

        ReArrange last = new ReArrange('#', 0);
        StringBuilder sb = new StringBuilder();
//        boolean isLastUsed = false;
        while (!queue.isEmpty()) {
            ReArrange temp = queue.remove();
            sb.append(temp.c);
            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == sb.charAt(sb.length() - 2)) {
                System.out.println(sb.toString());
                return false;
            }
            temp.fre--;
            if (last.fre != 0) queue.add(last);
            last = temp;
        }
        System.out.println(sb.toString());
        return sb.length() == str.length();

    }


}
