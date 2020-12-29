package com.bruce.tank.core;

import com.bruce.tank.enums.DirectionEnum;

import java.awt.*;

public class Tank {
    private DirectionEnum dir;
    private boolean isMoving = false;

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public DirectionEnum getDir() {
        return dir;
    }

    public void setDir(DirectionEnum dir) {
        this.dir = dir;
    }

    private final int moveLength = 2;

    private int x = 200;
    private int y = 200;

    public Tank(int x, int y, DirectionEnum dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
        move();
    }

    private void move() {
        if (!isMoving) return;

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
}
