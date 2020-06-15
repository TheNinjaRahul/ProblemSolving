package com.company.leetcode;

import java.util.*;

public class RandomFunction {

    Map<Integer,Integer> map;
    List<Integer> list;

    Random rnum;
    public RandomFunction() {
        map=new HashMap<>();
        list=new ArrayList<>();
        rnum = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val,list.size());
            list.add(val);
            return true;
        }
        return false;

    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {

        if(map.containsKey(val)){

            int i=map.get(val);
            list.set(i,list.get(list.size()-1));
            map.put(list.get(i),i);
            list.remove(list.size()-1);
            map.remove(val);
            return true;
        }
        return false;

    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rnum.nextInt(list.size()));
    }
}
