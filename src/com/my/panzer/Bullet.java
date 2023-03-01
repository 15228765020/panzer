package com.my.panzer;


public class Bullet implements Runnable {

    private Integer speed = 5;
    private Integer x;

    private Integer y;

    private Integer direct;

    private Boolean isLive = true;

    //子弹的伤害

    private Integer hurt = 100;


    public Bullet() {
    }

    public Bullet(Integer x, Integer y, Integer direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }


    public Integer getHurt() {
        return hurt;
    }

    public void setHurt(Integer hurt) {
        this.hurt = hurt;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Boolean getLive() {
        return isLive;
    }

    public void setLive(Boolean live) {
        isLive = live;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getDirect() {
        return direct;
    }

    public void setDirect(Integer direct) {
        this.direct = direct;
    }



    @Override
    public void run() {

        //每隔50 ms 改变子弹的 x/y坐标
        while (true){

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (direct){

                case 0://上
                    y-=speed;
                    break;

                case 1://下
                    y+=speed;
                    break;

                case 2://左

                    x-=speed;
                    break;

                case 3://右

                    x+=speed;
                    break;

            }

            System.out.println(Thread.currentThread().getName()+"子弹的坐标: x = "+x+"  y = "+y);

            //子弹边界就是画布长宽

            if (!isLive){
                System.out.println("子弹已销毁");
                break;
            }

            if (!((x>0&&x<=800) && (y>0 && y<=600)) ){

                System.out.println("子弹出边界已经销毁~~");

                isLive = false;

                break;
            }


        }

    }
}
