package com.company.GFG.BST;


import javax.swing.*;
import java.sql.Driver;
import java.sql.DriverAction;


public class BST {

    public static void main(String[] args) {
        Node root = DriverCode.buildTree("2 1 3 N N N N");
        System.out.println(deleteNode(root, 12));

    }

    Node insert(Node root, int Key) {
        if (root == null) {
            root = new Node(Key);
        } else if (root.data > Key) {
            root.left = insert(root.left, Key);
        } else if (root.data < Key) {
            root.right = insert(root.right, Key);
        }
        return root;
    }


    /**
     * case 1:
     * Leaf Node
     * case 2: one child present
     * case 3: two child present then replace deleted node with inorder successor of that node
     *
     * @param root
     * @param X
     * @return
     */

    public static Node deleteNode(Node root, int X) {
        if (root == null) return root;
        if (root.data == X) {
            //check case 1
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.right == null || root.left == null) {
                return root.right == null ? root.left : root.right;
            } else {
                root.data = inOrderSuccessor(root.right);
                root.right = deleteNode(root.right, root.data);
                return root;
            }
        }
        if (root.data < X) {
            root.right = deleteNode(root.right, X);
        } else {
            root.left = deleteNode(root.left, X);
        }

        return root;
    }

    private static int inOrderSuccessor(Node root) {
        if (root.left == null && root.right == null) return root.data;
        return root.left != null ? inOrderSuccessor(root.left) : root.data;
    }
}
