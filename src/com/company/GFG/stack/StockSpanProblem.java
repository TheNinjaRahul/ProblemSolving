package com.company.GFG.stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        int[] data={100,80,60,70,60,75,85};
        System.out.println(Arrays.toString(calculateSpan(data,3)));
    }

    public static int[] calculateSpan(int price[], int n) {
        class myclass {
            int index;
            int value;

            public myclass(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }

        Stack<myclass> s = new Stack<>();
        int r[] = new int[price.length];

        for (int i = 0; i < price.length; i++) {
            if (s.isEmpty()) {
                r[i] = -1;
            } else if (s.peek().value >= price[i]) {
                r[i] = s.peek().index;
            } else {
                while (!s.isEmpty() && !(s.peek().value >= price[i])) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    r[i] = -1;
                } else {
                    r[i] = s.peek().index;
                }
            }

            s.push(new myclass(i, price[i]));
        }

        for(int i=0;i<price.length;i++){
            r[i]=i-r[i];
        }
        return r;
    }
}
