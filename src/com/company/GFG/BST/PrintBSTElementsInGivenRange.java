package com.company.GFG.BST;

import java.util.ArrayList;

public class PrintBSTElementsInGivenRange {
    public static void main(String[] args) {

        Node root2 = DriverCode.buildTree("17 4 18 2 9");
        System.out.println(printNearNodes(root2, 4, 24));

        Node root = DriverCode.buildTree("9 4 18 1 6 17 19 N 3 5 7");
        System.out.println(printNearNodes(root, 13, 23));

    }

    public static ArrayList<Integer> printNearNodes(Node root, int low, int high) {
        ArrayList<Integer> list = new ArrayList<>();

        getAllInRange(root, low, high, list);

        return list;
    }


    private static void getAllInRange(Node root, int low, int high, ArrayList<Integer> list) {
        if (root == null) return;

        if (root.data > low) {
            getAllInRange(root.left, low, high, list);
        }
        if (root.data >= low && root.data <= high) {
            list.add(root.data);
        }
        if (root.data <= high) {
            getAllInRange(root.right, low, high, list);
        }

    }
}

