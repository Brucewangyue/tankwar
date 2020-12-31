package com.bruce.tank.core;

import com.bruce.tank.util.ImageUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SrcMgr {
    private static final String imagePath = "images/";
    public static BufferedImage tankD, tankU, tankL, tankR;
    public static BufferedImage enemyTankD, enemyTankU, enemyTankL, enemyTankR;
    public static BufferedImage bulletD, bulletU, bulletL, bulletR;
    public static int bulletWidth, bulletHeight;
    public static int tankWidth, tankHeight;
    public static BufferedImage[] tankExplodeImages = new BufferedImage[16];
    public static int tankExplodeWidth, tankExplodeHeight;

    static {
        try {
            ClassLoader cl = Tank.class.getClassLoader();

            // 旧版图片
//            tankD = ImageIO.read(cl.getResourceAsStream(imagePath + "tankD.gif"));
//            tankU = ImageIO.read(cl.getResourceAsStream(imagePath + "tankU.gif"));
//            tankL = ImageIO.read(cl.getResourceAsStream(imagePath + "tankL.gif"));
//            tankR = ImageIO.read(cl.getResourceAsStream(imagePath + "tankR.gif"));
//            bulletD = ImageIO.read(cl.getResourceAsStream(imagePath + "bulletD.gif"));
//            bulletU = ImageIO.read(cl.getResourceAsStream(imagePath + "bulletU.gif"));
//            bulletL = ImageIO.read(cl.getResourceAsStream(imagePath + "bulletL.gif"));
//            bulletR = ImageIO.read(cl.getResourceAsStream(imagePath + "bulletR.gif"));

            // 新版图片-由角度创建
            tankU = ImageIO.read(cl.getResourceAsStream(imagePath + "GoodTank1.png"));
            tankD = ImageUtil.rotateImage(tankU, 180);
            tankL = ImageUtil.rotateImage(tankU, -90);
            tankR = ImageUtil.rotateImage(tankU, 90);

            enemyTankU = ImageIO.read(cl.getResourceAsStream(imagePath + "BadTank1.png"));
            enemyTankD = ImageUtil.rotateImage(enemyTankU, 180);
            enemyTankL = ImageUtil.rotateImage(enemyTankU, -90);
            enemyTankR = ImageUtil.rotateImage(enemyTankU, 90);

            bulletU = ImageIO.read(cl.getResourceAsStream(imagePath + "BulletU.png"));
            bulletD = ImageUtil.rotateImage(bulletU, 180);
            bulletL = ImageUtil.rotateImage(bulletU, -90);
            bulletR = ImageUtil.rotateImage(bulletU, 90);

            for (int i = 0; i < tankExplodeImages.length; i++) {
                tankExplodeImages[i] = ImageIO.read(cl.getResourceAsStream(imagePath + "e" + (i + 1) + ".gif"));
            }

            tankWidth = tankD.getWidth();
            tankHeight = tankD.getHeight();
            bulletWidth = bulletD.getWidth();
            bulletHeight = bulletD.getHeight();
            tankExplodeWidth = tankExplodeImages[0].getWidth();
            tankExplodeHeight = tankExplodeImages[0].getHeight();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
