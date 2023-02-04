package com.my.panzer.线程案例.线程之间通知.interrupt;

public class MyInterruptTest {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        Thread.sleep(1000);

        System.out.println("即将结束休眠");
        //在主线程通知子线程结束休眠
        thread.interrupt();

    }
}
