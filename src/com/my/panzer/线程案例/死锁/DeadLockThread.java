package com.my.panzer.线程案例.死锁;

public class DeadLockThread extends Thread {

    //lock1
    private static final Object lock1 =   new Object();
    //lock2
    private static final Object lock2 =   new Object();

    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程进入run()开始执行~~");

        if (flag){
            synchronized (lock1){
                System.out.println(Thread.currentThread().getName()+"获得锁 lock1");
                synchronized (lock2){
                    System.out.println(Thread.currentThread().getName()+"获得锁 lock2");
                    System.out.println(Thread.currentThread().getName()+"准备释放锁 lock2");
                }
                System.out.println(Thread.currentThread().getName()+"准备释放锁 lock1");
            }
        }else {
            synchronized (lock2){

                System.out.println(Thread.currentThread().getName()+"获得锁 lock2");
                synchronized (lock1){

                    System.out.println(Thread.currentThread().getName()+"获得锁 lock1");
                    System.out.println(Thread.currentThread().getName()+"准备释放锁 lock1");
                }
                System.out.println(Thread.currentThread().getName()+"准备释放锁 lock2");
            }
        }

    }
}
