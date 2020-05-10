package com.company.BTree;

import java.util.*;

public class LevelOrder {
    public static void main(String[] args) {
        BTREE btree = new BTREE();
        btree.add(3);
        btree.add(2);
        btree.add(5);
        btree.add(1);
        btree.add(4);
        btree.add(6);
        btree.add(7);
        btree.add(8);

        topView(btree.root);


    }

    public static void topView(BTreeNode root) {

        Queue<LevelOrderNode> queue = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>();
        LevelOrderNode lnode = new LevelOrderNode(root, 0);
        if (root != null) {
            queue.add(lnode);
        }

        while (!queue.isEmpty()) {

            lnode = queue.poll();
            if (!map.containsKey(lnode.level)) {
                map.put(lnode.level, lnode.node.data);
            }

            if (lnode.node.left != null) {
                LevelOrderNode left = new LevelOrderNode(lnode.node.left, lnode.level - 1);
                queue.add(left);
            }
            if (lnode.node.right != null) {
                LevelOrderNode right = new LevelOrderNode(lnode.node.right, lnode.level + 1);
                queue.add(right);
            }

        }


        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            System.out.print(e.getValue()+" ");

        }
    }

    private static void printqueue(Queue<BTreeNode> queue) {
        while (queue.isEmpty()) {
            System.out.println(queue.poll().data);
        }
    }

    private static String levelOrder(Queue<BTreeNode> queue, BTreeNode root, String s) {
        if (root == null || queue.isEmpty()) {
            return s;
        }
        if (root.left != null)
            queue.add(root.left);
        if (root.right != null)
            queue.add(root.right);

//        System.out.println(queue.peek().data);
        s += " " + String.valueOf(queue.peek().data);
        levelOrder(queue, queue.poll(), s);
        return s;
    }
}

class LevelOrderNode {
    BTreeNode node;
    int level;

    public LevelOrderNode(BTreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}