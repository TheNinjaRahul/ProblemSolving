package com.company.GFG.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class KClosestPointToOrigin {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> points=new ArrayList<>();
        ArrayList<Integer> point1=new ArrayList<>();
        point1.add(3);
        point1.add(3);
        ArrayList<Integer> point2=new ArrayList<>();
        point2.add(5);
        point2.add(-1);
        ArrayList<Integer> point3=new ArrayList<>();
        point3.add(-2);
        point3.add(4);
        points.add(point1);
        points.add(point2);
        points.add(point3);
        System.out.println(kClosest(points,2));
    }

    static class MyClass implements Comparable<MyClass>{
        int a,b;
        double distance;

        public MyClass(int a, int b, double distance) {
            this.a = a;
            this.b = b;
            this.distance = distance;
        }

        @Override
        public int compareTo(MyClass o) {
            double result = this.distance-o.distance;
            if(result==0){
                return 0;
            }else if(result>0){
                return 1;
            }else{
                return -1;
            }
        }
    }
    public static ArrayList<ArrayList<Integer>> kClosest(ArrayList<ArrayList<Integer>> points, int K)
    {
        LinkedList<MyClass> maxHeap=new LinkedList<>();
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        for(int i=0;i<K;i++){
            Integer x=points.get(i).get(0);
            Integer y=points.get(i).get(1);
            double distance=Math.sqrt((x*x)+(y*y));
           maxHeap.add(new MyClass(x,y,distance));
        }

        Collections.sort(maxHeap,Collections.reverseOrder());

        for(int i=K;i<points.size();i++){
            Integer x=points.get(i).get(0);
            Integer y=points.get(i).get(1);
            double distance=Math.sqrt((x*x)+(y*y));
            if(maxHeap.get(0).distance > distance){
                maxHeap.remove(0);
                maxHeap.add(new MyClass(x,y,distance));
                Collections.sort(maxHeap,Collections.reverseOrder());
            }
        }
        Collections.sort(maxHeap);
        for(MyClass m:maxHeap){
            ArrayList<Integer> list=new ArrayList<>();
            list.add(m.a);
            list.add(m.b);
            result.add(list);
        }

        return result;
    }


}
