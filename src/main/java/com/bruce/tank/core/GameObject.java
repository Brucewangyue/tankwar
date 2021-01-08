package com.bruce.tank.core;

import java.awt.*;

public abstract class GameObject {
    public abstract void paint(Graphics g);
    public abstract int getX();
    public abstract int getY();
    public abstract int getWidth();
    public abstract int getHeight();
}
