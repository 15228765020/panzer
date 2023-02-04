package com.my.panzer.线程案例.线程之间通知.interrupt;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i1 = 0; i1 < 10; i1++) {

            if (i1==5){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {

                    System.err.println("线程"+Thread.currentThread().getName()+"结束休眠");
                }
            }
            System.out.println("打印值为:"+i1);
        }

    }

}
