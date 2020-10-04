package com.company.leetcode.BST;

import com.company.GFG.dp.KnapSack01;
import com.sun.deploy.panel.JreTableModel;
import com.sun.org.apache.xerces.internal.impl.dv.xs.SchemaDVFactoryImpl;

import java.util.*;

class ThroneInheritance {

    public static void main(String[] args) {
        ThroneInheritance t2 = new ThroneInheritance("king");
        t2.birth("king", "a");
        t2.birth("king", "b");
        t2.death("king");
        t2.birth("a", "c");
        t2.birth("c", "d");
        t2.birth("d", "e");
        t2.death("a");
        System.out.println(t2.getInheritanceOrder());

        ThroneInheritance t = new ThroneInheritance("king");
        t.birth("king", "andy");
        t.birth("king", "bob");
        t.birth("king", "catherine");
        t.birth("andy", "matthew");
        t.birth("bob", "alex");
        t.birth("bob", "asha");
        System.out.println(t.getInheritanceOrder());
        t.death("bob");
        System.out.println(t.getInheritanceOrder());

    }

    Map<String, Boolean> alive;
    Map<String, LinkedList<String>> family;
    String root;

    public ThroneInheritance(String kingName) {
        root = kingName;
        alive = new HashMap<>();
        family = new HashMap<>();
        family.put(kingName, new LinkedList<>());
        alive.put(kingName, true);
    }

    public void birth(String parentName, String childName) {
        family.get(parentName).add(childName);
        family.put(childName, new LinkedList<>());
        alive.put(childName, true);
    }

    public void death(String name) {
        alive.put(name, false);
    }


    public List<String> getInheritanceOrder() {
        List<String> list = new LinkedList<>();
        dfs(root, list);
        return list;
    }

    private void dfs(String root, List<String> list) {
        if (alive.get(root)) {
            list.add(root);
        }

        if (family.get(root) != null) {
            for (String s : family.get(root)) {
                dfs(s, list);
            }
        }
    }
}

