package com.company.GFG.BST;

public class LargestBST {
    public static void main(String[] args) {

        Node root5=DriverCode.buildTree("1 1 6");
        System.out.println(largestBst(root5));

        Node root4 = DriverCode.buildTree("8 11 1 10 N 1 6 9 4");
        System.out.println(largestBst(root4));

        Node root3 = DriverCode.buildTree("7 4 6 N 9");
        System.out.println(largestBst(root3));

        Node root2 = DriverCode.buildTree("1 4 4 6 8");
        System.out.println(largestBst(root2));
        Node root = DriverCode.buildTree("6 6 3 N 2 9 3 N 8 8 2");
        System.out.println(largestBst(root));
    }


    static class MyClass {
        int max;
    }

    static int largestBst(Node root) {
        MyClass my = new MyClass();
        getLargeBST(root, my);
        return my.max;
    }

    private static void getLargeBST(Node root, MyClass my) {
        if (root == null) return;
        if (isBST(root)) {
            int left = getNodeCount(root.left);
            int right = getNodeCount(root.right);
            my.max = Math.max(my.max, left + right + 1);
        }
        getLargeBST(root.left, my);
        getLargeBST(root.right, my);
    }

    private static int getNodeCount(Node root) {
        if (root == null) return 0;
        return 1 + getNodeCount(root.left) + getNodeCount(root.right);
    }


    static boolean isBST(Node root) {
        if (root == null) return true;
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBSTUtil(Node root, int minValue, int maxValue) {
        if (root == null) return true;

        if (root.data <= minValue || root.data >= maxValue) {
            return false;
        }

        return isBSTUtil(root.left, minValue, root.data) && isBSTUtil(root.right, root.data, maxValue);
    }


}
