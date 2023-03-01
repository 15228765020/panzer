package com.my.panzer;

public class MyPanzerTest {

    public static void main(String[] args) {
        Hero hero = Hero.getSingleTon();

        hero.setX(100);
        hero.setY(100);
        MyPanel myPanel = new MyPanel(Hero.getSingleTon());

        Thread thread = new Thread(myPanel);

        thread.start();

        MyJFrame myFrame = new MyJFrame(myPanel);

    }
}
