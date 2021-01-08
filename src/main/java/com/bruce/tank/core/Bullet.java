package com.bruce.tank.core;

import com.bruce.tank.enums.DirectionEnum;
import com.bruce.tank.enums.GroupEnum;
import com.bruce.tank.frame.TankFrame;

import java.awt.*;

public class Bullet extends GameObject {
    private int x;
    private int y;
    private final DirectionEnum dir;
    private final int moveLength = 10;
    private final TankFrame tankFrame;
    private boolean living = true;
    private final GroupEnum groupEnum;
    private Rectangle rectangle = new Rectangle();

    public Bullet(int x, int y, DirectionEnum dir, TankFrame tankFrame, GroupEnum groupEnum) {
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

    @Override
    public void paint(Graphics g) {
        if (!detectLiving()) return;

        paintImage(g);
        move();
        updateRectangle();
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return SrcMgr.bulletWidth;
    }

    @Override
    public int getHeight() {
        return SrcMgr.bulletHeight;
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

        // boundary detection
        if (x < 0 || y < 0 || x > tankFrame.GAME_WIDTH || y > tankFrame.GAME_HEIGHT) living = false;
    }

    private void paintImage(Graphics g) {
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
    }

    public void collideEnemyTank(Tank tank) {
        if (groupEnum == tank.getGroupEnum()) return;

        if (rectangle.intersects(tank.rectangle)) {
            die();
            tank.die();

            // it exploded in the center of the tank
            int explodeX = tank.getX() + SrcMgr.tankWidth / 2 - SrcMgr.tankExplodeWidth / 2;
            int explodeY = tank.getY() + SrcMgr.tankHeight / 2 - SrcMgr.tankExplodeHeight / 2;
            tankFrame.tankExplodes.add(new TankExplode(explodeX, explodeY, tankFrame));
        }
    }

    private boolean detectLiving() {
        if (!living) {
            tankFrame.bullets.remove(this);
            return false;
        }

        return true;
    }

    private void die() {
        living = false;
    }

    private void updateRectangle() {
        this.rectangle.x = x;
        this.rectangle.y = y;
    }
}
