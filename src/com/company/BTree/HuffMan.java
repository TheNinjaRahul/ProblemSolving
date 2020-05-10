package com.company.BTree;

public class HuffMan {
    public static void main(String[] args) {

    }
    void decode(String s, BTreeNode root) {
        BTreeNode temp=root;
        for(int i=0;i<s.length();i++){
            if(temp.left==null && temp.right==null){
                System.out.print(temp.data);
                temp=root;
            }
            if(s.charAt(i)=='0'){
                temp=temp.left;
            }
            else {
                temp=temp.right;
            }
        }

    }

}
