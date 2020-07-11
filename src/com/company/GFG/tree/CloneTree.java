package com.company.GFG.tree;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class CloneTree {
    public static void main(String[] args) {

    }

    static class Tree {
        int data;
        Tree left, right, random;

        Tree(int d) {
            data = d;
            left = null;
            right = null;
            random = null;
        }
    }

    public static Tree cloneTree(Tree tree) {
        Map<Tree, Tree> map = new HashMap<>();
        Tree clone = cloneNodes(tree, map);
        cloneRandoms(tree, clone, map);
        return clone;
    }

    private static void cloneRandoms(Tree tree, Tree clone, Map<Tree, Tree> map) {
        if (tree == null || clone == null) return;
        if (map.get(tree) != null) {
            clone.random = map.get(tree.random);
        }
        cloneRandoms(tree.left, clone.left, map);
        cloneRandoms(tree.right, clone.right, map);
    }

    private static Tree cloneNodes(Tree tree, Map<Tree, Tree> map) {
        if (tree == null) return null;
        Tree clone = new Tree(tree.data);
        map.put(tree, clone);
        clone.left = cloneNodes(tree.left, map);
        clone.right = cloneNodes(tree.right, map);
        return clone;
    }
}
