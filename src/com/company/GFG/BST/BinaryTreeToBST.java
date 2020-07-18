package com.company.GFG.BST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTreeToBST {
    public static void main(String[] args) {

    }

    Node binaryTreeToBST(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorderInsertion(list, root);
        Collections.sort(list);
        int low = 0;
        int high = list.size() - 1;
        return getRootNode(low, high, list);
    }

    private static Node getRootNode(int low, int high, ArrayList<Integer> nums) {
        if (low > high) return null;
        int mid = (low + high) / 2;
        Node root = new Node(nums.get(mid));
        root.left = getRootNode(low, mid - 1, nums);
        root.right = getRootNode(mid + 1, high, nums);
        return root;
    }

    private void inorderInsertion(ArrayList<Integer> list, Node root) {
        if (root == null) return;
        inorderInsertion(list, root.left);
        list.add(root.data);
        inorderInsertion(list, root.right);
    }
}
