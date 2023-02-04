package com.my.panzer.线程案例.线程插队练习;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i =1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello"+i);
        }
    }
}
