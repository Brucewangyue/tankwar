package com.bruce.tank.core;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SrcMgr {
    private static final String imagePath = "images/";
    public static BufferedImage tankD, tankU, tankL, tankR;
    public static BufferedImage bulletD, bulletU, bulletL, bulletR;
    public static int bulletWidth, bulletHeight;
    public static int tankWidth, tankHeight;
    public static BufferedImage[] tankExplodeImages = new BufferedImage[16];

    static {
        try {
            ClassLoader cl = Tank.class.getClassLoader();

            tankD = ImageIO.read(cl.getResourceAsStream(imagePath + "tankD.gif"));
            tankU = ImageIO.read(cl.getResourceAsStream(imagePath + "tankU.gif"));
            tankL = ImageIO.read(cl.getResourceAsStream(imagePath + "tankL.gif"));
            tankR = ImageIO.read(cl.getResourceAsStream(imagePath + "tankR.gif"));
            tankWidth = tankD.getWidth();
            tankHeight = tankD.getHeight();

            bulletD = ImageIO.read(cl.getResourceAsStream(imagePath + "bulletD.gif"));
            bulletU = ImageIO.read(cl.getResourceAsStream(imagePath + "bulletU.gif"));
            bulletL = ImageIO.read(cl.getResourceAsStream(imagePath + "bulletL.gif"));
            bulletR = ImageIO.read(cl.getResourceAsStream(imagePath + "bulletR.gif"));
            bulletWidth = bulletD.getWidth();
            bulletHeight = bulletD.getHeight();

            for (int i = 0; i < tankExplodeImages.length; i++) {
                tankExplodeImages[i] = ImageIO.read(cl.getResourceAsStream(imagePath + "e" + (i + 1) + ".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
