package com.my.panzer;

public class Tank {

    private static volatile Tank tank;

    private Tank() {
    }


    private Integer x = 0;

    private Integer y = 0;

    private Integer direct = 0;

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

    public static Tank getSingleTon(){

        if (tank == null){

            synchronized (Tank.class){

                if (tank == null){
                    tank = new Tank();
                }

            }

        }
        return tank;
    }


}
