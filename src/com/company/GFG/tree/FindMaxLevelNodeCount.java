package com.company.GFG.tree;

import java.util.*;

public class FindMaxLevelNodeCount {
    public static void main(String[] args) {

    }

    public static int maxNodeLevel(Node root) {
//        List<List<Integer>> output=new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int max = 0;
        int level = 0;
        while (!queue.isEmpty()) {
            int currentCout = queue.size();
            List<Node> list = new ArrayList<>();
            for (int i = 0; i < currentCout; i++) {
                Node temp = queue.remove();
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
                list.add(temp);
            }
            if (max < list.size()) {
                max = list.size();
            }
//            map.put(level++,list);
        }
        return max;
    }
}
