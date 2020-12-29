package com.bruce.tank.frame;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    private int moveLength = 2;

    private boolean bL = false;
    private boolean bR = false;
    private boolean bU = false;
    private boolean bD = false;

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
        System.out.println("L:" + bL + ",R:" + bR + ",U:" + bU + ",D:" + bD);
        g.fillRect(x, y, 50, 50);
    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
//                    x -= moveLength;
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
//                    x += moveLength;
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
//                    y -= moveLength;
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
//                    y += moveLength;
                    bD = true;
                    break;
            }

            if(bL)
                x -= moveLength;
            if(bR)
                x += moveLength;
            if(bU)
                y -= moveLength;
            if(bD)
                y += moveLength;

            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
            }
            repaint();
        }
    }
}
