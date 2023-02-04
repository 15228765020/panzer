package com.my.panzer.线程案例.守护线程;

public class MyDeamonThreadTest {
    public static void main(String[] args) throws InterruptedException {

        MyDeamonThread myDeamonThread = new MyDeamonThread();
        myDeamonThread.setDaemon(true);
        myDeamonThread.start();

        for (int i = 0; i < 5; i++) {

            Thread.sleep(500);
            System.out.println("主进程=="+i);
        }
        System.out.println("主进程退出");

    }
}
