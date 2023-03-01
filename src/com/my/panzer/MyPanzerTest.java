package com.my.panzer;

public class MyPanzerTest {

    public static void main(String[] args) {

        MyPanel myPanel = new MyPanel(Tank.getSingleTon());

        MyJFrame myFrame = new MyJFrame(myPanel);


        System.out.println("合并");

    }
}
