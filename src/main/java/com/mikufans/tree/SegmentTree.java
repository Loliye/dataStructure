package com.mikufans.tree;

import java.util.Scanner;

public class SegmentTree
{
    public static int tree[];
    public static int value[];
    public static int max = 0;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        tree = new int[10 * n];
        value = new int[n + 1];
        for (int i = 0; i < n; i++)
        {
            value[i] = sc.nextInt();
        }
        build(1, 0, n - 1);

        int m = sc.nextInt();
        for (int i = 0; i < m; i++)
        {
            max = 0;
            int a = sc.nextInt();
            int b = sc.nextInt();
            query(1, 0, n - 1, a, b);
            System.out.println(max);
        }
    }

    public static void build(int root, int l, int r)
    {
        if (l == r)
        {
            tree[root] = value[l];
            return;
        }
        int mid = (l + r) / 2;
        build(root * 2, l, mid);
        build(root * 2 + 1, mid + 1, r);
        tree[root] = Math.max(tree[root * 2], tree[root * 2 + 1]);
    }

    public static void query(int root, int l, int r, int ql, int qr)
    {
        if (ql <= l && qr >= r)
        {
            max = Math.max(max, tree[root]);
            return;
        }
        int mid = (l + r) / 2;
        if (ql <= mid)
            query(root * 2, l, mid, ql, qr);
        if (qr > mid)
            query(root * 2 + 1, mid + 1, r, ql, qr);
    }

}
