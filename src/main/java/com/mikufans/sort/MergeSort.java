package com.mikufans.sort;

public class MergeSort
{

    public static void main(String[] args)
    {
        Integer[] arr = new Integer[]{3, 5, 2, 1, 4, 6, 7};
        new MergeSort().sort(arr, 0, arr.length - 1);
        for (Integer integer : arr)
        {
            System.out.print(integer + " ");
        }
    }

    public void sort(Integer[] arr, int l, int r)
    {
        if (l >= r)
            return;

        int mid = (l + r) >> 1;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        mergeSort(arr, l, r);
    }

    public void mergeSort(Integer[] arr, int l, int r)
    {
        Integer[] tmp = new Integer[arr.length];
        int mid = (l + r) >> 1;
        int i = l, m = mid + 1;
        int pos = l;
        while (i <= mid && m <= r)
        {
            if (arr[i] <= arr[m])
                tmp[pos++] = arr[i++];
            else tmp[pos++] = arr[m++];
        }
        while (i <= mid)
            tmp[pos++] = arr[i++];
        while (m <= r)
            tmp[pos++] = arr[m++];

        for (int j = l; j <= r; j++)
            arr[j] = tmp[j];

    }
}
