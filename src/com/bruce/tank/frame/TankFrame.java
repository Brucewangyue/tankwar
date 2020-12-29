package com.bruce.tank.frame;

import com.bruce.tank.core.Bullet;
import com.bruce.tank.core.Tank;
import com.bruce.tank.enums.DirectionEnum;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    private Tank myTank = new Tank(200, 200, DirectionEnum.DOWN);
    private Bullet b = new Bullet(300,300,DirectionEnum.DOWN);

    public TankFrame() throws HeadlessException {
        this.setSize(600, 500);
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
        myTank.paint(g);
        b.paint(g);
    }

    class MyKeyListener extends KeyAdapter {
        private boolean bL = false;
        private boolean bR = false;
        private boolean bU = false;
        private boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }

            setDirection();
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
                default:
                    break;
            }

            setDirection();
            repaint();
        }

        private void setDirection() {
            if (!bL && !bR && !bU && !bD) myTank.setMoving(false);
            else {
                if (bL) myTank.setDir(DirectionEnum.LEFT);
                if (bR) myTank.setDir(DirectionEnum.RIGHT);
                if (bU) myTank.setDir(DirectionEnum.UP);
                if (bD) myTank.setDir(DirectionEnum.DOWN);
                myTank.setMoving(true);
            }
        }
    }
}
