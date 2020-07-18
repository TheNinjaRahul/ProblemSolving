package com.company.GFG.BST;

public class FixBinaryTree {
    public static void main(String[] args) {
        Node root = DriverCode.buildTree("10 5 8 2 20");
        FixBinaryTree f = new FixBinaryTree();
        System.out.println(root);
        f.correctBST(root);
        System.out.println(root);

    }


    Node firstNode = null, lastNode = null, prev = null;

    public Node correctBST(Node root) {
        findPair(root);
        int temp = firstNode.data;
        firstNode.data = lastNode.data;
        lastNode.data = temp;
        return root;
    }

    private void findPair(Node root) {
        if (root == null) return;
        findPair(root.left);
        if (prev != null) {
            if (prev.data > root.data) {
                if (firstNode == null) {
                    firstNode = prev;
                }
                lastNode = root;
            }
        }
        prev = root;
        findPair(root.right);
    }
}
