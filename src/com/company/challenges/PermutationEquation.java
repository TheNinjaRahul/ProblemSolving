package com.company.challenges;

import java.util.ArrayList;
import java.util.List;

public class PermutationEquation {
    public static void main(String[] args) {
        permutationEquation(new int[]{2,3,1});
    }

    // Complete the permutationEquation function below.
    static int[] permutationEquation(int[] p) {
//
//        for (int x = 0; x < p.length; x++) {
//            int y = p[p[x]-1]+1;
//            System.out.println(y);
//        }

//        List<Integer> list = new ArrayList<>(p.length);
//
//        for (int i : p) {
//            list.add(Integer.valueOf(i));
//        }
        int[] data=new int[p.length];
        for(int i=1;i<=p.length;i++){
            int j,k;
            for(j=0;j<p.length;j++){
                if(p[j]==i){
                    break;
                }
            }
            j++;
            for(k=0;k<p.length;k++){
                if(p[k]==j){
                    break;
                }
            }
            String s;

            k++;
            System.out.println(k);
            data[i-1]=k;
        }

//        for(int i=0;i<list.size();i++){
//            int d=list.get(i)-1;
//            System.out.println(list.get(d));
//        }



        return  data;
    }
}
