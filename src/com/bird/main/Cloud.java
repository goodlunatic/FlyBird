package com.bird.main;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 云
 *
 * @ClassName Cloud
 * @Description Cloud
 * @Author 202132110121 202132110159
 * @DATE 2023/4/25 8:41
 * @Version 1.0
 */
public class Cloud {
    //云彩图片(Cloud Pictures)
    private BufferedImage img;
    //云彩的速度(Cloud Speed)
    private int speed;
    //云彩的位置(Cloud Position)
    private int x, y;

    public Cloud() {
    }

    public Cloud(BufferedImage img, int speed, int x, int y) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    /**
     * 绘制云   draw the cloud
     *
     * @param g 画笔
     */
    public void draw(Graphics g) {
        x -= speed;
        g.drawImage(img, x, y, null);
    }

    /**
     * 用于判断云彩是否飞出屏幕外   Used to determine if clouds are flying off the screen
     *
     * @return boolean
     */
    public boolean isOutFrame() {
        if (x < -100) {
            return true;
        }
        return false;
    }
}
