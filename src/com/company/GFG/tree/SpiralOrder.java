package com.company.GFG.tree;

import java.util.Deque;
import java.util.LinkedList;

public class SpiralOrder {
    public static void main(String[] args) {
//        Node root=DriverCode.buildTree("1 2 3 4 5 6 7");
//        printSpiral(root);
    }
    public static void printSpiral(Node node)
    {
        Deque<Node> queue=new LinkedList<>();
        queue.offer(node);
        boolean rightToLeft=true;
        while(!queue.isEmpty()){
            if(rightToLeft){
                int size= queue.size();
                for(int i=0;i<size;i++){
                    Node temp=queue.pollLast();
                    System.out.print(temp.data+" ");
                    if(temp.right!=null) queue.addFirst(temp.right);
                    if(temp.left!=null) queue.addFirst(temp.left);
                }
            }else {
                int size= queue.size();
                for(int i=0;i<size;i++){
                    Node temp=queue.pollFirst();
                    System.out.print(temp.data+" ");
                    if(temp.left!=null) queue.addLast(temp.left);
                    if(temp.right!=null) queue.addLast(temp.right);
                }
            }
            rightToLeft=!rightToLeft;
        }
    }
}
