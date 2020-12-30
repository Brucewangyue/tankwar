package com.bruce.tank.core;

import com.bruce.tank.enums.DirectionEnum;
import com.bruce.tank.enums.GroupEnum;
import com.bruce.tank.frame.TankFrame;

import java.awt.*;
import java.util.Random;

public class Tank {
    private final TankFrame tankFrame;
    private DirectionEnum dir;
    private boolean moving = false;
    private boolean living = true;
    private final int moveLength = 2;
    private final Random randomFire = new Random();
    private final GroupEnum groupEnum;
    private int x;
    private int y;

    public GroupEnum getGroupEnum() {
        return groupEnum;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public DirectionEnum getDir() {
        return dir;
    }

    public void setDir(DirectionEnum dir) {
        this.dir = dir;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Tank(int x, int y, DirectionEnum dir, TankFrame tankFrame, GroupEnum groupEnum) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
        this.groupEnum = groupEnum;
    }

    public void paint(Graphics g) {
        if (!living) {
            tankFrame.enemyTanks.remove(this);
            return;
        }
        ;

        if (randomFire.nextInt(10) > 8) fire();

        switch (dir) {
            case LEFT:
                g.drawImage(SrcMgr.tankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(SrcMgr.tankR, x, y, null);
                break;
            case UP:
                g.drawImage(SrcMgr.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(SrcMgr.tankD, x, y, null);
                break;
        }

        move();
    }

    private void move() {
        if (!moving) return;

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
    }

    public void fire() {
        int bX = x + SrcMgr.tankWidth / 2 - SrcMgr.bulletWidth / 2;
        int bY = y + SrcMgr.tankHeight / 2 - SrcMgr.bulletHeight / 2;

        tankFrame.bullets.add(new Bullet(bX, bY, getDir(), tankFrame, groupEnum));
    }

    public void die() {
        living = false;
    }
}
