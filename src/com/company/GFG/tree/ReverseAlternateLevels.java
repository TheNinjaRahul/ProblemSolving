package com.company.GFG.tree;
import com.company.util.Node;

public class ReverseAlternateLevels {
    public static void main(String[] args) {
        Node root = DriverCode.buildTree("10 20 30 40 50 60 70 80 90 100 110 120 130 140 150");
        reverseAlternate(root);
//        TreeUtil.inOrderTraversal(root);
    }

    static void reverseAlternate(Node root) {
        if (root == null) return;
        changeOrder(root.left, root.right, 0);
    }

    private static void changeOrder(Node root1, Node root2, int level) {
        if (root1 == null && root2 == null) {
            return;
        }
        if (level % 2 == 0) {
            swap(root1, root2);
        }
        changeOrder(root1.left, root2.right, level + 1);
        changeOrder(root1.right, root2.left, level + 1);
    }

    private static void swap(Node root1, Node root2) {
        int temp = root1.data;
        root1.data = root2.data;
        root2.data = temp;
    }
}
