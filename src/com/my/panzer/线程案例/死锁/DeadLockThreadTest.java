package com.my.panzer.线程案例.死锁;

public class DeadLockThreadTest {
    public static void main(String[] args) {

        DeadLockThread deadLockThread1 = new DeadLockThread();
        deadLockThread1.setFlag(true);

        DeadLockThread deadLockThread2 = new DeadLockThread();
        deadLockThread2.setFlag(false);


        deadLockThread1.start();
        deadLockThread2.start();


    }
}
