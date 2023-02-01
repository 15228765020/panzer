package com.my.panzer.小球移动案例;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {

        MyPanel myPanel = new MyPanel();


        MyFrame myFrame = new MyFrame();

        myFrame.add(myPanel);
        //初始化操作

        //关闭窗口即退出程序
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        myFrame.setSize(800,600);

        myFrame.setVisible(true);

        myFrame.addKeyListener(myPanel);

    }
}
