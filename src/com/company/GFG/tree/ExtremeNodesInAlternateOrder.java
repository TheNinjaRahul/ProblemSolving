package com.company.GFG.tree;

import java.util.LinkedList;
import java.util.Queue;

public class ExtremeNodesInAlternateOrder {
    public static void main(String[] args) {

    }

    public void printExtremeNode(Node node) {
        if(node==null) return;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(node);
        boolean rightMost=true;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int  i=0;i<size;i++){
                Node temp=queue.poll();
                if(temp.left!=null) queue.offer(temp.left);
                if(temp.right!=null) queue.offer(temp.right);
                if(rightMost && i==size-1){
                    System.out.print(temp.data+" ");
                }
                if(!rightMost && i==0){
                    System.out.print(temp.data+" ");
                }
            }
            rightMost=!rightMost;
        }
    }
}
