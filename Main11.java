package com.company;

import java.lang.Thread.State;

public class Main {
    ConnectThread connectThread[];

    public static void main(String[] args) {
        ConnectThread connectThread[] = new ConnectThread[10];
        Counter count = new Counter();
        for(int i = 0; i < 10; i++){
            connectThread[i] = new ConnectThread();
        }

        for(int i = 0; i < 10; i++){
            System.out.println(connectThread[i].getState());
            connectThread[i].start();
            System.out.println(connectThread[i].getState());
            for(int j =1; j<101;j++){
                System.out.println(j);
                System.out.println(connectThread[i].getState());
            }
        }
        ConnectThread connectThread1[] = new ConnectThread[100];
        for(int i = 0; i < 100; i++){
            connectThread1[i] = new ConnectThread();
        }

        for(int i = 0; i < 100; i++){

            connectThread1[i].start();

            for(int j =0; j<1000;j++){
                count.increment();
            }
        }
        System.out.println("Инкремент равен " + count.getCount());

        Object lock = new Object();
        new StepThread(lock).start();
        new StepThread(lock).start();
    }
}
class ConnectThread extends Thread {
    public void run() {
        System.out.println("Run connect 1");
    }

    @Override
    public State getState() {
        return super.getState();
    }
}
class Counter {
    int count = 0;

    public  void increment() {
         count = count + 1;
    }

    public int getCount() {
        return count;
    }
}
class StepThread extends Thread {


    private Object lock;

    public StepThread(Object object) {
        this.lock = object;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                try {
                    System.out.println(getName());
                    lock.notify();
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}