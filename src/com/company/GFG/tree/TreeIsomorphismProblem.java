package com.company.GFG.tree;

public class TreeIsomorphismProblem {

    public static void main(String[] args) {

    }

    boolean isIsomorphic(Node root1, Node root2)
    {
        if(root1==null && root2==null) return true;
        if(root1==null && root2!=null) return false;
        if(root2==null && root1!=null) return false;

        if(root1.data==root2.data){
            return (isIsomorphic(root1.left,root2.left) && isIsomorphic(root1.right,root2.right)) ||(isIsomorphic(root1.left,root2.right) && isIsomorphic(root1.right,root2.left));
        }
        return false;
    }
}
