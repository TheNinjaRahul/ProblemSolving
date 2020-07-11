package com.company.GFG.tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertLinkListToArray {
    public static void main(String[] args) {

    }

    public static class Tree {
        int data;
        Tree left;
        Tree right;

        Tree(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Tree convert(Node head, Tree node) {
        Tree root = new Tree(head.data);
        Queue<Tree> q = new LinkedList<>();
        q.add(root);
        head = head.next;
        while (!q.isEmpty() && head != null) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Tree temp = q.remove();
                Tree left = null;
                Tree right = null;

                if (head != null) {
                    left = new Tree(head.data);
                } else {
                    return root;
                }
                temp.left = left;
                head = head.next;
                if (head != null) {
                    right = new Tree(head.data);
                } else {
                    return root;
                }
                temp.right = right;

                head = head.next;

                q.add(left);
                q.add(right);
            }
        }

        return root;
    }
}
