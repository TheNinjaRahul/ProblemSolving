package com.company.GFG.Array;

import java.util.ArrayList;

public class UniounOfTwoArray {
    public static void main(String[] args) {
        int data[] = {2, 2, 3, 4, 5};
        int data2[] = {1, 1, 2, 3, 4};
        System.out.println(findUnion(data,data2,data.length,data2.length));
    }

    public static ArrayList<Integer> findUnion(int a[], int b[], int n, int m)
    {
        ArrayList<Integer> list=new ArrayList<>();
        if(a[0]<b[0]){
            list.add(a[0]);
        }else{
            list.add(b[0]);
        }

        int i=0,j=0;
        while(i<n && j<m){
            int insert=0;
            if(a[i]<b[j]){
                insert=a[i++];
            }else{
                insert=b[j++];
            }
            if(!(list.get(list.size()-1)==insert)){
                list.add(insert);
            }
        }
        while(i<n){
            if(!(list.get(list.size()-1)==a[i])){
                list.add(a[i]);
            }
            i++;
        }
        while(j<m){
            if(!(list.get(list.size()-1)==b[j])){
                list.add(b[j]);
            }
            j++;
        }

        return list;
    }
}
