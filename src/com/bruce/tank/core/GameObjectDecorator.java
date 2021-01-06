package com.bruce.tank.core;

import java.awt.*;

/**
 * 在 java IO 中使用了装饰器模式
 */
public abstract class GameObjectDecorator extends GameObject {

    GameObject go;

    public GameObjectDecorator(GameObject go) {
        this.go = go;
    }

    public abstract void paint(Graphics g);

    @Override
    public int getX() {
        return go.getX();
    }

    @Override
    public int getY() {
        return go.getY();
    }

    @Override
    public int getWidth() {
        return go.getWidth();
    }

    @Override
    public int getHeight() {
        return go.getHeight();
    }
}
