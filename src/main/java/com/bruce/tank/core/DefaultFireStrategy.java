package com.bruce.tank.core;

import com.bruce.tank.frame.TankFrame;

public class DefaultFireStrategy implements FireStrategy{
    @Override
    public void fire(Tank tank) {
        int bX = tank.getX() + SrcMgr.tankWidth / 2 - SrcMgr.bulletWidth / 2;
        int bY = tank.getY() + SrcMgr.tankHeight / 2 - SrcMgr.bulletHeight / 2;

        TankFrame tf = TankFrame.getInstance();
        tf.bullets.add(new Bullet(bX, bY, tank.getDir(), tf, tank.getGroupEnum()));
    }
}
