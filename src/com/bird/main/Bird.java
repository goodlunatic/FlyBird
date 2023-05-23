package com.bird.main;

import static com.bird.util.Constant.*;

import com.bird.util.Gameutil;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 鸟类
 *
 * @ClassName Bird
 * @Description 鸟类
 * @Author 202132110121 202132110159
 * @DATE 2023/4/24 19:02
 * @Version 1.0
 */
public abstract class Bird {
    //小鸟矩形对象(Bird rectangle object)
    public Rectangle rect;
    //小鸟加速度(Bird acceleration)
    public int acceleration;
    //小鸟的生命(Bird life)
    public boolean life = true;
    //存放小鸟的图片(Bird images)
    public BufferedImage[] images;
    public static final int BIRD_IMG_COUNT = 3;
    public String[] BIRD_IMG;
    //鸟的状态(Bird status)
    public int status;
    public static final int STATE_NORMAL = 0;//向前飞(Fly forward)
    public static final int STATE_UP = 1;//向上飞(Fly upward)
    public static final int STATE_DOWN = 2;//向下飞(Fly downward)
    //小鸟的位置(Bird position)
    public int x = 200, y = 200;
    //小鸟移动的方向 上下(Direction of the bird's movement Up and down)
    public boolean up = false, down = false;
    //小鸟移动速度(Bird movement speed)
    public int speed = 4;
    public boolean controlflag = false;

    /**
     * 绘制小鸟   Draw the bird
     *
     * @param g 画笔
     */
    public void draw(Graphics g) {
        if (!controlflag) {
//            System.out.println(controlflag);
            flyLogic();
        }
        g.drawImage(images[status], x, y, null);
        rect.x = this.x;
        rect.y = this.y;
    }

    /**
     * 控制小鸟移动方向   Control the direction of movement of the bird
     */
//    public void flyLogic() {
//        if (up) {
//            acceleration--;
//            y += acceleration;
//            if (acceleration < -10) {
//                acceleration = -10;
//            }
//            if (y < 20) {
//                y = 20;
//                acceleration = 0;
//            }
//        }
//        if (!up) {
//            acceleration++;
//            y += acceleration;
//            if (acceleration > 10) {
//                acceleration = 10;
//            }
//            if (y > 475) {
//                y = 475;
//                acceleration = 0;
//            }
//        }
//    }
    public abstract void flyLogic();

    /**
     * 飞行状态   fly status
     *
     * @param fly 飞行状态
     */
    public void fly(int fly) {
        switch (fly) {
            case 1:
                status = 1;
                up = true;
                break;
            case 5:
                status = 2;
                up = false;
                break;
        }
    }

    public Rectangle getRect() {
        return rect;
    }

    /**
     * 重新绘制小鸟的位置   Redraw the position of the bird
     */
    public void restartDraw() {
        life = true;
        x = 200;
        y = 200;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
