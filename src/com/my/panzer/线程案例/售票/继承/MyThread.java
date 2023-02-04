package com.my.panzer.线程案例.售票.继承;

public class MyThread extends Thread {

    // 1、这里要想到之前背的jvm的线程共享(堆和方法区)和线程私有(其它)的区域 ;这static 修饰的变量就在方法区 2、static修饰的变量是类变量，只加载一次
    private static  int ticket = 100;


    @Override
    public  void  run() {

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (ticket==0){
                    System.out.println("所有票全部卖完");
                    return;
            }

            synchronized (MyThread.class){
                ticket--;
                System.out.println("当前余票数="+ticket);
            }


        }

    }
}
