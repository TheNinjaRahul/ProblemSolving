package com.company.GFG.tree;

import java.util.*;

public class BottomView {
    public static void main(String[] args) {
//        Node root = DriverCode.buildTree("1 3 2");
//        System.out.println(bottomView(root));
    }

    public static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Map<Integer, Integer> map = new TreeMap<>();
        getAllVerticalOrder(root, 0, map);

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            list.add(e.getValue());
        }
        return list;
    }

    private static void getAllVerticalOrder(Node root, int vertical, Map<Integer, Integer> map) {
        if (root == null) return;
        map.put(vertical, root.data);
        getAllVerticalOrder(root.left, vertical - 1, map);
        getAllVerticalOrder(root.right, vertical + 1, map);
    }

}
