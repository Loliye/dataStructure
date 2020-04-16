package com.mikufans.test;

public class Test
{
    public static void main(String[] args) throws Exception
    {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        Object d = new Object();
        Object e = new Object();
        ThreadPrinter pa = new ThreadPrinter("A", e, a);
        ThreadPrinter pb = new ThreadPrinter("B", a, b);
        ThreadPrinter pc = new ThreadPrinter("C", b, c);
        ThreadPrinter pd = new ThreadPrinter("D", c, d);
        ThreadPrinter pe = new ThreadPrinter("E\n", d, e);

        new Thread(pa).start();
        new Thread(pb).start();
        new Thread(pc).start();
        new Thread(pd).start();
        new Thread(pe).start();

    }

    public static class ThreadPrinter implements Runnable
    {
        private String name;
        private Object prev;
        private Object self;

        private ThreadPrinter(String name, Object prev, Object self)
        {
            this.name = name;
            this.prev = prev;
            this.self = self;
        }

        @Override
        public void run()
        {
            int count = 5;
            while (count > 0)
                synchronized (prev)
                {

                    synchronized (self)
                    {
                        System.out.print(name);
                        count--;

                        self.notify();
                    }

                    try
                    {
                        Thread.sleep(2000);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }


                    try
                    {
                        if (count != 0)
                            prev.wait();
                        else prev.notify();
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
        }
    }
}
