package com.mikufans.tree;

import java.util.Scanner;

/*
操作 1： 格式：1 x y k 含义：将区间 [x,y][x,y] 内每个数乘上 kk

操作 2： 格式：2 x y k 含义：将区间 [x,y][x,y] 内每个数加上 kk

操作 3： 格式：3 x y 含义：输出区间 [x,y][x,y] 内每个数的和对 pp 取模所得的结果
 */
public class SegmentTree2
{
    Node[] st = new Node[10001 << 2];
    int[] a = new int[10001];
    int p;

    public SegmentTree2(int n)
    {
        for (int i = 0; i < n << 2; i++)
            st[i] = new Node();
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        SegmentTree2 demo = new SegmentTree2(n);
        demo.p = sc.nextInt();

        //        for (int i = 0; i < n; i++)
        //            st[i] = new Node();

        for (int i = 1; i <= n; i++)
            demo.a[i] = sc.nextInt();
        demo.build(1, 1, n);
        int l, r, k;
        while (m-- != 0)
        {
            int t = sc.nextInt();
            if (t == 1)
            {
                l = sc.nextInt();
                r = sc.nextInt();
                k = sc.nextInt();
                demo.update1(1, 1, n, l, r, k);
            } else if (t == 2)
            {
                l = sc.nextInt();
                r = sc.nextInt();
                k = sc.nextInt();
                demo.update2(1, 1, n, l, r, k);
            } else
            {
                l = sc.nextInt();
                r = sc.nextInt();
                System.out.println(demo.query(1, 1, n, l, r));
            }
        }
    }

    void build(int root, int l, int r)
    {
        st[root].mul = 1;
        st[root].add = 0;
        if (l == r)
        {
            st[root].v = a[l];
            st[root].v %= p;
            return;
        }
        int mid = (l + r) / 2;
        build(root * 2, l, mid);
        build(root * 2 + 1, mid + 1, r);
        st[root].v = st[root * 2].v + st[root * 2 + 1].v;
        st[root].v %= p;
    }

    void push_down(int root, int l, int r)
    {
        int mid = (l + r) / 2;
        st[root * 2].v = (st[root * 2].v * st[root].mul + st[root].add * (mid - l + 1)) % p;
        st[root * 2 + 1].v = (st[root * 2 + 1].v * st[root].mul + st[root].add * (r - (mid + 1) + 1)) % p;

        st[root * 2].mul = (st[root * 2].mul * st[root].mul) % p;
        st[root * 2 + 1].mul = (st[root * 2 + 1].mul * st[root].mul) % p;

        st[root * 2].add = (st[root * 2].add * st[root].mul + st[root].add) % p;
        st[root * 2 + 1].add = (st[root * 2 + 1].add * st[root].mul + st[root].add) % p;

        st[root].mul = 1;
        st[root].add = 0;
    }

    void update1(int root, int l, int r, int ql, int qr, int k)
    {
        if (l >= ql && r <= qr)
        {
            st[root].v = (st[root].v * k) % p;
            st[root].mul = (st[root].mul * k) % p;
            st[root].add = (st[root].add * k) % p;
            return;
        }
        push_down(root, l, r);
        int mid = (r + l) / 2;
        if (ql <= mid)
            update1(root * 2, l, mid, ql, qr, k);
        if (qr > mid)
            update1(root * 2 + 1, mid + 1, r, ql, qr, k);
        st[root].v = (st[root * 2].v + st[root * 2 + 1].v) % p;
    }

    void update2(int root, int l, int r, int ql, int qr, int k)
    {
        if (l >= ql && r <= qr)
        {
            st[root].add = (st[root].add + k) % p;
            st[root].v = (st[root].v + k * (r - l + 1)) % p;
            return;
        }
        push_down(root, l, r);
        int mid = (r + l) / 2;
        if (ql <= mid)
            update2(root * 2, l, mid, ql, qr, k);
        if (qr > mid)
            update2(root * 2 + 1, mid + 1, r, ql, qr, k);
        st[root].v = (st[root * 2].v + st[root * 2 + 1].v) % p;
    }

    int query(int root, int l, int r, int ql, int qr)
    {
        int res = 0;
        if (l >= ql && r <= qr)
            return st[root].v;
        push_down(root, l, r);
        int mid = (r + l) / 2;
        if (ql <= mid)
            res += query(root * 2, l, mid, ql, qr);
        if (qr > mid)
            res += query(root * 2 + 1, mid + 1, r, ql, qr);
        return res % p;
    }

    public class Node
    {
        public int v;
        public int mul;
        public int add;

        public Node()
        {
            v = 0;
            mul = 1;
            add = 0;
        }
    }
}
