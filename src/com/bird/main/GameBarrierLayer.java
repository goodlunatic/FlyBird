package com.bird.main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 游戏障碍物层   Game Barrier Layer
 *
 * @ClassName GameBarrierLayer
 * @Description 游戏障碍物层   Game Barrier Layer
 * @Author 202132110121 202132110159
 * @DATE 2023/4/25 10:57
 * @Version 1.0
 */
public class GameBarrierLayer {
    private GameTime gameTime;
    private int txt;
    private Random random = new Random();
    private List<Barrier> barriers;


    public GameBarrierLayer() {
        gameTime = new GameTime();
        barriers = new ArrayList<>();
    }

    /**
     * 绘制障碍物   Draw barriers
     *
     * @param g    画笔
     * @param bird 鸟
     */
    public void draw(Graphics g, Bird bird) {
        for (int i = 0; i < barriers.size(); i++) {
            Barrier barrier = barriers.get(i);

            if (barrier.isVisible()) {
                barrier.draw(g);
            } else {
                Barrier remove = barriers.remove(i);
                Barrierpool.setPool(remove);
                i--;
            }
        }
        collideBird(bird);
        logic(g);
    }

    /**
     * 游戏逻辑结构    Game logic structure
     *
     * @param g 画笔
     */
    public void logic(Graphics g) {
        if (barriers.size() == 0) {
            ran();
            gameTime.begin();
            insert(600, 0, numberTop, 0);
            insert(600, 500 - numberDown, numberDown, 2);
        } else {
            long differ = gameTime.differ();
            g.setColor(Color.white);
            g.setFont(new Font("微软雅黑", 1, 20));
            g.drawString("坚持了：" + differ + " 秒", 30, 50);
            //判断最后一个障碍物是否完全进入屏幕内(Check if the last obstacle is fully within the screen)
            txt = getTxt();
            if (differ <= txt) {
                g.drawString("最高成绩：" + txt + " 秒", 200, 50);
            } else {
                //保存当前成绩(Save the current score)
                setTxt(String.valueOf(differ));
                g.drawString("最高成绩：" + getTxt(), 200, 50);
            }
            Barrier last = barriers.get(barriers.size() - 1);
            if (last.isInFrame()) {
                ran();
                if (number < 50) {
                    insert(600, 32, 440, 4);
                } else if (number > 450) {
                    insert(600, 125, 200, 6);
                } else {
                    insert(600, 0, numberTop, 0);
                    insert(600, 500 - numberDown, numberDown, 2);
                }

            }
        }
    }

    File file = new File("game.txt");

    /**
     * 用于获取文件中的数据   Used to retrieve data from a file
     *
     * @return int
     */
    public int getTxt() {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int read = 0;
        try {
            read = Integer.parseInt(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return read;
    }

    /**
     * 用于储存数据   Used to store data
     *
     * @param str 字符串数据
     */
    public void setTxt(String str) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriter.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 用于从池中获取对象，并吧参数封装成barrier 存入barriers数组中
     * Used to retrieve objects from the pool, encapsulate the parameters into barriers, and store them in the barriers array
     *
     * @param x    x
     * @param y    y
     * @param num  全国矿工工会
     * @param type 类型
     */
    public void insert(int x, int y, int num, int type) {
        Barrier top = Barrierpool.getPool();
        top.setX(x);
        top.setY(y);
        top.setHeight(num);
        top.setType(type);
        top.setVisible(true);
        barriers.add(top);
    }

    //上方障碍物的高度(Height of the upper obstacle)
    public int numberTop;

    //下方障碍物的高度(Height of the lower obstacle)
    public int numberDown;
    public int number;

    /**
     * 产生两个100-500之间的随机高度   Generates two random heights between 100 and 500
     */
    public void ran() {
        numberTop = random.nextInt(400) + 100;
        numberDown = random.nextInt(400) + 100;
        number = random.nextInt(500);

        //如果管道重合，则重新随机(If the pipes overlap, randomize again)
        if (numberTop + numberDown > 400) {
            ran();
        }
    }

    /**
     * 判断障碍物和小鸟发生碰撞   Checks for collisions between obstacles and the bird
     *
     * @param bird 鸟
     * @return boolean
     */
    public boolean collideBird(Bird bird) {
        for (int i = 0; i < barriers.size(); i++) {
            Barrier barrier = barriers.get(i);
            //判断矩形是否相交(Check if rectangles intersect)
            if (barrier.getRect().intersects(bird.getRect())) {
                System.out.println("撞上啦");
                bird.life = false;
            }
        }
        return false;
    }

    /**
     * 用于清空障碍物的池子   Used to clear the obstacle pool
     */
    public void restant() {
        barriers.clear();
    }
}
