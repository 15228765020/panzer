package com.my.panzer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener , Runnable{

    private Vector<EnermyTank> tankVector = new Vector<>();


    {
        EnermyTank enermyTank1 = new EnermyTank();


        enermyTank1.setDirect(1);
        //暂时只发射一颗子弹 ,所以子弹初始化在paint外面
        enermyTank1.fireTheHole();

        EnermyTank enermyTank2 = new EnermyTank();
        enermyTank2.setX(100);
        enermyTank2.setDirect(1);
        enermyTank2.fireTheHole();

        EnermyTank enermyTank3 = new EnermyTank();
        enermyTank3.setX(200);
        enermyTank3.setDirect(1);
        enermyTank3.fireTheHole();

        //敌人坦克自动移动

        Thread thread1 = new Thread(enermyTank1);
        Thread thread2 = new Thread(enermyTank2);
        Thread thread3 = new Thread(enermyTank3);
        thread1.start();
        thread2.start();
        thread3.start();
        tankVector.add(enermyTank1);
        tankVector.add(enermyTank2);
        tankVector.add(enermyTank3);


    }

    private Hero hero ;

    public MyPanel() {
    }

    public MyPanel(Hero hero ) {

        this.hero = hero;
    }

    //当前坦克的坐标、方向


    @Override
    public void paint(Graphics g) {

        super.paint(g);
        //玩家坦克
        g.setColor(Color.BLUE);//将画笔调成蓝色

        drawPanzer(hero.getX(),hero.getY(),g,hero.getDirect());

        //子弹
        if (hero.getBullet()!=null){
            g.drawOval(hero.getBullet().getX(),hero.getBullet().getY(),2,2);
        }

        // 画出敌人坦克

        Iterator<EnermyTank> iterator = tankVector.iterator();

        while (iterator.hasNext()){

            EnermyTank enermyTank = iterator.next();

            if (hero.getBullet()!=null && hero.getBullet().getLive()){

                Integer direct = hero.getDirect();
                Bullet bullet = hero.getBullet();
                switch (direct){//hero 方向

                    case 0://上


                        if (       bullet.getY() <= enermyTank.getY()+60
                                && bullet.getX()>= enermyTank.getX()
                                && bullet.getX()<= enermyTank.getX()+60
                            ){

                                bullet.setLive(false);
                                iterator.remove();
                        }
                        break;
                    case 1://下
                       // System.err.println("敌人坦克的坐标"+Thread.currentThread().getName()+"; x = "+enermyTank.getX()+"; y="+enermyTank.getX());
                        if ((      bullet.getX() <= enermyTank.getX()+60
                                && bullet.getY()>= enermyTank.getY()
                                && bullet.getX()<= enermyTank.getX())
                                ){
                            bullet.setLive(false);
                            iterator.remove();


                        }

                        break;

                    case 2://左

                        if (     bullet.getX() >= enermyTank.getX()
                              && bullet.getY() >= enermyTank.getY()
                              && bullet.getY()<= enermyTank.getY()+60
                            ){
                            bullet.setLive(false);
                            iterator.remove();
                        }

                        break;

                    case 3://右

                        if (       bullet.getX() <= enermyTank.getX()+60
                                && bullet.getY() >= enermyTank.getY()
                                && bullet.getY()<= enermyTank.getY()+60
                                ){
                                    bullet.setLive(false);
                                    iterator.remove();

                        }

                        break;


                }
            }



            g.setColor(Color.RED);//将画笔调成红色
            drawPanzer(enermyTank.getX(),enermyTank.getY(),g,enermyTank.getDirect());


            //敌人坦克自动攻击

            Vector<Bullet> bullets = enermyTank.getBullets();

            for (Bullet bullet : bullets) {

                g.drawOval(bullet.getX(), bullet.getY(), 2, 2);
            }

        }

        }

    //}



    //画坦克
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
                g.drawLine(x+30,y+30,x+30,y-10);

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

            case KeyEvent.VK_W://大写的输入  上

                hero.setDirect(0);

                int y = hero.getY();

                if (!isTriggered(hero.getX(),y,KeyEvent.VK_W)){
                    y--;
                }


                refreshTank(hero.getX(),y,hero.getDirect());

                repaint();

                break;
            case KeyEvent.VK_A: //左

                hero.setDirect(2);

                Integer x = hero.getX();

                if (!isTriggered(x,hero.getY(),KeyEvent.VK_A)){
                    x--;
                }

                refreshTank(x,hero.getY(),hero.getDirect());
                repaint();

                break;

            case KeyEvent.VK_S://下

                hero.setDirect(1);

                Integer y1 = hero.getY();
                if (!isTriggered(hero.getX(),y1,KeyEvent.VK_S)){
                    y1++;
                }

                refreshTank(hero.getX(),y1,hero.getDirect());
                repaint();
                break;
            case KeyEvent.VK_D://右

                hero.setDirect(3);
                Integer x1 = hero.getX();

                if (!isTriggered(x1,hero.getY(),KeyEvent.VK_D)){
                    x1++;
                }

                refreshTank(x1,hero.getY(),hero.getDirect());
                repaint();
                break;

            case KeyEvent.VK_J://发射子弹

                hero.fireTheHole();
                break;

        }

    }

    //判断己方坦克和敌方坦克是否接触;接触则不增加步数
    public Boolean isTriggered(int x,int y,int keycode){ //己方坦克坐标
        Iterator<EnermyTank> iterator = tankVector.iterator();

        while (iterator.hasNext()){

            EnermyTank enermyTank = iterator.next();

            //敌人坐标
            int enX=  enermyTank.getX();
            int enY=  enermyTank.getY();

            switch (hero.getDirect()){

                //当前己方坦克方向
                case 0://上
                    if ((enX<= x && x<=enX+60 && enY<=y && y<=enY+60)||(enX<= x+60 && x+60 <=enX+60 && enY<=y && y<=enY+60)){

                        return  true;
                    }

                case 1://下

                    if ((enX<=x && x<=enX+60 && enY<=y+60 && y+60 <= enY+60) ||(enX <=x+60 && x+60 <=enX+60 && enY<=y+60 && y+60 <=enY+60) ){

                        return true;
                    }

                    break;
                case 2://左

                    if ((enX<= x && x<=enX+60 && enY <=y && y<=enY+60)||(enX<= x && x<=enX+60 && enY<=y+60 &&y+60<=enY+60)){

                        return  true;
                    }
                case 3://右

                    if (enX<=x+60 && x+60 <= enX+60 &&( (enY<=y &&y<= enY+60)||(enY<=y+60 &&y+60<= enY+60))){

                        return true;
                    }

                    break;
            }

        }

        return  false;
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    //更新坦克的 x y direct

    public void refreshTank(int x, int y ,int direct){

        this.hero.setX(x);
        this.hero.setY(y);
        this.hero.setDirect(direct);

    }

    @Override
    public void run() {//每隔一段时间重绘画布

        while (true){

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.repaint();
        }


    }


}
