package com.company.GFG.tree;

import java.util.*;

import com.company.util.Node;
public class ZigZagTraversal {
    public static void main(String[] args) {
//        Node root=DriverCode.buildTree("3 2 1");
//        System.out.println(zigZagTraversal(root));
    }

    static ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.add(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                Node temp = s1.pop();
                list.add(temp.data);
                if (temp.left != null) s2.push(temp.left);
                if (temp.right != null) s2.add(temp.right);
            }

            while (!s2.isEmpty()) {
                Node temp = s2.pop();
                list.add(temp.data);
                if (temp.right != null) s1.add(temp.right);
                if (temp.left != null) s1.push(temp.left);
            }
        }
        return list;
    }

}
