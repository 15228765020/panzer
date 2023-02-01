package com.my.panzer.小球移动案例;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyPanel extends JPanel  implements KeyListener {

    int x = 0 ;

    int y = 0 ;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        g.drawOval(10,10,50,50);
        g.drawOval(x,y,50,50);

    }

    @Override
    public void keyTyped(KeyEvent e) {

//        System.out.println("按下键是=>"+e.getKeyChar());
//        char keyChar = e.getKeyChar();
        int keyCode = e.getKeyCode();

        char keyChar = e.getKeyChar();


        switch ((int) keyChar){
            case KeyEvent.VK_W:
                y--;
                repaint();
                break;
            case KeyEvent.VK_A:
                x--;
                repaint();
                break;

            case KeyEvent.VK_S:
                y++;
                repaint();
                break;
            case KeyEvent.VK_D:
                x++;
                repaint();
                break;
        }


    }

    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println("按下键是=>"+e.getKeyChar());

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
