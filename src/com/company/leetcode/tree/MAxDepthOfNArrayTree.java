package com.company.leetcode.tree;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class MAxDepthOfNArrayTree {
    public static void main(String[] args) {

    }

    public int maxDepth(Node root) {
        Queue<Node> q = new LinkedList<>();
        int level = 1;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node temp = q.remove();
                for (Node c : temp.children) {
                    q.add(c);
                }
            }
            level++;
        }
        return level;
    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {

}
