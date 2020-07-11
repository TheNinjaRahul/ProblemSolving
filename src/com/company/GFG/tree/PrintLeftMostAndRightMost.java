package com.company.GFG.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLeftMostAndRightMost {
    public static void main(String[] args) {

    }

    public static void printCorner(Node root) {
        {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            int max = Integer.MIN_VALUE;

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node temp = queue.remove();
                    if(i==0 || i==size-1){
                        System.out.print(temp.data+" ");
                    }
                    if (temp.left != null) queue.add(temp.left);
                    if (temp.right != null) queue.add(temp.right);
                }
            }
        }
    }

}
