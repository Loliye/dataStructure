package com.mikufans.test.baozi;

public class Demo
{


    static
    {
        a = 2;
        System.out.println("haha");
    }
    public static int a = 0;

    public int i;
    public int x;

    public Demo()
    {
    }

    public Demo(int i, int x)
    {
        this.i = i;
        this.x = x;
    }

    public static void main(String[] args)
    {
        System.out.println(a);
    }

    public int getI()
    {
        return i;
    }

    public void setI(int i)
    {
        this.i = i;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }
}
