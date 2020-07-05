package com.company.GFG.tree;

import java.util.*;

public class IsCousins {

    public static void main(String[] args) {
//        String s = "1 2 5 8 3 N 7 9 N N 4 N N N N 6";
//        Node root = DriverCode.buildTree(s);
//        System.out.println(isCousins2(root, 9, 4));
    }


    public static boolean isCousins2(Node root, int x, int y) {
        Map<Integer, Integer> levelMap = new HashMap<>();
        Map<Integer, Node> parentMap = new HashMap<>();

        dfs(root, null, levelMap, parentMap);

//        System.out.println(levelMap);
//        System.out.println(parentMap);
        if (levelMap.get(x) == levelMap.get(y) && parentMap.get(x) != parentMap.get(y)) {
            return true;
        }
        return false;
    }

    private static void dfs(Node root, Node parent, Map<Integer, Integer> levelMap, Map<Integer, Node> parentMap) {
        if (root == null) return;
        int parentLevel = parent == null ? 0 : levelMap.get(parent.data);
        levelMap.put(root.data, parentLevel + 1);
        parentMap.put(root.data, parent);
        dfs(root.left, root, levelMap, parentMap);
        dfs(root.right, root, levelMap, parentMap);
    }

    public static boolean isCousins(Node root, int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int bros = 2;
        while (!queue.isEmpty()) {
            int count = queue.size();
            bros = 2;
            for (int i = 0; i < count; i++) {
                Node temp = queue.remove();
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
                if (temp.data == x || temp.data == y) {
                    bros--;
                }
            }
            if (bros == 0) {
                break;
            }
        }
        if (bros != 0) return false;
        Node pa = findParent(root, x);
        Node pb = findParent(root, y);
        System.out.println(pa.data + " " + pb.data);
        return pa != pb;
    }

    private static Node findParent(Node root, int x) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return null;
        if (root.left != null && root.left.data == x) return root;
        if (root.right != null && root.right.data == x) return root;

        Node left = findParent(root.left, x);
        Node right = findParent(root.right, x);
        if (left == null && right == null) return null;
        if (left != null) {
            return left;
        } else {
            return right;
        }
    }

}
