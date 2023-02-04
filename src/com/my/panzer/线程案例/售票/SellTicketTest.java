package com.my.panzer.线程案例.售票;

import com.my.panzer.线程案例.售票.继承.MyThread;

public class SellTicketTest {

    public static void main(String[] args) {

        MyThread myThread0 = new MyThread();
        myThread0.start();

        MyThread myThread1 = new MyThread();
        myThread1.start();

        MyThread myThread2 = new MyThread();
        myThread2.start();

    }
}
