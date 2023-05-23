package com.bird.util;

import javax.swing.*;
import java.awt.*;

/**
 * 游戏中的一些常量   Constants in the game
 *
 * @ClassName Constant
 * @Description 游戏中的一些常量
 * @Author 202132110121 202132110159
 * @DATE 2023/4/23 23:16
 * @Version 1.0
 */
public class Constant {
    //设置窗口大小(Set window size)
    public static final int FRAM_WIDTH = 600;
    public static final int FRAM_HEIGHT = 500;
    //设置窗口标题(Set window title)
    public static final String FRAM_TITLE = "Fly Bird";
    public static final int FRAM_X = 200;
    public static final int FRAM_Y = 200;
    //背景图片路径(Background image path)
    public static final String BK_IMG_PATH = "img/background.png";
    //游戏背景的颜色(Game background color)
    public static final Color BK_COLOR = new Color(0x4B4CF);
    //小鸟的图片资源(Bird image resources)
    public static final String[] BLUEBIRD_IMG = {"img/bird_normal.png", "img/bird_up.png", "img/bird_down.png"};
    public static final String[] REDBIRD_IMG = {"img/bird2_normal.png", "img/bird2_up.png", "img/bird2_down.png"};
    public static final String[] IKUNBIRD_IMG = {"img/bird3_normal.png", "img/bird3_up.png", "img/bird3_down.png"};
    public static final String[] BARRIER_IMG_PATH = {"img/barrier.png", "img/barrier_up.png", "img/barrier_down.png"};
}
