package com.company.javaLogic;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapTest {
    public static void main(String[] args) {
        List<String> glist = new LinkedList<>();
        glist.add("Bhavnagar");
        glist.add("Gandhinagar");
        glist.add("Surat");

        List<String> mlist = new LinkedList<>();
        mlist.add("Mumbai");
        mlist.add("pune");

        List<String> all = Stream.of(glist, mlist).flatMap(List::stream).collect(Collectors.toList());
        System.out.println(all);


    }
}
