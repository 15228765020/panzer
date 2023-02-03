package com.my.panzer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyPanel extends JPanel implements KeyListener {


    private Tank tank ;

    int x;
    int y;
    int direct;

    public MyPanel() {
    }

    public MyPanel(Tank tank ) {


        this.tank = tank;

         x   = tank.getX() ;

         y  = tank.getY() ;

         direct = tank.getDirect();

    }

    //当前坦克的坐标、方向



    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawPanzer(tank.getX(),tank.getY(),g,tank.getDirect());
//        drawPanzer(x,y,g,direct);

    }

    private void drawPanzer(int x, int y,Graphics g,Integer direct) {//0上 1下 2左 3右

        switch (direct){ //绘制坦克

            case 0://上
                // 左履带
                g.drawRect(x,y,10,60);

                // 中间矩形(车厢)
                g.drawRect(x+10,y+10,40,40);

                //圆(盖子)
                g.drawOval(x+20,y+20,20,20);
                //炮管
                g.drawLine(x+30,y+30,x+30,y);

                //右履带
                g.drawRect(x+50,y,10,60);
                break;
            case 1://下
                // 左履带
                g.drawRect(x,y,10,60);

                // 中间矩形(车厢)
                g.drawRect(x+10,y+10,40,40);

                //圆(盖子)
                g.drawOval(x+20,y+20,20,20);
                //炮管
                g.drawLine(x+30,y+30,x+30,y+70);

                //右履带
                g.drawRect(x+50,y,10,60);
                break;
            case 2://左
                // 左履带
                g.drawRect(x,y,60,10);

                // 中间矩形(车厢)
                g.drawRect(x+10,y+10,40,40);

                //圆(盖子)
                g.drawOval(x+20,y+20,20,20);
                //炮管
                g.drawLine(x+30,y+30,x-10,y+30);

                //右履带
                g.drawRect(x,y+50,60,10);

                break;

            case 3://右

                // 左履带
                g.drawRect(x,y,60,10);

                // 中间矩形(车厢)
                g.drawRect(x+10,y+10,40,40);

                //圆(盖子)
                g.drawOval(x+20,y+20,20,20);
                //炮管
                g.drawLine(x+30,y+30,x+70,y+30);

                //右履带
                g.drawRect(x,y+50,60,10);

                break;

        }



    }

    @Override
    public void keyTyped(KeyEvent e) {

        char keyChar = e.getKeyChar();

        switch ((int) keyChar){

            case KeyEvent.VK_W:

                this.direct = 0;
                y--;

                refreshTank(x,y,direct);

                repaint();

                break;
            case KeyEvent.VK_A:
                this.direct = 2;
                x--;
                refreshTank(x,y,direct);
                repaint();

                break;

            case KeyEvent.VK_S:

                this.direct = 1;
                y++;
                refreshTank(x,y,direct);
                repaint();
                break;
            case KeyEvent.VK_D:

                this.direct = 3;
                x++;
                refreshTank(x,y,direct);
                repaint();
                break;
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    //更新坦克的 x y direct

    public void refreshTank(int x, int y ,int direct){

        this.tank.setX(x);
        this.tank.setY(y);
        this.tank.setDirect(direct);
    }
}
