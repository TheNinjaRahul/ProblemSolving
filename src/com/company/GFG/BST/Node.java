package com.company.GFG.BST;

class Node {
    int data;
    Node left;
    Node right;

    Node() {
    }

    Node(int val) {
        this.data = val;
    }

    Node(int val, Node left, Node right) {
        this.data = val;
        this.left = left;
        this.right = right;
    }


    @Override
    public String toString() {
        return "Node{" +
                "val=" + data +
                '}';
    }
}
