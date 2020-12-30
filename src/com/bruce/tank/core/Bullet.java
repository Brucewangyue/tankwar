package com.bruce.tank.core;

import com.bruce.tank.enums.DirectionEnum;
import com.bruce.tank.enums.GroupEnum;
import com.bruce.tank.frame.TankFrame;

import java.awt.*;

public class Bullet {
    private int x;
    private int y;
    private final DirectionEnum dir;
    private final int moveLength = 10;
    private final TankFrame tankFrame;
    private boolean living = true;
    private final GroupEnum groupEnum;

    public Bullet(int x, int y, DirectionEnum dir, TankFrame tankFrame, GroupEnum groupEnum) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
        this.groupEnum = groupEnum;
    }

    public void paint(Graphics g) {
        if (!living) {
            tankFrame.bullets.remove(this);
            return;
        }

        switch (dir) {
            case LEFT:
                g.drawImage(SrcMgr.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(SrcMgr.bulletR, x, y, null);
                break;
            case UP:
                g.drawImage(SrcMgr.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(SrcMgr.bulletD, x, y, null);
                break;
        }

        move();
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= moveLength;
                break;
            case RIGHT:
                x += moveLength;
                break;
            case UP:
                y -= moveLength;
                break;
            case DOWN:
                y += moveLength;
                break;
        }

        if (x < 0 || y < 0 || x > tankFrame.GAME_WIDTH || y > tankFrame.GAME_HEIGHT) living = false;
    }

    public void collideEnemyTank(Tank tank) {
        if(groupEnum == tank.getGroupEnum()) return;

        Rectangle bulletRectangle = new Rectangle(x, y, SrcMgr.bulletWidth, SrcMgr.bulletHeight);
        Rectangle tankRectangle = new Rectangle(tank.getX(), tank.getY(), SrcMgr.tankWidth, SrcMgr.tankHeight);
        if (bulletRectangle.intersects(tankRectangle)) {
            die();
            tank.die();
        }
    }

    private void die() {
        living = false;
    }
}
