package com.company.GFG.tree;

import java.util.ArrayList;

public class BoundaryTraversal {
    public static void main(String[] args) {
        Node root = DriverCode.buildTree("10 20 30 40 60");
        System.out.println(printBoundary(root));

    }

    static ArrayList<Integer> printBoundary(Node node) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (node == null) return list;
        list.add(node.data);
        getAllLeft(list, node.left);
//        System.out.println(list);
        getAllLeafNode(list, node.left);
        getAllLeafNode(list, node.right);
//        System.out.println(list);
        getAllRight(list, node.right);
//        System.out.println(list);
        return list;
    }

    private static void getAllRight(ArrayList<Integer> list, Node right) {
        if (right == null) return;
        if (right.left == null && right.right == null) return;
        if (right.right != null) {
            getAllRight(list, right.right);
        }else {
            getAllRight(list,right.left);
        }
        list.add(right.data);
        return;
    }

    private static void getAllLeafNode(ArrayList<Integer> list, Node node) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            list.add(node.data);
            return;
        }
        getAllLeafNode(list, node.left);
        getAllLeafNode(list, node.right);
    }

    private static void getAllLeft(ArrayList<Integer> list, Node left) {
        if (left == null || (left.left == null && left.right == null)) return;
        list.add(left.data);
        if (left.left != null) {
            getAllLeft(list, left.left);
        }else {
            getAllLeft(list,left.right);
        }
        return;
    }
}
