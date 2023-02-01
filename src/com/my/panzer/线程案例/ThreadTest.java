package com.my.panzer.线程案例;

public class ThreadTest {

    public static void main(String[] args) {

        MyThread myThread = new MyThread();



        MyThread1 myThread1 = new MyThread1(myThread);


        myThread.start();

        myThread1.start();

    }
}
