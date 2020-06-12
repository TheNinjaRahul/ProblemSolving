package com.company.GFG.String;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/***
 * String Modification
 * Given a string with repeated characters, the task is to complete the function rearrangeString which rearrange characters in a string so that no two adjacent characters are same, and returns that transformed string.
 *
 * Note : It may be assumed that the string has only lowercase English alphabets and such transformation is always always possible.
 *
 * Input:
 * The first line of input contains an integer T denoting the no of T test cases.
 * Then T test cases follow. The only line of every test case consists of String s.
 *
 * Output:
 * For each test case output in the expected output will be 1 if the string returned by the function is valid else 0.
 *
 *
 * Constraints:
 * 1<=T<=100
 * 1<=|s|<=100
 *
 * Example:
 * Input:
 * 2
 * aaabc
 * aaabb
 * Output:
 * 1
 * 1
 */
public class StringModification {

    public static void main(String[] args) {
        System.out.println(rearrangeString("aaabb"));
    }

    public static String rearrangeString(String str) {
        class KeyPair {
            char c;
            int freq;

            public KeyPair(char c, int f) {
                this.c = c;
                this.freq = f;
            }

            @Override
            public String toString() {
                return "KeyPair{" +
                        "c=" + c +
                        ", freq=" + freq +
                        '}';
            }
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        PriorityQueue<KeyPair> pqueue = new PriorityQueue<>((o1, o2) -> {
            return -(o1.freq - o2.freq);
        });

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            pqueue.add(new KeyPair(e.getKey(), e.getValue()));
        }

        String result = "";
        KeyPair prev = null;
        boolean flag = false;
        while (!pqueue.isEmpty()) {
            if (flag && prev!=null) {
                result += prev.c;
                prev.freq = prev.freq - 1;
                if (prev.freq == 0) {
                    prev = null;
                }else{
                    flag = true;
                }

            }

            KeyPair current = pqueue.poll();
            result += current.c;
            current.freq = current.freq - 1;
            if (current.freq != 0) {
                if (prev == null) {
                    prev = current;
                    flag = false;
                } else {
                    pqueue.add(current);
                    flag = true;
                }
            }else {
                flag=true;
            }

        }
        while(prev.freq>0){
            result+=prev.c;
            prev.freq--;
        }
        return result;
    }
}
