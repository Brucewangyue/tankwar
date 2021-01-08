package com.bruce.tank.dp.proxy.v1;

/**
 * 静态代理：
 *  通过代理去为某个类的方法调用方法：添加切面处理的能力
 *  类似装饰器模式
 */
public class T01_Main {
    public static void main(String[] args) {
        new TankMoveTimeProxy(new TankMoveLogProxy(new Tank())).move();
    }
}

class Tank implements Movable{
    @Override
    public void move() {
        System.out.println("坦克移动中。。。");
    }
}

class TankMoveLogProxy implements Movable {

    private final Movable movable;

    public TankMoveLogProxy(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void move() {
        System.out.println("坦克开始移动");
        movable.move();
        System.out.println("坦克停止");
    }
}

class TankMoveTimeProxy implements Movable {

    private final Movable movable;

    public TankMoveTimeProxy(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        movable.move();
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }
}

interface Movable {
    void move();
}