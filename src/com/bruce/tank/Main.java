package com.bruce.tank;

import com.bruce.tank.core.PropertiesMgr;
import com.bruce.tank.core.Tank;
import com.bruce.tank.enums.DirectionEnum;
import com.bruce.tank.enums.GroupEnum;
import com.bruce.tank.frame.TankFrame;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame f = new TankFrame();

        int tankCount = PropertiesMgr.getInteger("init-tank-count");
        for (int i = 0; i < tankCount; i++) {
            f.enemyTanks.add(new Tank(300 + i * 50, 300, DirectionEnum.DOWN, f, GroupEnum.Enemy));
        }

        while (true) {
            Thread.sleep(50);
            f.repaint();
        }
    }
}
