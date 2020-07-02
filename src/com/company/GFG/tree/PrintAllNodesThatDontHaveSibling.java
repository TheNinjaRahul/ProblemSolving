package com.company.GFG.tree;

import java.util.ArrayList;
import java.util.List;

public class PrintAllNodesThatDontHaveSibling {
    public static void main(String[] args) {

    }

    void printSibling(Node node) {
        List<Integer> list = new ArrayList<>();
        getAll(node, list);
        if (list.size() == 0) System.out.print("-1");
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }

    private void getAll(Node node, List<Integer> list) {
        if (node == null) return;
        if(node.left!=null && node.right!=null){
            getAll(node.left, list);
            getAll(node.right, list);
        }else if (node.left != null) {
            list.add(node.left.data);
            getAll(node.left,list);
        }else if(node.right != null){
            list.add(node.right.data);
            getAll(node.right,list);
        }

    }


}
