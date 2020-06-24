package com.mikufans.test;

import java.util.ArrayList;
import java.util.List;

public class ThreadTest1
{
    private int j;

    static {
        System.out.println("haha");
    }

    public static void main(String[] args) throws ClassNotFoundException
    {

        Class.forName("com.mikufans.test.ThreadTest1");
    }

    private synchronized void inc()
    {
        j++;
        System.out.println(Thread.currentThread().getName() + "-inc:" + j);
    }

    private synchronized void dec()
    {
        j--;
        System.out.println(Thread.currentThread().getName() + "-dec:" + j);
    }

    class Inc implements Runnable
    {
        @Override
        public void run()
        {
            for (int i = 0; i < 100; i++)
            {
                inc();
            }
        }
    }

    class Dec implements Runnable
    {
        public void run()
        {
            for (int i = 0; i < 100; i++)
            {
                dec();
            }
        }
    }
}
