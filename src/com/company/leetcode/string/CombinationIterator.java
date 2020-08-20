package com.company.leetcode.string;

import java.util.LinkedList;
import java.util.List;

public class CombinationIterator {
    public static void main(String[] args) {

//        CombinationIterator ci3 = new CombinationIterator("abc", 0);
        CombinationIterator ci = new CombinationIterator("gkosu", 3);
//        CombinationIterator ci2 = new CombinationIterator("abc", 3);


    }

    LinkedList<String> list = new LinkedList<>();

    public CombinationIterator(String characters, int combinationLength) {
        generatedList(characters, list, combinationLength, "", 0);
        System.out.println(list);
    }

    private void generatedList(String characters, List<String> list, int combinationLength, String s, int index) {
        if (s.length() == combinationLength) {
            list.add(s);
            return;
        }
        if (characters.length() == 0) return;
        generatedList(characters.substring(1), list, combinationLength, s + characters.charAt(0), 0);
        generatedList(characters.substring(1), list, combinationLength, s, 0);
    }

    public String next() {
        return list.removeFirst();
    }

    public boolean hasNext() {
        return list.size() > 0;
    }
}

