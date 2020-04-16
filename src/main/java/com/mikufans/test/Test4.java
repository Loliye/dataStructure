package com.mikufans.test;

public class Test4
{
    public static void main(String[] args)
    {
        new Thread(new MyThread(0)).start();
        new Thread(new MyThread(1)).start();
        new Thread(new MyThread(2)).start();
    }
}

class MyThread implements Runnable
{
    static final Object lock = new Object();

    static volatile int  state;

    int which;

    public MyThread(int which)
    {
        this.which = which;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 3; i++)
        {
            synchronized (lock)
            {
                while (state % 3 != which)
                {
                    try
                    {
                        lock.wait();

                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                System.out.print(which);
                state++;
                lock.notifyAll();
            }
        }
    }
}
