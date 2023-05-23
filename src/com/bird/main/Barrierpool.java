package com.bird.main;

import java.util.ArrayList;
import java.util.List;

/**
 * 障碍物池 Barrier pool
 *
 * @ClassName Barrierpool
 * @Description 障碍物池 Barrier pool
 * @Author 202132110121 202132110159
 * @DATE 2023/4/25 13:47
 * @Version 1.0
 */
public class Barrierpool {
    //用于管理池中所有对象的容器(A container for managing all objects in the pool)
    private static List<Barrier> pool = new ArrayList<>();
    //池中初始的对象个数(The initial number of objects in the pool)
    public static final int initCount = 16;
    //对象池中最大个数(Maximum number of objects in the pool)
    public static final int maxCOunt = 20;

    static {
        //初始化池中的对象(Initialize the objects in the pool)
        for (int i = 0; i < initCount; i++) {
            pool.add(new Barrier());
        }
    }

    /**
     * 从池中获取一个对象  Get an object from the pool
     *
     * @return {@link Barrier}
     */
    public static Barrier getPool() {
        int size = pool.size();
        //如果池中有对象才可以拿(You can only take an object if there is one in the pool)
        if (size > 0) {
            //移除并返回对象(Remove and return the object)
            System.out.println("[-]Took an object out of the pool");
            return pool.remove(size - 1);
        } else {
            //池中没有对象了 只能new(There are no more objects in the pool, only new)
            System.out.println("[+]A new object is created in the pool");
            return new Barrier();
        }
    }

    /**
     * 将对象归还容器中
     *
     * @param barrier 障碍
     */
    public static void setPool(Barrier barrier) {
        if (pool.size() < maxCOunt) {
            pool.add(barrier);
            System.out.println("[*]The object is returned to the container");
        }
    }

}
