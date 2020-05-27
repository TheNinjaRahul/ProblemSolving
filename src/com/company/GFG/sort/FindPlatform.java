package com.company.GFG.sort;

import java.util.*;
import java.util.stream.Collectors;

public class FindPlatform {
    public static void main(String[] args) {
        int a[]={900 , 940 ,950  ,1100, 1500 ,1800};
        int d[]={910 ,1200, 1120, 1130 ,1900, 2000};
        System.out.println(findPlatform(a,d,a.length));
    }

    private static int findPlatform(int[] a, int[] d, int length) {
        Arrays.sort(a);
        Arrays.sort(d);
        int i=0,j=0,count=0,arival=0;
        while(i<a.length && j<d.length){
            if(a[i]<=d[j]){
                arival++;
                i++;
            }else{
                arival--;
                j++;
            }
            if(arival>count){
                count=arival;
            }
        }
        return count;

    }

    static int findPlatform2(int arr[], int dep[], int n)
    {


        class Train implements Comparable<Train>{
            int arrival;
            int departure;

            public Train(int arrival, int departure) {
                this.arrival = arrival;
                this.departure = departure;
            }


            @Override
            public int compareTo(Train o) {
                return this.arrival-o.arrival;
            }
        }

        ArrayList<Train> trainArrayListlist=new ArrayList<>();
        for(int i=0;i<n;i++){
            trainArrayListlist.add(new Train(arr[i],dep[i]));
        }
        Collections.sort(trainArrayListlist);

        List<Integer> list=new LinkedList<>();
        int count=0;
        for(Train t:trainArrayListlist){
            if(list.isEmpty()){
                if(count==0){
                    count++;
                }
                list.add(t.departure);
                continue;
            }

            ListIterator<Integer> listIterator= (ListIterator<Integer>) list.iterator();
            while(listIterator.hasNext()){
                Integer d=listIterator.next();
                if(d<t.arrival){
                    listIterator.remove();
                }else{
                    listIterator.add(t.departure);
                    if(count<list.size()){
                        count++;
                    }
                    break;
                }
            }
            if(list.isEmpty()){
                list.add(t.departure);
            }
            Collections.sort(list);
        }

        return count;


    }
}
