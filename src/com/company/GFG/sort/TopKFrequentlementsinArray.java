package com.company.GFG.sort;

import java.lang.reflect.Array;
import java.util.*;

public class TopKFrequentlementsinArray {
    public static void main(String[] args) {
        ArrayList<Integer> data=new ArrayList<>();
//        int[] data={6 ,1 ,1 ,1 ,2 ,2 ,3};
        data.add(6);
        data.add(1);
        data.add(1);
        data.add(1);
        data.add(2);
        data.add(2);
        data.add(3);
//        data.add(6);
        System.out.println(TopK(data,2));
    }
    static ArrayList<Integer> TopK(ArrayList<Integer> array, int k)
    {
        Map<Integer,Integer> map=new HashMap<>();
        for(Integer i:array){
            if(map.containsKey(i)){
                Integer v=map.get(i);
                v++;
                map.put(i,v);
            }else{
                map.put(i,1);
            }
        }


        class MyClass implements Comparable<MyClass>{
            int value;
            int count;

            public MyClass(int value, int count) {
                this.value = value;
                this.count = count;
            }

            @Override
            public int compareTo(MyClass o) {
                if(o.count == this.count){
                    return o.value-this.value;
                }else{
                    return o.count-this.count;
                }
            }
        }

        Set<MyClass> set=new TreeSet<>();
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            set.add(new MyClass(e.getKey(),e.getValue()));
        }

        ArrayList<Integer> list=new ArrayList<>();
        Iterator<MyClass> iterator=set.iterator();
        while(iterator.hasNext() && k > 0){
            list.add(iterator.next().value);
            k--;
        }
        return list;
    }
}
