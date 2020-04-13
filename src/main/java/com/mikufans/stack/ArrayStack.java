package com.mikufans.stack;

public class ArrayStack
{
    private Integer arr[];
    private int count;
    private int size;

    public ArrayStack(int size)
    {
        this.size = size;
        this.arr = new Integer[size];
        this.count = 0;
    }

    public void push(Integer value)
    {
        if (this.count < this.size)
        {
            arr[count] = value;
            count++;
        }
    }

    private void expand(Integer[] old, int size)
    {
        Integer newArr[] = new Integer[size * 2];
        for (int i = 0; i < old.length; i++)
            newArr[i] = old[i];

        this.count = old.length;
        this.size = old.length * 2;
        this.arr = newArr;
    }

    public Integer pop()
    {
        if (count == 0)
            return null;

        count--;
        return this.arr[count];
    }

    public void print()
    {
        for (int a : arr)
        {
            System.out.println(a);
        }
    }

    public static void main(String[] args)
    {

    }
}
