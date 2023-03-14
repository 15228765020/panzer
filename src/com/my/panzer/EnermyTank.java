package com.my.panzer;

import java.util.Vector;

public class EnermyTank  extends Tank implements Runnable{


    //生命值初始化为100
    private Integer life = 100;

    private Vector<Bullet> bullets = new Vector<>();

    private Bullet bullet = null;


    public Integer getLife() {
        return life;
    }

    public void setLife(Integer life) {
        this.life = life;
    }

    public Vector<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(Vector<Bullet> bullets) {
        this.bullets = bullets;
    }

    public void fireTheHole() {//敌人坦克攻击

        switch (this.getDirect()){

            case 0://上

                bullet = new Bullet(this.getX()+30,this.getY()-20,0);


                break;
            case 1://下

                bullet = new Bullet(this.getX()+30,this.getY()+80,1);
                break;
            case 2://左

                bullet = new Bullet(this.getX()-20,this.getY()+30,2);
                break;

            case 3://右

                bullet = new Bullet(this.getX()+80,this.getY()+30,3);

                break;


        }

        bullets.add(bullet);

        //
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread = new Thread(bullet);

        thread.start();



    }

    //敌人坦克移动
    public void enemyTankMove(){


        //坦克随机方向移动
        //[0-1)

        Integer y = getY();

        Integer x = getX();


        switch (getDirect()){//敌人坦克方向

            case 0: //上

                y--;
                setY(y);

                //如果出界就换方向

                if (isOutSide()){
                    setDirect(randomDirect());
                }
                break;

            case 1://下
                y++;
                setY(y);

                if (isOutSide()){
                    setDirect(randomDirect());
                }
                break;

            case 2://左

                x--;
                setX(x);

                if (isOutSide()){
                    setDirect(randomDirect());
                }
                break;

            case 3://右
                x++;
                setX(x);


                if (isOutSide()){
                    setDirect(randomDirect());
                }
                break;


        }

    }

    //判断敌人坦克是否出界

    public Boolean isOutSide(){//800 x600

        switch (getDirect()){

            case 0://上

                if (getY()<=0){

                    return true;
                }
                case 1://下
                    if (getY()>=600){

                        return true;
                    }

                    case 2://左
                        if (getX()<=0){

                            return true;
                        }

                        case 3: //右
                            if (getX()>=800){

                                return true;
                            }
        }
        return false;
    }

    public Bullet getBullet() {
        return bullet;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }

    @Override
    public void run() {
        int dir = randomDirect();

        setDirect(dir);

        while (true){

            enemyTankMove();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public Integer randomDirect(){
        return (int) (Math.random() * 4);
    }
}
