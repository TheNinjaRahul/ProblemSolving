package com.company.GFG.tree;

public class AVLTree {
    static class Node {
        int data;
        Node left;
        Node right;
        int height;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    ", height=" + height +
                    '}';
        }
    }

    public static void main(String[] args) {
        Node root = null;
        int []data= {5 ,1 ,4};
//        int[] data = {1, 2, 3};
//        int[] data = {1, 2, 3, 6, 5, -2, -5, -8};
//        int[] data = {5, 67, 33, 32, 11};
        for (int i : data) {
            root = insertToAVL(root, i);
        }
        System.out.println(root);
    }


    public static Node insertToAVL(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else if (node.data > data) {
            node.left = insertToAVL(node.left, data);
        } else if (node.data < data) {
            node.right = insertToAVL(node.right, data);
        }
        if ((Math.abs(balance(node)) > 1)) {
            node = fixNode(node, data);
        }
        return node;
    }

    private static int balance(Node node) {
        if (node==null) return 0;
        return getBalance(node.left) - getBalance(node.right);
    }

    private static Node fixNode(Node node, int data) {
        if (balance(node) < -1) {
            int rightmost = getBalance(node.right.right);// != null ? node.right.right.height : 0;
            int rightsleft = getBalance(node.right.left);// != null ? node.right.left.height : 0;
            if (rightmost >= rightsleft) {
                node = rotateLeft(node);
            } else {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }

        if (balance(node) > 1) {
            int leftMost = balance(node.left.left);// != null ? node.left.left.height : -1;
            int leftsright = getBalance(node.left.right);// != null ? node.left.right.height : 0;
            if (leftMost >= leftsright) {
                node = rotateRight(node);
            } else {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        }
        return node;
    }

    private static Node rotateRight(Node root) {
        Node temp = root.left;
        root.left = temp.right;
        temp.right = root;
        temp.height = balance(temp);
        root.height = balance(root);
        return temp;
    }

    private static Node rotateLeft(Node root) {
        Node temp = root.right;
        root.right = temp.left;
        temp.left = root;
        temp.height = balance(temp);
        root.height = balance(root);
        return temp;
    }

    private static int getBalance(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return Math.max(getBalance(node.left), getBalance(node.right)) + 1;
    }
}
