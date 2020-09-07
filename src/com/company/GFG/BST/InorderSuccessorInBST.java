package com.company.GFG.BST;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class  InorderSuccessorInBST {
    public static void main(String[] args) {

        Node root3 = DriverCode.buildTree("45 17 58 7 26 57 69 6 8");
        System.out.println("8" + inorderSuccessor(root3, new Node(7)));


        Node root1 = DriverCode.buildTree("20 8 22 4 12 N N N N 10 14");
        System.out.println("10" + inorderSuccessor(root1, new Node(8)));

        Node root2 = DriverCode.buildTree("15 10 16 1 14 N 81 N 8 12 N 63 94");
        System.out.println("15" + inorderSuccessor(root2, new Node(14)));

    }


    static class myclass {
        boolean found = false;
        Node lastLeftNode = new Node(-1);
    }


    public static Node inorderSuccessor(Node root, Node x) {
        if (root == null) return new Node(-1);

        Stack<Node> stack = new Stack<>();
//        stack.push(root);
        while (!stack.isEmpty() || root != null) {

            if (root == null) {
                root = stack.pop();
                if (root.data > x.data) {
                    return root;
                } else {
                    root = root.right;
                }
            } else if (root.left != null) {
                stack.push(root);
                root = root.left;
                continue;
            } else if (root.data > x.data) {
                return root;
            } else {
                root = root.right;
            }
        }
        return new Node(-1);

    }

    public static Node inorderSuccessor3(Node root, Node x) {
        myclass output = new myclass();
        getRecInSuc(root, x, output);
        return output.lastLeftNode;
    }

    private static void getRecInSuc(Node root, Node x, myclass output) {
        if (root == null) return;
        Node temp = new Node(-1);
        while (root != null) {
            if (root.data < x.data) {
                root = root.right;
            } else if (root.data > x.data) {
                temp = root;
                root = root.left;
                if (output.found = true) {
                    output.lastLeftNode = temp;
                    output.found = false;
                    return;
                }
            } else if (root.data == x.data) {
                output.found = true;
                return;
            }
        }


    }


    public static Node inorderSuccessor2(Node root, Node x) {
        myclass output = new myclass();
        getInSuc(root, x, output);
        return output.lastLeftNode;
    }

    public static void getInSuc(Node root, Node x, myclass output) {

        Node foundtarget = findTargetNode(root, x);

        if (foundtarget.right != null) {
            Node n = findInorderSuc(foundtarget.right);
            output.lastLeftNode = n;
            output.found = true;
            return;

        } else {
            if (output.found) return;
            findLastLeftParent(root, x, output);
        }
    }

    private static Node findTargetNode(Node root, Node x) {
        if (root == null) return null;
        if (root.data == x.data) {
            return root;
        } else if (root.data < x.data) {
            return findTargetNode(root.right, x);
        } else {
            return findTargetNode(root.left, x);
        }
    }

    private static void findLastLeftParent(Node root, Node x, myclass node) {
        if (root == null) return;
        if (root.data > x.data) {
            node.lastLeftNode = root;
            findLastLeftParent(root.left, x, node);
        } else if (root.data < x.data) {
            findLastLeftParent(root.right, x, node);
        } else if (root.data == x.data) {
            node.found = true;
            return;
        }
    }

    private static Node findInorderSuc(Node foundtarget) {
        if (foundtarget == null) return null;
        if (foundtarget.left != null) {
            return findInorderSuc(foundtarget.left);
        }
        return foundtarget;
    }
}
