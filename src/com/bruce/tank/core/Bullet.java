package com.bruce.tank.core;

import com.bruce.tank.enums.DirectionEnum;

import java.awt.*;

public class Bullet {
    private int x;
    private int y;
    private DirectionEnum dir;
    private int moveLength = 3;
    private int width = 30;
    private int height = 30;

    public Bullet(int x, int y, DirectionEnum dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        Color originColor = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, width, height);
        g.setColor(originColor);

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
    }
}
