package com.company.GFG.Array;

public class Find3rdLarget {

    public static void main(String[] args) {
//        Long[] data = {1l, 2l, 3l, 4l, 5l, 6l, 7l};
        Long[] data = {6l, 8l, 2l, 4l, 9l, 1l};
        System.out.println(thirdLargest(data));
    }

    public static long thirdLargest(Long a[]) {

        if(a.length <3){
            return -1;
        }
        Long l1 = Long.valueOf(Integer.MIN_VALUE), l2 = Long.valueOf(Integer.MIN_VALUE), l3 = Long.valueOf(Integer.MIN_VALUE);

        for (int i = 0; i < a.length; i++) {
            if (l1 < a[i]) {
                long temp = l1;
                l1 = a[i];
                l3 = l2;
                l2 = temp;
            } else if (l2 < a[i]) {
                l3 = l2;
                l2 = a[i];
            } else if (l3 < a[i]) {
                l3 = a[i];
            }

        }

        return l3;
    }
}
