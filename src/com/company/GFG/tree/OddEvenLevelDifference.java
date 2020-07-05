package com.company.GFG.tree;

import java.util.LinkedList;
import java.util.Queue;

public class OddEvenLevelDifference {
    public static void main(String[] args) {

    }

    int getLevelDiff(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int odd = 0, even = 0;
        boolean isOdd = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node temp = queue.remove();
                if (isOdd) {
                    odd += temp.data;
                } else {
                    even += temp.data;
                }
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            isOdd = !isOdd;
        }
        return even-odd;
    }
}
