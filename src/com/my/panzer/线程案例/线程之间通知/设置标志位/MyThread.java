package com.my.panzer.线程案例.线程之间通知.设置标志位;

public class MyThread extends Thread {

    private boolean flag = false;

    @Override
    public void run() {
        while (true){

            System.out.println(Thread.currentThread().getName()+"线程进入~~");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (Thread.currentThread().getName().equals("ali")){ //ali 线程 通知 tec线程退出
                flag = true;
            }
            if (flag){
                System.out.println(Thread.currentThread().getName()+"线程已退出");
                return;
            }
        }
    }

    /*  @Override
    public void run() {
        int i = 0;
        while (true){
            if (flag){
                return;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程"+Thread.currentThread().getName()+"运行中~~"+(++i));
        }

    }*/

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
