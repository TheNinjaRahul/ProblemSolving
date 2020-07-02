package com.company.concurrency;

public class StopThread {
    public static void main(String[] args) {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("Thread Ended without irruption ");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();
        System.out.println("Thread Started");
        t.stop();
        System.out.println("Exiting system");
    }
}
