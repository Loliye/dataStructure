package com.mikufans.sort;

public class BubbleSort
{
    private static void sort(Integer[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            int flag = 1;
            for (int j = 0; j < arr.length - i - 1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = 0;
                }
            }
            if (flag == 1)
                break;
        }
    }


    public static void main(String[] args)
    {
        Integer[] arr = new Integer[]{3, 5, 2, 1, 4, 6, 7};
        sort(arr);
        for (Integer integer : arr)
        {
            System.out.print(integer + " ");
        }
    }
}
