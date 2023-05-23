package com.bird.main;

import com.bird.util.Constant;
import com.bird.util.Gameutil;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.bird.util.Constant.*;


/**
 * 游戏背景   GameBackGround
 *
 * @ClassName GameBackGround
 * @Description 游戏背景类
 * @Author 202132110121 202132110159
 * @DATE 2023/4/24 18:28
 * @Version 1.0
 */
public class GameBackGround {
    //背景需要的资源图片(Background need for resource images)
    private BufferedImage bkimg;

    /**
     * 构造器初始化资源    Constructor initialization resources
     */
    public GameBackGround() {
        bkimg = Gameutil.loadBufferedImage(Constant.BK_IMG_PATH);
    }

    /**
     * 自定义一个绘制方法   Customize a drawing method
     *
     * @param g 画笔
     */
    public void draw(Graphics g) {
        //填充背景色(Fill background color)
        g.setColor(BK_COLOR);
        g.fillRect(0, 0, FRAM_WIDTH, FRAM_HEIGHT);
        g.setColor(Color.black);
        //得到图片的高度和宽度(Get the height and width of the image)
        int height = bkimg.getHeight();
        int width = bkimg.getWidth();
        //所需要图片的张数(Number of pictures needed)
        int count = Constant.FRAM_WIDTH / width + 1;
        //绘制图片-循环的次数(Number of times to draw picture-loop)
        for (int i = 0; i < count; i++) {
            g.drawImage(bkimg, width * i, Constant.FRAM_HEIGHT - height, null);
        }
    }
}
