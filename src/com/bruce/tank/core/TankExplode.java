package com.bruce.tank.core;

import com.bruce.tank.enums.DirectionEnum;
import com.bruce.tank.enums.GroupEnum;
import com.bruce.tank.frame.TankFrame;

import java.awt.*;

public class TankExplode {
    private int x;
    private int y;
    private final TankFrame tankFrame;
    private boolean living = true;
    private int step = 0;

    public TankExplode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g) {
        g.drawImage(SrcMgr.tankExplodeImages[step], x, y, null);
        step++;
        if (step == SrcMgr.tankExplodeImages.length)
            step = 0;
    }


    private void die() {
        living = false;
    }
}
