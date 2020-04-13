package com.mikufans;

public class Index
{
    public static void main(String[] args)
    {
        int arr[]={2,4,3,1,5};
        Index index=new Index();
        index.quickSort(arr,0,4);
        for(int a:arr)
        System.out.println(a);
    }

    public void quickSort(int arr[], int l, int r)
    {
        if (l >= r)
            return;
        int pos = sort(arr, l, r);
        quickSort(arr, l, pos - 1);
        quickSort(arr, pos + 1, r);
    }

    public int sort(int arr[], int l, int r)
    {
        int cmp = arr[r];
        int pos = l;
        for (int i = l; i < r; i++)
        {
            if (arr[i] < cmp)
            {
                swap(arr, i, pos);
                pos++;
            }
        }
        arr[r] = arr[pos];
        arr[pos] = cmp;
        return pos;
    }

    public void swap(int arr[], int a, int b)
    {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }


}
