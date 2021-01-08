package com.bruce.tank.core;

import java.awt.*;

public class RectGameObjectDecorator extends GameObjectDecorator {

    public RectGameObjectDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        go.paint(g);

        // 给子弹添加一个矩形包围
        g.drawRect(go.getX(), go.getY(), go.getWidth() + 1, go.getHeight() + 1);
    }
}
