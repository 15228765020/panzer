package com.my.panzer.线程案例.线程之间通知.设置标志位;

public class MyThreadTest {
    public static void main(String[] args) throws InterruptedException {

        //ali 线程 通知 tec线程退出
        MyThread myThread = new MyThread();
        myThread.setName("ali");
        myThread.start();
        MyThread myThread1 = new MyThread();
        myThread1.setName("tec");
        myThread1.start();
      /*  Thread.sleep(2000);
        System.out.println("即将通知子线程");
        myThread.setFlag(true);*/
    }
}
