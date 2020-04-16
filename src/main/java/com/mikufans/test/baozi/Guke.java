package com.mikufans.test.baozi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Guke implements Runnable
{


    static BaoZi bz = new BaoZi();
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public Guke()
    {

    }

    public static void main(String[] args)
    {
        new Thread(new BaoZiPu()).start();
        new Thread(new Guke()).start();

    }


    public void run1()
    {
        //        Lock lock=new ReentrantLock();
        //        lock.lock();
        //        try{
        while (true)
        {
            synchronized (bz)
            {
                if (bz.flag == false)
                {
                    try
                    {
                        bz.wait();
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                System.out.println("开始吃" + bz.pi + bz.xian + "包子");
                bz.flag = false;
                //                lock.unlock();
                bz.notify();
                System.out.println("已经吃完了" + bz.pi + bz.xian + "包子开始生产包子\n");
                //            }
            }
            //        }finally {
            //            lock.unlock();
        }
    }

    @Override
    public void run()
    {

        lock.lock();
        try
        {
            while (true)
            {

                if (bz.flag == false)
                {
                    condition.await();
                }
                System.out.println("开始吃" + bz.pi + bz.xian + "包子");
                bz.flag = false;
                condition.signal();
                System.out.println("已经吃完了" + bz.pi + bz.xian + "包子开始生产包子");
                Thread.sleep(1000);

            }
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            lock.unlock();
        }
    }


}
