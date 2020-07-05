package com.company.GFG.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConnectNodesAtSameLevel {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        connect(n1);
        System.out.println(n1);
    }

    static class Node {
        int data;
        Node left;
        Node right;
        Node nextRight;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
            nextRight = null;
        }
    }

    public static void connect(Node p) {
        if(p==null) return;
        connect(p.left);
        connect(p.right);
        connect(p.left,p.right);
    }

    private static void connect(Node left, Node right) {
        while(left!=null){
            left.nextRight=right;
            left=left.right;
            right=right.left;
        }
    }


    public static void connect2(Node p) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(p);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();
                temp.nextRight = i+1==size?null : queue.peek();
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
        }
    }
}
