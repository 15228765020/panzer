package com.my.panzer.线程案例.线程插队练习;

public class ThreadMethodExercise {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 1; i <= 10; i++) {
            if (i==6){

                Thread thread = new Thread(new MyRunnable());
                thread.start();
                thread.join();
            }
            Thread.sleep(1000);
            System.out.println("hi"+i);
        }
    }
}
