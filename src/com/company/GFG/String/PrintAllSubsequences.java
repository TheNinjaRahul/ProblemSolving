package com.company.GFG.String;

import java.util.LinkedList;
import java.util.List;

public class PrintAllSubsequences {
    public static void main(String[] args) {
        PrintAllSubsequences printAllSubsequences = new PrintAllSubsequences();
        printAllSubsequences.findAllPossibleSubSequences("abc");
    }

    public List<String> findAllPossibleSubSequences(String s) {
        List<String> list = new LinkedList<>();
        rec("", s, list);
        System.out.println(list);
        return list;
    }

    private void rec(String current, String source, List<String> list) {
        if (source.length() == 0) {
            if (current.length() != 0) {
                list.add(current);
            }
            return;
        }
        rec(current, source.substring(1), list);
        current += source.charAt(0);
        rec(current, source.substring(1), list);
    }
}
