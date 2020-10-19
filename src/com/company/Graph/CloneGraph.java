package com.company.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    public static void main(String[] args) {

    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap<>();
        Node node1 = new Node(node.val);
        map.put(node.val, node1);

        for (Node n : node.neighbors) {
            if (map.containsKey(n.val)) {
                node1.neighbors.add(map.get(n.val));
            } else {
                node1.neighbors.add(cloneGraph(n, map));
            }
        }

        return node1;
    }

    private Node cloneGraph(Node node, Map<Integer, Node> map) {
        Node node1 = new Node(node.val);
        map.put(node.val, node1);

        for (Node n : node.neighbors) {
            if (map.containsKey(n.val)) {
                node1.neighbors.add(map.get(n.val));
            } else {
                node1.neighbors.add(cloneGraph(n, map));
            }
        }
        return node1;
    }
}
