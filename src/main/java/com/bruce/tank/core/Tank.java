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
    private final int moveLength = PropertiesMgr.getInteger("tank-move-speed");
    private final Random random = new Random();
    private final GroupEnum groupEnum;
    private int x;
    private int y;
    public Rectangle rectangle = new Rectangle();

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
        this.rectangle.x = x;
        this.rectangle.y = y;
        this.rectangle.width = SrcMgr.tankWidth;
        this.rectangle.height = SrcMgr.tankHeight;
    }

    public void paint(Graphics g) {
        if (!detectLiving()) return;

        randomDir();
        paintImage(g);
        randomFire();
        move();
        updateRectangle();
    }

    private void move() {
        if (!moving && groupEnum == GroupEnum.Friend) return;

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

        // boundary detection
        if (x < 2) x = 2;
        if (y < 32) y = 32; // windows top bar height 30
        if (x > TankFrame.GAME_WIDTH - SrcMgr.tankWidth - 2) x = TankFrame.GAME_WIDTH - SrcMgr.tankWidth - 2;
        if (y > TankFrame.GAME_HEIGHT - SrcMgr.tankHeight - 2) y = TankFrame.GAME_HEIGHT - SrcMgr.tankHeight - 2;
    }

    public void fire() {
        int bX = x + SrcMgr.tankWidth / 2 - SrcMgr.bulletWidth / 2;
        int bY = y + SrcMgr.tankHeight / 2 - SrcMgr.bulletHeight / 2;

        tankFrame.bullets.add(new Bullet(bX, bY, getDir(), tankFrame, groupEnum));
    }

    public void die() {
        living = false;
    }

    private void randomDir() {
        if (groupEnum == GroupEnum.Enemy && random.nextInt(100) > 97)
            dir = DirectionEnum.values()[random.nextInt(4)];
    }

    private void randomFire() {
        if (groupEnum == GroupEnum.Enemy && random.nextInt(100) > 97)
            fire();
    }

    private void paintImage(Graphics g) {
        switch (dir) {
            case LEFT:
                g.drawImage(groupEnum == GroupEnum.Friend ? SrcMgr.tankL : SrcMgr.enemyTankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(groupEnum == GroupEnum.Friend ? SrcMgr.tankR : SrcMgr.enemyTankR, x, y, null);
                break;
            case UP:
                g.drawImage(groupEnum == GroupEnum.Friend ? SrcMgr.tankU : SrcMgr.enemyTankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(groupEnum == GroupEnum.Friend ? SrcMgr.tankD : SrcMgr.enemyTankD, x, y, null);
                break;
        }
    }

    private boolean detectLiving() {
        if (!living) {
            tankFrame.enemyTanks.remove(this);
            return false;
        }

        return true;
    }

    private void updateRectangle() {
        this.rectangle.x = x;
        this.rectangle.y = y;
    }
}
