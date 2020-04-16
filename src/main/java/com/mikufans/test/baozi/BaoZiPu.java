package com.mikufans.test.baozi;

import static com.mikufans.test.baozi.Guke.*;

public class BaoZiPu implements Runnable
{


    public BaoZiPu()
    {
    }


    @Override
    public void run()
    {
        int count = 0;
        lock.lock();
        try
        {
            while (true)
            {
                if (bz.flag == true)
                {
                    condition.await();
                }

                if (count % 2 == 1)
                {
                    bz.pi = "薄皮";
                    bz.xian = "三鲜";
                } else
                {
                    bz.pi = "冰皮";
                    bz.xian = "牛肉";
                }
                count++;
                System.out.println("包子铺正在生产：" + bz.pi + bz.xian);
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                bz.flag = true;

                condition.signal();
                System.out.println("包子铺已经生产好了：" + bz.pi + bz.xian);
            }


        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } finally
        {
            lock.unlock();
        }
    }

    public void run1()
    {
        int count = 0;
        //        Lock lock=new ReentrantLock();
        //        lock.lock();
        //        try{
        while (true)
        {
            synchronized (bz)
            {
                if (bz.flag == true)
                {
                    try
                    {
                        bz.wait();
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                if (count % 2 == 0)
                {
                    bz.pi = "薄皮";
                    bz.xian = "三鲜";
                } else
                {
                    bz.pi = "冰皮";
                    bz.xian = "牛肉";
                }
                count++;
                System.out.println("包子铺正在生产：" + bz.pi + bz.xian);
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                bz.flag = true;
                //                lock.unlock();
                bz.notify();
                System.out.println("包子铺已经生产好了：" + bz.pi + bz.xian);
            }
            //        }finally {
            //            lock.unlock();
        }
    }


}

