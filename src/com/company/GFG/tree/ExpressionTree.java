package com.company.GFG.tree;

public class ExpressionTree {
    public static void main(String[] args) {


    }

    public static int evalTree(Node root) {
        if (root.left == null && root.right == null) return Integer.parseInt(root.data);

        switch (root.data) {
            case "+":
                return evalTree(root.left) + evalTree(root.right);
            case "-":
                return evalTree(root.left) - evalTree(root.right);
            case "/":
                return evalTree(root.left) / evalTree(root.right);
            case "*":
                return evalTree(root.left) * evalTree(root.right);
        }

        return 0;
    }


    class Node {
        String data;
        Node left, right;

        Node(String data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
