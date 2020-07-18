package com.company.GFG.BST;

import java.util.HashSet;
import java.util.Set;

public class IsPairPresent {
    public static void main(String[] args) {

    }


    public int isPairPresent(Node root, int k) {
        Set<Integer> list = new HashSet<>();
        inorder(root, list);
        for (Integer i : list) {
            if (list.contains(k - i) && k - i != i) {
                return 1;
            }
        }
        return 0;
    }

    private void inorder(Node root, Set<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
}
