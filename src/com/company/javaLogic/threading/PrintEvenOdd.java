package com.company.javaLogic.threading;

public class PrintEvenOdd {
    public static void main(String[] args) {
        MyLock lock = new MyLock();
        Thread even = new Thread(new Even(lock));
        Thread odd = new Thread(new Odd(lock));
        even.start();
        odd.start();
    }
}


class MyLock {
    boolean flag = true;
}

class Even implements Runnable {

    MyLock lock = null;

    public Even(MyLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 2; i <= 30; i = i + 2) {
            synchronized (lock) {
                while (lock.flag != false) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
                lock.flag = true;
                lock.notifyAll();
            }
        }

    }
}

class Odd implements Runnable {

    MyLock lock = null;

    public Odd(MyLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 30; i = i + 2) {
            synchronized (lock) {
                while (lock.flag != true) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
                lock.flag = false;
                lock.notifyAll();
            }
        }

    }
}
