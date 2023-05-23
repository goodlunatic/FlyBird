# Fly Bird
## Overview

基于Java基础类库编写的Flappy Bird桌面平台版。

具备原版所有功能，相较原版加入了移动型水管、优化了游戏的难度。

## How to play

* 通过 ```java -jar FlappyBird.jar```直接运行

* 运行源码中的方法

游戏使用键盘上键盘或者鼠标操作。

每局游戏随机刷新所有元素，小鸟受到重力作用会不断下坠，敲击空格键使小鸟振翅向上飞，游戏过程中需要玩家控制小鸟不断飞行，并注意躲避随机生成的水管，得分是按照坚持的时间计算，飞行过程中如果撞到水管或掉落在地则游戏结束。


## Preview

* Game start

  ![image-20230523124146962](img\\image-20230523124146962.png)

![image-20230523123847205](img\image-20230523123847205.png)

![image-20230523124028399](img\image-20230523124028399.png)

* Game over

![image-20230523124507983](img\image-20230523124507983.png)

## Notes

* 文本编码格式为UTF-8，若注释出现乱码请修改编译器的文本编码格式

## Package Contents
### com.bird

#### app

GameApp——游戏应用程序 Game applications

### main

Barrier——障碍物类
Barrierpool——障碍物池
Bird——鸟类
blueBird——blueBird类
Cloud——云类
GameBackGround——游戏背景类
GameBarrierLayer——游戏障碍物类
GameFrame——游戏框架类
GameFrontGround——游戏前景类
GameTime——游戏时间类
ikunBird——ikunBrid类
redBird——redBird类

## Change Log

v1.3.0 - May 20, 2023

* 优化了游戏的难度，更改了控制小鸟的方式，按键盘上的Ctrl键即可切换为鼠标控制

  按键盘上的Alt键即可恢复为为键盘上键控制

v1.2.0 - May 18, 2023

* 利用抽象类和继承，添加了小鸟的三种形态：BlueBird、RedBird、ikunBird、

  按键盘上数字键的1、2、3键即可切换形态

v1.1.0 - May 11, 2023

* 添加了中间悬浮型的的障碍物以及会上下移动的障碍物

v1.0.0 - May 10, 2023

* 具备简单的小鸟躲避障碍物的功能
