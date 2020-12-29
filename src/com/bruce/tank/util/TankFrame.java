package com.bruce.tank.util;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    private int x = 200;
    private int y = 200;

    public TankFrame() throws HeadlessException {
        this.setSize(600, 400);
        this.setTitle("坦克大战");
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.addKeyListener(new MyKeyListener());

        this.setVisible(true);
    }

    /**
     * 集成 Frame 就是为了重写 paint 方法
     * 当窗口需要重洗绘制时被调用（首次打开窗口，改变窗口大小，缩小再打开，被其他窗口盖住）
     *
     * @param g 画笔
     */
    @Override
    public void paint(Graphics g) {
        System.out.println("调用了 paint");
//        x += 20;
//        y += 20;
        g.fillRect(x, y, 50, 50);
    }

    class MyKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("按下按键");
            x += 30;
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("放开按键");
            y += 30;
            repaint();
        }
    }
}
