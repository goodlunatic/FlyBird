package com.bird.main;
//导入了一个静态的包

import static com.bird.util.Constant.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/**
 * 游戏框架   Game Framework
 *
 * @ClassName GameFrame
 * @Description 游戏框架类，用于创建游戏窗口和处理游戏逻辑
 * @Author 202132110121 202132110159
 * @DATE 2023/05/13 23:13
 * @Version 1.0
 */
//创建一个继承自Frame类的GameFrame类，这样这个类就有了创建窗口的功能
public class GameFrame extends Frame {
    /**
     * 实例化GameBackGround类(Instantiate GameBackGround class)
     */
    private GameBackGround gameBackGround;
    /**
     * 实例化GameBarrierLayer类(Instantiate GameBarrierLayer class)
     */
    private GameBarrierLayer gameBarrierLayer;
    /**
     * 实例化GameFrontGround类(Instantiate GameFrontGround class)
     */
    private GameFrontGround gameFrontGround;
    //实例化bluebird(Instantiate bluebird)
    private Bird bird;
    //存放图片的图片(Store the image)
    private BufferedImage buffimg = new BufferedImage(FRAM_WIDTH, FRAM_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);

    public GameFrame() {
        //窗口是否可见(Whether the window is visible)
        setVisible(true);
        //窗口大小(Window size)
        setSize(FRAM_WIDTH, FRAM_HEIGHT);
        //设置窗口标题(Set window title)
        setTitle(FRAM_TITLE);
        //窗口的初始化位置(Initial position of the window)
        setLocation(FRAM_X, FRAM_Y);
        //窗口大小不可改变(Window size cannot be changed)
        setResizable(false);
        //窗口的关闭事件(Window closing event)
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);//结束程序
            }
        });
        //初始化游戏对象(Initialize game objects)
        initGame();
        new run().start();
        //添加按键监听(Add keystroke listener)
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                add(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                minu(e);
            }
        });
        //添加鼠标监听(Add mouse motion listener)
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                Moved(e);
            }
        });
    }

    /**
     * 初始化游戏中的对象   Initialize objects in the game
     */
    public void initGame() {
        gameBackGround = new GameBackGround();
//        bird = new blueBird();
//        bird = new ikunBird();
        bird = new redBird();
        gameFrontGround = new GameFrontGround();
        gameBarrierLayer = new GameBarrierLayer();
    }

    /**
     * 游戏界面刷新线程   Game interface refresh thread
     */
    class run extends Thread {
        @Override
        public void run() {
            while (true) {
                repaint();
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 更新   update
     *
     * @param g 画笔
     */
    @Override
    public void update(Graphics g) {
        if (bird.life) {
            //得到图片的画笔(Get the graphics of the image)
            Graphics graphics = buffimg.getGraphics();
            gameBackGround.draw(graphics);
            bird.draw(graphics);
            gameFrontGround.draw(graphics);
            gameBarrierLayer.draw(graphics, bird);
            //一次性的将图片绘制到屏幕中(Draw the image to the screen at once)
            g.drawImage(buffimg, 0, 0, null);
        } else {
            String over = "Game Over";
            g.setColor(Color.red);
            g.setFont(new Font("微软雅黑", 1, 60));
            g.drawString(over, 130, 250);
            String reset = "Space Reset Game";
            g.drawString(reset, 25, 350);
        }
    }

    /**
     * 处理按键按下事件   Handle key press events
     *
     * @param e KeyEvent对象
     */
    public void add(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                bird.fly(1);
                break;
            case KeyEvent.VK_SPACE:
                if (bird.life == false) {
                    restart();
                }
                break;
            case KeyEvent.VK_1:
                System.out.println("When the \"1\" key on the keyboard is pressed, switch to the blueBird form.\n");
                bird = new blueBird();
                break;
            case KeyEvent.VK_2:
                System.out.println("When the \"2\" key on the keyboard is pressed, switch to the redBird form.\n");
                bird = new redBird();
                break;
            case KeyEvent.VK_3:
                System.out.println("When the \"3\" key on the keyboard is pressed, switch to the ikunBird form.\n");
                bird = new ikunBird();
                break;
            case KeyEvent.VK_CONTROL:
                System.out.println("When the \"CTRL\" key on the keyboard is pressed.\n");
                System.out.println("-----------------------The bird is now controlled by the mouse.-----------------------\n");
                bird.controlflag = true;
                break;
            case KeyEvent.VK_SHIFT:
                System.out.println("When the \"SHIFT\" key on the keyboard is pressed.\n");
                System.out.println("-----------------------The bird is now controlled by the keyboard.-----------------------");
                bird.controlflag = false;
                break;
        }
    }

    /**
     * 处理按键抬起事件    Handle key release events
     *
     * @param e KeyEvent对象
     */
    public void minu(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                bird.fly(5);
                break;
        }
    }

    /**
     * 实现鼠标移动事件  Implement mouse-over events
     */
    public void Moved(MouseEvent e) {
        // 获取鼠标当前位置
        int mouseX = e.getX();
        int mouseY = e.getY();
        System.out.println("此时鼠标的坐标为：" + '(' + mouseX + ',' + mouseY + ')');
        // 更新小鸟的位置为鼠标的位置
        if (bird.controlflag == true) {
            bird.setX(mouseX);
            bird.setY(mouseY);
        }
    }

    /**
     * 重置游戏   Reset the game
     */
    public void restart() {
        gameBarrierLayer.restant();
        bird.restartDraw();
    }
}

