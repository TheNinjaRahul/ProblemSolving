package com.company.GFG.tree;

import java.util.Stack;

public class ConvertBinaryTreeToDLL {
    public static void main(String[] args) {
        Node root = DriverCode.buildTree("10 20 30 40 60");
        printList(bToDLL(root));

    }

    private static void printList(Node bToDLL) {
        while (bToDLL != null) {
            System.out.print(bToDLL.data + " ");
            bToDLL = bToDLL.right;
        }
    }

    static Node bToDLL(Node root) {
        Stack<Node> stack = new Stack<>();
        getAllNodesInStackInOrder(root, stack);

        Node prev = null;
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            temp.right = prev;
            if (stack.isEmpty()) {
                temp.left = null;
                prev = temp;
            } else {
                temp.left = stack.peek();
                prev = temp;
            }

        }
        return prev;
    }

    private static void getAllNodesInStackInOrder(Node root, Stack<Node> stack) {
        if (root == null) return;
        getAllNodesInStackInOrder(root.left, stack);
        stack.push(root);
        getAllNodesInStackInOrder(root.right, stack);
    }
}
