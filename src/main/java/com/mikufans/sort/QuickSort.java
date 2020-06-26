package com.mikufans.sort;

public class QuickSort
{
    public static void main(String[] args)
    {
        Integer[] arr = new Integer[]{3, 5, 2, 1, 4, 6, 7};
        new QuickSort().sort(arr, 0, arr.length - 1);
        for (Integer integer : arr)
        {
            System.out.print(integer + " ");
        }
    }

    public void sort(Integer[] arr, int l, int r)
    {
        if (l >= r)
            return;
        int pos = quickSort(arr, l, r);
        sort(arr, l, pos - 1);
        sort(arr, pos + 1, r);
    }

    public int quickSort(Integer[] arr, int l, int r)
    {
        int i = l + 1, j = r, v = arr[l];
        while (i != j)
        {
            while (arr[j] >= arr[l] && i < j)
                j--;
            while (arr[i] <= arr[l] && i < j)
                i++;
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        arr[l] = arr[i];
        arr[i] = v;
        return i;
    }
}
