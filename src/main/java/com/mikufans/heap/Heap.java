package com.mikufans.heap;

/**
 * 最大堆
 */
public class Heap
{
    private int[] a;
    private int maxSize;
    private int count;


    public Heap(int maxSize)
    {
        this.maxSize = maxSize;
        a = new int[maxSize + 1];
        count = 0;
    }

    public static void main(String[] args)
    {
        Heap h = new Heap(5);
        h.add(52);
        h.add(7);
        h.add(328);
        h.add(91);
        h.add(41);
        //        int a[]={17,67,5,3,9,8};
        h.sort(h.a, 5);
        h.print();
    }

    private void swap(int[] arr, int a, int b)
    {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private void heapify(int[] a, int length, int index)
    {
        while (true)
        {
            int maxPos = index;
            if (index * 2 <= length && a[index] < a[index * 2])
                maxPos = index * 2;
            if (index * 2 + 1 <= length && a[maxPos] < a[index * 2 + 1])
                maxPos = index * 2 + 1;
            if (index == maxPos)
                break;
            swap(a, maxPos, index);
            index = maxPos;
        }
    }

    public void add(int data)
    {
        if (count > maxSize)
            return;

        count++;
        a[count] = data;
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2])
        {
            swap(a, i, i / 2);
            i /= 2;
        }
    }

    public int removeMax()
    {
        if (count == 0)
            return 0;
        int res = a[1];
        a[1] = a[count];
        count--;
        heapify(a, count, 1);
        return res;
    }

    public void buildHeap(int[] arr, int count)
    {
        if (count == 0)
            return;
        for (int i = count / 2; i >= 1; i--)
            heapify(arr, count, i);
    }

    public void sort(int[] arr, int n)
    {
        buildHeap(arr, n);
        int k = n;
        while (k > 1)
        {
            swap(arr, 1, k);
            k--;
            heapify(arr, k, 1);
        }
    }

    public void print()
    {
        for (int i=1;i<=count;i++)
            System.out.println(a[i]);
    }
}
