package com.company.GFG.tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsAllLeafNodesAreAtSameLevel {
    public static void main(String[] args) {

    }

    boolean check(Node root)
    {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean isAllLeaf = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int leaf=0,parent=0;
            for (int i = 0; i < size; i++) {
                Node temp = queue.remove();

                if(temp.left==null && temp.right==null) {
                   leaf++;
                }else{
                    parent++;
                }
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            if(parent==0) return true;
        }
        return false;
    }


}
