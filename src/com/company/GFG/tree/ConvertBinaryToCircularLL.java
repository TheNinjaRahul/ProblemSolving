package com.company.GFG.tree;

import java.util.Stack;

public class ConvertBinaryToCircularLL {
    public static void main(String[] args) {

    }

    Node bTreeToClist(Node root) {
        Stack<Node> stack = new Stack<>();
        getAllNodesInStackInOrder(root, stack);

        Node last = null;
        Node first = null;
        while (!stack.isEmpty()) {
            Node temp = stack.pop();

            if (last == null) {
                last = temp;
            }

            temp.right = first;
            if (stack.isEmpty()) {
                temp.left = null;
                first = temp;
            } else {
                temp.left = stack.peek();
                first = temp;
            }
        }
        first.left = last;
        last.right = first;
        return first;
    }

    private static void getAllNodesInStackInOrder(Node root, Stack<Node> stack) {
        if (root == null) return;
        getAllNodesInStackInOrder(root.left, stack);
        stack.push(root);
        getAllNodesInStackInOrder(root.right, stack);
    }
}
