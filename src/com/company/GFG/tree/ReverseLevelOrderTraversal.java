package com.company.GFG.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseLevelOrderTraversal {
    public static void main(String[] args) {

    }

    public void reversePrint(Node node) {
        LinkedList<List<Integer>> list = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            List<Integer> mini = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();
                mini.add(temp.data);
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            list.addFirst(mini);
        }

        for (List<Integer> l : list) {
            for (Integer i : l) {
                System.out.print(l + " ");
            }
        }
    }
}
