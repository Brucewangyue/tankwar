package com.bruce.tank.frame;

import com.bruce.tank.core.Bullet;
import com.bruce.tank.core.Tank;
import com.bruce.tank.core.TankExplode;
import com.bruce.tank.enums.DirectionEnum;
import com.bruce.tank.enums.GroupEnum;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {
    private static TankFrame INSTANCE = new TankFrame();

    private TankFrame() throws HeadlessException {
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setResizable(false);
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

    public static TankFrame getInstance() {
        return INSTANCE;
    }

    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;

    private Tank myTank = new Tank(200, 200, DirectionEnum.UP, this, GroupEnum.Friend);
    public List<Bullet> bullets = new ArrayList<>();
    public List<Tank> enemyTanks = new ArrayList<>();
    public List<TankExplode> tankExplodes = new ArrayList<>();

    /**
     * 集成 Frame 就是为了重写 paint 方法
     * 当窗口需要重洗绘制时被调用（首次打开窗口，改变窗口大小，缩小再打开，被其他窗口盖住）
     *
     * @param g 画笔
     */
    @Override
    public void paint(Graphics g) {
        paintBulletCountText(g);
        paintEnemyTankCountText(g);
        myTank.paint(g);

        // bullets
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }

        // enemy tanks
        for (int i = 0; i < enemyTanks.size(); i++) {
            enemyTanks.get(i).paint(g);
        }

        // tank explode
        for (int i = 0; i < tankExplodes.size(); i++) {
            tankExplodes.get(i).paint(g);
        }

        // bullet collide tank detect
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < enemyTanks.size(); j++)
                bullets.get(i).collideEnemyTank(enemyTanks.get(j));
        }

        // 安全删除集合方案2
//        for(Iterator<Bullet> it = bullets.iterator(); it.hasNext();){
//            Bullet next = it.next();
//            if(next.living)
//                bullets.remove(next);
//        }
    }

    private void paintBulletCountText(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("主坦克发射了 " + bullets.size() + " 颗子弹", 20, 50);
        g.setColor(c);
    }

    private void paintEnemyTankCountText(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("敌方坦克发数量 " + enemyTanks.size(), 20, 70);
        g.setColor(c);
    }

    /**
     * 图片
     */
    Image offScreenImage = null;

    /**
     * 在 paint 之前调用
     *
     * @param g
     */
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        // 先在内存中画
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(new Color(13, 17, 23));
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        // 从内存中一次性显示
        g.drawImage(offScreenImage, 0, 0, null);
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
                case KeyEvent.VK_SPACE:
                    myTank.fire();
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
