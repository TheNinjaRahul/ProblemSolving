package com.company.GFG.tree;

import java.util.*;

public class BurningTree {
    public static void main(String[] args) {
        Node root = DriverCode.buildTree("1 2 3 4 5 N 7 8 N 10");
        System.out.println(minTime(root, 10));

        Node root2 = DriverCode.buildTree("1 2 3 4 5 N 6 N N 7 8 N 9 N N N N N 10");
        System.out.println(minTime(root2, 8));
    }

    public static int minTime(Node root, int t) {
        int[] ret = {0};
        traverse(root, t, ret);
        return ret[0];
    }

    private static int traverse(Node root, int t, int[] ret) {

        if (root == null) return 0;
        if (root.data == t) return 1;
        return 0;

    }

    public static int minTime2(Node root, int t) {
        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) return 0;

        Map<Node, Node> parentMap = new HashMap<>();
        getAllParent(root, parentMap);
//        getAllParent(root.right, parentMap);
        Set<Node> set = new HashSet<>();

        Queue<Node> queue = new LinkedList<>();
        Node target = findTarget(root, t);
        int count = 0;
        set.add(target);
        queue.add(target);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node temp = queue.remove();
                if (temp.left != null && !set.contains(temp.left)) {
                    queue.add(temp.left);
                    set.add(temp.left);
                }
                if (temp.right != null && !set.contains(temp.right)) {
                    queue.add(temp.right);
                    set.add(temp.right);
                }
                if (parentMap.get(temp) != null && !set.contains(parentMap.get(temp))) {
                    queue.add(parentMap.get(temp));
                    set.add(parentMap.get(temp));
                }
            }
            count++;
        }
        return count - 1;
    }

    private static Node findTarget(Node root, int target) {
        if (root == null) return null;
        if (root.data == target) return root;
        Node left = findTarget(root.left, target);
        Node right = findTarget(root.right, target);
        return left != null ? left : right;
    }

    private static void getAllParent(Node root, Map<Node, Node> map) {
        if (root == null) return;
        if (root.left != null) map.put(root.left, root);
        if (root.right != null) map.put(root.right, root);
        getAllParent(root.left, map);
        getAllParent(root.right, map);
    }

}
