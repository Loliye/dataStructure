package com.mikufans.sort;

public class InsertSort
{
    public static void sort(Integer[] arr, int len)
    {
        if (len < 0)
            return;
        for (int i = 1; i < len; i++)
        {
            int tmp = arr[i];
            int j = i - 1;
            for (; j >= 0; j--)
            {
                if (arr[j] > tmp)
                {
                    arr[j + 1] = arr[j];
                } else break;
            }
            arr[j + 1] = tmp;
        }
    }

    public static void main(String[] args)
    {
        Integer[] arr = new Integer[]{3, 5, 2, 1, 4, 6, 7};
        sort(arr, arr.length);
        for (Integer integer : arr)
        {
            System.out.print(integer+" ");
        }
    }
}
