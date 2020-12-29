package com.bruce.tank.core;

import com.bruce.tank.enums.DirectionEnum;
import com.bruce.tank.frame.TankFrame;

import java.awt.*;

public class Bullet {
    private int x;
    private int y;
    private DirectionEnum dir;
    private int moveLength = 10;
    private int width = 30;
    private int height = 30;
    private TankFrame tankFrame;
    private boolean living = true;

    public Bullet(int x, int y, DirectionEnum dir, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g) {
        if (!living) {
            tankFrame.bullets.remove(this);
            return;
        }

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

        if (x < 0 || y < 0 || x > tankFrame.GAME_WIDTH || y > tankFrame.GAME_HEIGHT) living = false;
    }
}
