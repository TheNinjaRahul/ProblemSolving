package com.company.GFG.BST;

public class IsBST {
    public static void main(String[] args) {
        Node root = DriverCode.buildTree("3 2 5 1 4");
        System.out.println(isBST(root));
    }


    static boolean isBST(Node root) {
        if (root == null) return true;
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBSTUtil(Node root, int minValue, int maxValue) {
        if (root == null) return true;

        if (root.data < minValue || root.data > maxValue) {
            return false;
        }

        return isBSTUtil(root.left, minValue, root.data) && isBSTUtil(root.right, root.data, maxValue);
    }

    static boolean isBST2(Node root) {
        if (root == null) return true;
        boolean left = false, right = false;

        left = checkIfAllNodesSmallers(root.left, root.data);
        right = checkIfAllNodesBigger(root.right, root.data);
        if (left && right) {
            return isBST(root.left) && isBST(root.right);
        }
        return false;
    }

    private static boolean checkIfAllNodesBigger(Node root, int data) {
        if (root == null) return true;
        if (root.data >= data) {
            return checkIfAllNodesBigger(root.left, data) && checkIfAllNodesBigger(root.right, data);
        }
        return false;
    }

    private static boolean checkIfAllNodesSmallers(Node root, int data) {
        if (root == null) return true;
        if (root.data <= data) {
            return checkIfAllNodesSmallers(root.left, data) && checkIfAllNodesSmallers(root.right, data);
        }
        return false;
    }
}
