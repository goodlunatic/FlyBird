package com.bird.main;

import com.bird.util.Gameutil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 游戏前景   Game FrontGround
 *
 * @ClassName GameFrontGround
 * @Description 游戏前景   Game FrontGround
 * @Author 202132110121 202132110159
 * @DATE 2023/4/25 8:45
 * @Version 1.0
 */
public class GameFrontGround {
    //云彩的个数(Number of clouds)
    private static final int CLOUD_COUNT = 2;
    //存放云彩的容器(Container for clouds)
    private List<Cloud> clouds;
    //云彩的飞行速度(Cloud flying speed)
    private static final int CLOUD_SPEED = 1;
    //使用到的图片资源(Image resources used)
    private BufferedImage[] img;
    //用于产生随机数(Random number generator)
    private Random random;

    /**
     * 构造器来初始化数据   Constructor to initialize data
     */
    public GameFrontGround() {
        clouds = new ArrayList<>();
        img = new BufferedImage[CLOUD_COUNT];
        //往容器中添加云彩的图片(Add cloud images to the container)
        for (int i = 0; i < CLOUD_COUNT; i++) {
            img[i] = Gameutil.loadBufferedImage("img/cloud" + i + ".png");
        }
        random = new Random();
    }

    /**
     * 绘制云彩   Draw clouds
     *
     * @param g 画笔
     */
    public void draw(Graphics g) {
        logic();
        for (int i = 0; i < clouds.size(); i++) {
            clouds.get(i).draw(g);
        }
    }

    /**
     * 用于云彩个数的控制   Control the number of clouds
     */
    private void logic() {
        if ((int) 500 * Math.random() < 10) {
            Cloud cloud = new Cloud(img[random.nextInt(CLOUD_COUNT)], CLOUD_SPEED, 600, random.nextInt(150));
            clouds.add(cloud);
        }
        for (int i = 0; i < clouds.size(); i++) {
            Cloud cloud = clouds.get(i);
            if (cloud.isOutFrame()) {
                clouds.remove(i);
                i--;
                System.out.println("云被移除" + cloud);
            }
        }
    }
}
