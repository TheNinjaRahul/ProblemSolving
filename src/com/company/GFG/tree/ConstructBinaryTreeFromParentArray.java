package com.company.GFG.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ConstructBinaryTreeFromParentArray {


    public static void main(String[] args) {
        int[] num = {-1, 0, 0, 1, 1, 3, 5};
        Node root = createTree(num, 7);
        System.out.println("end");
    }

    public static Node root = null;

    public static Node createTree(int arr[], int n) {
        Node created[] = new Node[arr.length];

        for (int i = 0; i < arr.length; i++) {
            creatNode(created, arr, i);
        }
        return root;
    }

    private static void creatNode(Node[] created, int[] arr, int i) {
        if (created[i] != null) return;

        created[i] = new Node(i);

        if (arr[i] == -1) {
            root = created[i];
            return;
        }

        if (created[arr[i]] == null) {
            creatNode(created, arr, arr[i]);
        }

        Node p = created[arr[i]];
        if (p.left == null) {
            p.left = created[i];
        } else {
            p.right = created[i];
        }
    }

    public static Node createTree2(int arr[], int n) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) map.put(arr[i], new LinkedList<>());
            map.get(arr[i]).add(i);
        }

        if (map.containsKey(-1)) {
            Node root = new Node(map.get(-1).get(0));
            root.left = getChild(map.get(-1).get(0), map);
            root.right = getChild(map.get(-1).get(0), map);
            return root;

        }
        return null;

    }

    private static Node getChild(Integer index, Map<Integer, LinkedList<Integer>> map) {
        if (map.containsKey(index)) {
            Node root = new Node(map.get(index).get(0));
            root.left = getChild(map.get(index).get(0), map);
            root.right = getChild(map.get(index).get(0), map);
            if (map.get(index).size() == 1) {
                map.remove(index);
            } else {
                map.get(index).removeFirst();
            }
            return root;
        } else {
            return null;
        }

    }
}
