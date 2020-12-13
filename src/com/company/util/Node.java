package com.company.util;

public class Node {
    public Node left, right;
    public int data;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node left, Node right) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "left=" + left +
                ", right=" + right +
                ", data=" + data +
                '}';
    }
}
