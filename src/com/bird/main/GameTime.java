package com.bird.main;

/**
 * 记录游戏时间   Game time record
 *
 * @ClassName GameTime
 * @Description 记录游戏时间
 * @Author 202132110121 202132110159
 * @DATE 2023/4/25 21:47
 * @Version 1.0
 */
public class GameTime {
    //计时(Timing)
    private long beginTime;
    private long endTime;
    private long differ;

    public GameTime() {
    }

    /**
     * 获取开始时间   Get the start time
     */
    public void begin() {
        beginTime = System.currentTimeMillis();
    }

    /**
     * 获取坚持的时间长度   Get the duration of time persisted
     *
     * @return long
     */
    public long differ() {
        endTime = System.currentTimeMillis();
        return differ = (endTime - beginTime) / 1000;
    }
}
