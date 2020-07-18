package com.company.GFG.BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PrintCommonNodesInTwoBST {
    public static void main(String[] args) {

    }

    public static ArrayList<Integer> printCommon(Node root1, Node root2) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root1);
        s2.push(root2);
        while (!s1.isEmpty() && !s2.isEmpty()) {

            if (root1 != null) {
                s1.push(root1);
                root1 = root1.left;
            } else if (root2 != null) {
                s2.push(root2);
                root2 = root2.left;
            } else if (!s1.isEmpty() && !s2.isEmpty()) {
                root1 = s1.peek();
                root2 = s2.peek();

                if (root1.data == root2.data) {
                    list.add(root1.data);
                    s1.pop();
                    s2.pop();
                    root1 = root1.right;
                    root2 = root2.right;
                } else if (root1.data < root2.data) {
                    s1.pop();
                    root1 = root1.right;
                    root2 = null;
                } else if (root1.data > root2.data) {
                    s2.pop();
                    root2 = root2.right;
                    root1 = null;
                } else break;
            }
        }
        return list;
    }


    public static ArrayList<Integer> printCommon2(Node root1, Node root2) {
        List<Integer> t1 = new LinkedList<>();
        List<Integer> t2 = new LinkedList<>();

        inorder(t1, root1);
        inorder(t2, root2);

        ArrayList<Integer> list = new ArrayList<>();

        int i = 0, j = 0, m = t1.size(), n = t2.size();

        while (t1.size() != 0 && t2.size() != 0) {
            if (t1.get(0) == t2.get(0)) {
                list.add(t1.get(0));
                t1.remove(0);
                t2.remove(0);
            } else if (t1.get(0) <= t2.get(0)) {
                t1.remove(0);
            } else {
                t2.remove(0);
            }
        }

        return list;
    }

    private static void inorder(List<Integer> list, Node root) {
        if (root == null) return;
        inorder(list, root.left);
        list.add(root.data);
        inorder(list, root.right);
    }
}
