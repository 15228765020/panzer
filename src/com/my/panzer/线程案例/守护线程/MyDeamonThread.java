package com.my.panzer.线程案例.守护线程;

public class MyDeamonThread extends Thread {
    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("deamon thread=="+i);
        }
        System.out.println("子进程退出");
    }
}
