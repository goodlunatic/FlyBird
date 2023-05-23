package com.bird.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 一个用于装载图片的工具类   A utility class for loading images
 *
 * @ClassName Gameutil
 * @Description 一个用于装载图片的工具类
 * @Author 202132110121 202132110159
 * @DATE 2023/4/24 18:30
 * @Version 1.0
 */
public class Gameutil {
    /**
     * 装载图片   Load an image
     *
     * @param imgPath img路径
     * @return {@link BufferedImage}
     */
    public static BufferedImage loadBufferedImage(String imgPath) {
        try {
            return ImageIO.read(new FileInputStream(imgPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
