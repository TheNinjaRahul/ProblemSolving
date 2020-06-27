package com.company.GFG.stack;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        int[] data = {11, 2, 32, 3, 41};
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < data.length; i++) {
            s.push(data[i]);
        }
        System.out.println(s);
        s = sort(s);
        System.out.println(s);
    }

    public static Stack<Integer> sort(Stack<Integer> s) {
        Stack<Integer> ts = new Stack<>();
        while (!s.isEmpty()) {
            int temp = s.pop();
            while (!ts.isEmpty() && ts.peek() > temp) {
                s.push(ts.pop());
            }
            ts.push(temp);
        }
        return ts;
    }

    public static Stack<Integer> sort2(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int temp = s.pop();
            sort(s);
            sortElement(s, temp);
        }
        return s;
    }

    private static void sortElement(Stack<Integer> s, int temp) {
        if (s.isEmpty() || s.peek() < temp) {
            s.push(temp);
        } else {
            int t = s.pop();
            sortElement(s, temp);
            sortElement(s, t);
        }
    }


}
