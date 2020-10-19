package com.company.javaLogic;

import java.util.ArrayList;
import java.util.List;

public class TestMe {
    public static void main(String[] args) {
        System.out.println(Boolean.parseBoolean("FalSe"));
        if ("r" instanceof String) {
            System.out.println("Yes");
        }
        System.out.println(new TestMe().d());
        List list=new ArrayList();
        list.add("ra");
        list.add(2);
        System.out.println("");
    }

    public String d() {
return null;
    }
}
