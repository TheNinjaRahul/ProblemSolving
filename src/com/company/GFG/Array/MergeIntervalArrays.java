package com.company.GFG.Array;

import java.util.*;

public class MergeIntervalArrays {
    public static void main(String[] args) {
        Intervals[] data={new Intervals(1,3),new Intervals(2,4),new Intervals(6,8),new Intervals(8,10)};
        System.out.println(overlapIntervals(data));
    }

    public static List<Intervals> overlapIntervals(Intervals[] data){
        List<Intervals> list=new ArrayList<>();
        Arrays.sort(data, new Comparator<Intervals>() {
            @Override
            public int compare(Intervals o1, Intervals o2) {
                return o1.start-o2.start;
            }
        });

        Stack<Intervals> stack=new Stack<>();

        stack.push(data[0]);

        for(int i=1;i<data.length;i++){
            Intervals stackpeek=stack.peek();
            if(stackpeek.end>data[i].start){
                stackpeek.end=data[i].end;
            }else{
                stack.push(data[i]);
            }
        }

        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;

    }
}

class Intervals{
    int start,end;
    public Intervals(int s,int e){
        this.start=s;
        this.end=e;
    }

    @Override
    public String toString() {
        return "Intervals{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}