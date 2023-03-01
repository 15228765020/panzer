package com.my.panzer;

public class Hero extends Tank  {

    private Integer x = 400;

    private Integer y = 400;

    private Integer direct = 0;

    private static volatile Hero hero;

    private Bullet bullet  = null;

    private Hero() {
    }

    @Override
    public Integer getX() {
        return x;
    }

    @Override
    public void setX(Integer x) {
        this.x = x;
    }

    @Override
    public Integer getY() {
        return y;
    }

    @Override
    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public Integer getDirect() {
        return direct;
    }

    @Override
    public void setDirect(Integer direct) {
        this.direct = direct;
    }

    //
    public void fireTheHole(){

        switch (getDirect()){
            case 0://上

                bullet = new Bullet(getX()+30,getY()-20,0);

                break;
            case 1://下

                bullet = new Bullet(getX()+30,getY()+80,1);
                break;

            case 2://左

                bullet = new Bullet(getX()-20,getY()+30,2);
                break;

            case 3://右

                bullet = new Bullet(getX()+80,getY()+30,3);
                break;

        }


        Thread thread = new Thread(bullet);

        thread.start();

    }

    public Bullet getBullet() {
        return bullet;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }

    public static Hero getSingleTon(){//单例

        if (hero == null){

            synchronized (Tank.class){

                if (hero == null){
                    hero = new Hero();
                }

            }

        }
        return hero;
    }

}
