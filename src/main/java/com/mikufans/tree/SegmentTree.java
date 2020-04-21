package com.mikufans.tree;

import java.util.Scanner;

public class SegmentTree
{


    //1 x y k：将区间 [x, y][x,y] 内每个数加上 kk。
    //2 x y：输出区间 [x, y][x,y] 内每个数的和。
    static int a[] = new int[100000];
    static int ans[] = new int[100000];
    static int tag[] = new int[100000];

    static void build(int root, int l, int r)
    {
        tag[root] = 0;
        if (l == r)
        {
            ans[root] = a[l];
            return;
        }
        int mid = (l + r) / 2;
        build(root * 2, l, mid);
        build(root * 2 + 1, mid + 1, r);
        ans[root] = ans[root * 2] + ans[root * 2 + 1];
    }

    static void update(int root, int l, int r, int ql, int qr, int k)
    {
        if (ql <= l && qr >= r)
        {
            ans[root] += k * (r - l + 1);
            tag[root] += k;
            return;
        }
        push_down(root, l, r);
        int mid = (l + r) >> 1;
        if (ql <= mid)
            update(root << 1, l, mid, ql, qr, k);
        if (qr > mid)
            update(root << 1 | 1, mid + 1, r, ql, qr, k);
        ans[root] = ans[root << 1] + ans[root << 1 | 1];

    }

    static void push_down(int root, int l, int r)
    {
        int mid = (l + r) / 2;

        tag[root * 2] = tag[root * 2] + tag[root];
        tag[root * 2 + 1] = tag[root * 2 + 1] + tag[root];

        ans[root * 2] = ans[root * 2] + tag[root] * (mid - l + 1);
        ans[root * 2 + 1] = ans[root * 2 + 1] + tag[root] * (r - (mid + 1) + 1);

        tag[root] = 0;
    }

    static int query(int root, int l, int r, int ql, int qr)
    {
        int res = 0;
        if (ql <= l && qr >= r)
            return ans[root];
        int mid = (l + r) / 2;
        push_down(root, l, r);
        if (ql <= mid)
            res += query(root * 2, l, mid, ql, qr);
        if (qr > mid)
            res += query(root * 2 + 1, mid + 1, r, ql, qr);
        return res;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n, m, t;
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 1; i <= n; i++)
            a[i] = sc.nextInt();
        build(1, 1, n);
        int l, r, k;
        while (m-- != 0)
        {
            t = sc.nextInt();
            if (t == 1)
            {
                l = sc.nextInt();
                r = sc.nextInt();
                k = sc.nextInt();
                update(1, 1, n, l, r, k);
            } else
            {
                l = sc.nextInt();
                r = sc.nextInt();
                System.out.println(query(1, 1, n, l, r));
            }
        }
    }


    //    public static int tree[];
    //    public static int value[];
    //    public static int max = 0;
    //
    //    public static void main(String[] args)
    //    {
    //        Scanner sc = new Scanner(System.in);
    //        int n = sc.nextInt();
    //        tree = new int[10 * n];
    //        value = new int[n + 1];
    //        for (int i = 0; i < n; i++)
    //        {
    //            value[i] = sc.nextInt();
    //        }
    //        build(1, 0, n - 1);
    //
    //        int m = sc.nextInt();
    //        for (int i = 0; i < m; i++)
    //        {
    //            max = 0;
    //            int a = sc.nextInt();
    //            int b = sc.nextInt();
    //            query(1, 0, n - 1, a, b);
    //            System.out.println(max);
    //        }
    //    }
    //
    //    public static void build(int root, int l, int r)
    //    {
    //        if (l == r)
    //        {
    //            tree[root] = value[l];
    //            return;
    //        }
    //        int mid = (l + r) / 2;
    //        build(root * 2, l, mid);
    //        build(root * 2 + 1, mid + 1, r);
    //        tree[root] = Math.max(tree[root * 2], tree[root * 2 + 1]);
    //    }
    //
    //    public static void query(int root, int l, int r, int ql, int qr)
    //    {
    //        if (ql <= l && qr >= r)
    //        {
    //            max = Math.max(max, tree[root]);
    //            return;
    //        }
    //        int mid = (l + r) / 2;
    //        if (ql <= mid)
    //            query(root * 2, l, mid, ql, qr);
    //        if (qr > mid)
    //            query(root * 2 + 1, mid + 1, r, ql, qr);
    //    }

}
