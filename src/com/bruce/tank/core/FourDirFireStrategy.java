package com.bruce.tank.core;

import com.bruce.tank.enums.DirectionEnum;
import com.bruce.tank.frame.TankFrame;

public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank tank) {
        int bX = tank.getX() + tank.getWidth() / 2 - SrcMgr.bulletWidth / 2;
        int bY = tank.getY() + tank.getHeight() / 2 - SrcMgr.bulletHeight / 2;

        TankFrame tf = TankFrame.getInstance();
        DirectionEnum[] directionEnums = DirectionEnum.values();
        for (DirectionEnum dir : directionEnums) {
            tf.bullets.add(new Bullet(bX, bY, dir, tf, tank.getGroupEnum()));
        }
    }
}
