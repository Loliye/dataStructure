package com.mikufans.stack;


public class Stack<T>
{
    public int size;
    public int index;
    public T[] arr;

    public Stack(int size)
    {
        this.index = 0;
        this.size = size;
        arr = (T[]) new Object[size];
    }

    public static void main(String[] args)
    {
        Stack<Integer> stack = new Stack<>(5);
        for (int i = 1; i < 11; i++)
            stack.push(i);
        System.out.println("------------------");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.getTop());
        stack.print();
    }

    public void push(T data)
    {
        if (size == index)
        {
            size *= 2;
            T[] old = this.arr;
            this.arr = (T[]) new Object[size];
            for (int i = 0; i < old.length; i++)
                this.arr[i] = old[i];
        }

        int i = index;
        this.arr[i] = data;
        index++;
    }

    public T getTop()
    {
        T top = this.arr[index - 1];
        return top;
    }

    public T pop()
    {
        index--;
        T tmp = this.arr[index];
        this.arr[index] = null;
        return tmp;
    }

    public void print()
    {
        StringBuffer result = new StringBuffer("[bottom:");
        for (T t : arr)
        {
            if (t != null)
            {
                result.append(t + ",");
            } else
            {
                continue;
            }
        }
        result.append(" head]");
        System.out.println(result.toString());
    }
}
