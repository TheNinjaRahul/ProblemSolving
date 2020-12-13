package com.company.leetcode.AmazonPractice;

import com.company.util.Node;

public class IsTreeIsomorphic {
    public static void main(String[] args) {
        Node root1 = new Node(1, new Node(2, new Node(4), null), new Node(3));
        Node root2 = new Node(1, new Node(3), new Node(2, null, new Node(4)));
        System.out.println(isIsomorphic(root1, root2));
    }


    public static boolean isIsomorphic(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null && root2 != null) return false;
        if (root1 != null && root2 == null) return false;

        if (root1.data == root2.data) {
            return isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left);
        } else {
            return false;
        }
    }
}
