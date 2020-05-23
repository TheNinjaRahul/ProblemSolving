package com.company.GFG.Array;

import java.util.ArrayList;
import java.util.Set;

public class SortedSubsequenceOfSize3 {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(1);
        a.add(1);
        a.add(3);
        System.out.println(find3Numbers(a, a.size()));

    }

    static ArrayList<Integer> find3Numbers(ArrayList<Integer> a, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        if (a.size() < 3) {
            return list;
        }
        int[] min = new int[n];
        int[] max = new int[n];

        int j = n - 2;
        min[0] = 0;
        max[n - 1] = n-1;
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i) < a.get(min[i - 1])) {
                min[i] = i;
            }else{
                min[i]=min[i-1];
            }
            if (a.get(max[j + 1]) < a.get(j)) {
                max[j] = j;
            }else {
                max[j]=max[j+1];
            }
            j--;
        }

        for(int i=1;i<a.size()-1;i++){
            if(a.get(min[i]) < a.get(i)  && a.get(i) < a.get(max[i])){
               list.add(a.get(min[i]));
                list.add(a.get(i));
                list.add(a.get(max[i]));
                return list;
            }
        }

        return list;
    }
}
