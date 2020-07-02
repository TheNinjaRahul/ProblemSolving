package com.company.GFG.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalLineByLine {
    public static void main(String[] args) {

    }

    static void levelOrder(Node node)
    {
        if(node==null) return;
        Queue<Node> queue=new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            int size=queue.size();

            for(int i=0;i<size;i++){
                Node temp=queue.remove();
                if(temp.right!=null) queue.add(temp.right);
                if(temp.left!=null) queue.add(temp.left);
                System.out.print(temp.data+" ");
            }
            System.out.print("$ ");
        }
    }
}
