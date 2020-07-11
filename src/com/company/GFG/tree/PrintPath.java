package com.company.GFG.tree;

public class PrintPath {
    public static void main(String[] args) {
        Node root=DriverCode.buildTree("10 20 30 40 60");
        printPaths(root);
    }

    public static void printPaths(Node root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            System.out.println(root.data);
        }

        String s = String.valueOf((root.data))+" ";
        printPath(root.left, s);
        printPath(root.right, s);
    }

    private static void printPath(Node root, String s) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            s += root.data;
            System.out.print(s+" #");
        }
        s += ( root.data+" " );
        printPath(root.left, s);
        printPath(root.right, s);
    }
}
