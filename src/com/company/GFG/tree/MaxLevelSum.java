package com.company.GFG.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {
    public static void main(String[] args) {

    }

    public int maxLevelSum(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean isAllLeaf = false;
        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                Node temp = queue.remove();
                sum += temp.data;
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
