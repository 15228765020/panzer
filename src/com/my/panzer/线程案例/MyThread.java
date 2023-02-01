package com.my.panzer.线程案例;

public class MyThread extends Thread {
    @Override
    public void run() {


        for (int i = 0; i < 10; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello,world");

        }
    }
}
