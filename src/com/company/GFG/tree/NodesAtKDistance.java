package com.company.GFG.tree;

import java.util.*;

public class NodesAtKDistance {
    public static void main(String[] args) {
        Node root=DriverCode.buildTree("20 8 22 4 12 N N N N 10 14");
        System.out.println(KDistanceNodes(root,8,2));

    }

    public static ArrayList<Integer> KDistanceNodes(Node root, int t, int K) {
        ArrayList<Integer> list = new ArrayList<>();

        if (root == null || K < 0) return list;
        if (K == 0) {
            list.add(t);
            return list;
        }
        Map<Node, Node> parentMap = new HashMap<>();
        getAllParent(root, parentMap);
//        getAllParent(root.right, parentMap);xx
        Set<Node> set = new HashSet<>();
        int level = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.data-o2.data;
            }
        });
        Node target = findTarget(root, t);
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
            if (level + 1 == K) {
                while (!queue.isEmpty()) {
                    list.add(queue.poll().data);
                }
            }
            level++;
        }
        return list;
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
