package com.company.javaLogic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class TwoIterator {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3000; i++) {
            list.add(i);
        }

        Thread t = new Thread(() -> {
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.println(Thread.currentThread() + ":" + iterator.next());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            ListIterator<Integer> iterator = (ListIterator<Integer>) list.iterator();
            while (iterator.hasNext()) {
                System.out.println(Thread.currentThread() + ":" + iterator.next());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                iterator.remove();
            }
        });
        t.start();
        t2.start();
        System.out.println("Finish");
    }
}
