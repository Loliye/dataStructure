package com.mikufans.sort;

public class ChooseSort
{
    public static void sort(Integer[] arr)
    {
        int tmp;

        for (int i = 0; i < arr.length; i++)
        {
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[i] > arr[j])
                {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
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
