package com.my.panzer;

import javax.swing.*;

public class MyJFrame extends JFrame {

    private MyPanel panel = null;

    public MyJFrame(MyPanel panel) {

        this.panel = panel;

        this.add(panel);

        this.setSize(800,600);

        this.setVisible(true);
        //关闭窗口即退出程序
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.addKeyListener(panel);

    }
}
