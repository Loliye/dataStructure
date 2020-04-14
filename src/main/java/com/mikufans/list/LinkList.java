package com.mikufans.list;

public class LinkList<T extends Comparable<T>>
{
    private Node head = null;

    public static void main(String[] args)
    {
        LinkList<Integer> linkList = new LinkList<>();
        linkList.insert(1);
        linkList.insertToHead(7);
        linkList.insert(4);
        linkList.insert(3);
        linkList.insert(2);
        linkList.insertToHead(9);
        linkList.insert(5);
        linkList.print();
        linkList.reverse();
        linkList.print();
        //        linkList.mergeSort();
        //        linkList.print();
        linkList.head = linkList.quickSort(linkList.head);
        linkList.print();

    }

    public static boolean check(LinkList linkList)
    {
        Node tmp = linkList.head;
        Node fast = tmp.next;
        Node slow = tmp;
        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    /**
     * 小到大
     *
     * @param head
     * @return
     */
    public Node quickSort(Node head)
    {
        if (head == null || head.next == null)
            return head;

        Node ls = new Node(), rs = new Node();
        Node l = ls, r = rs, cur = head;
        while (cur != null)
        {
            int cmp = head.data.compareTo(cur.data);
            if (cmp > 0)
            {
                l.next = cur;
                l = l.next;
            } else
            {
                r.next = cur;
                r = r.next;
            }
            cur = cur.next;
        }
        l.next = rs.next;
        r.next = null;

        Node right = quickSort(head.next);
        head.next = null;
        Node left = quickSort(ls.next);

        cur = left;
        while (cur.next != null)
            cur = cur.next;

        cur.next = right;
        return left;
    }

    public void reverse()
    {
        Node headNode = null;
        Node pre = null;
        Node cur = head;
        while (cur != null)
        {
            Node next = cur.next;
            if (next == null)
                headNode = cur;

            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head = headNode;
    }

    public Node merge(Node alist, Node blist)
    {
        if (alist == null || blist == null)
            return null;

        Node p = alist;
        Node q = blist;
        Node head = null;
        int cmp = p.data.compareTo(q.data);
        if (cmp < 0)
        {
            head = p;
            p = p.next;
        } else
        {
            head = q;
            q = q.next;
        }

        Node r = head;
        while (p != null && q != null)
        {
            cmp = p.data.compareTo(q.data);
            if (cmp < 0)
            {
                r.next = p;
                p = p.next;
            } else
            {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }
        if (p != null)
            r.next = p;
        else r.next = q;
        return head;
    }

    /**
     * 当前链表并归排序
     *
     * @return
     */
    public Node mergeSort(Node head)
    {
        if (head.next == null)
            return head;

        Node fast = head.next;
        Node slow = head;
        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = slow.next;
        slow.next = null;

        //左表
        head = mergeSort(head);
        //右表
        fast = mergeSort(fast);

        Node newHead = merge(head, fast);
        return newHead;

    }

    public void mergeSort()
    {
        head = mergeSort(head);
    }

    public void insertToHead(T value)
    {
        Node newNode = new Node(value, null);
        if (head == null)
            head = newNode;
        else
        {
            newNode.next = head;
            this.head = newNode;
        }
    }

    public void insertAfter(T value, Node p)
    {
        Node newNode = new Node(value, null);
        if (p == null)
            return;
        newNode.next = p.next;
        p.next = newNode;
    }

    public void insert(T value)
    {


        if (head == null)
            head = new Node(value, null);
        else
        {
            Node tmp = head;
            while (tmp.next != null && tmp != null)
                tmp = tmp.next;
            tmp.next = new Node(value, null);
        }
    }

    public void deleteByValue(T value)
    {
        Node p = head;
        Node tmp = null;
        while (p != null && p.data != value)
        {
            tmp = p;
            p = p.next;
        }

        if (p == null)
            return;
        if (tmp == null)
            head = head.next;
        else tmp.next = p.next;
    }

    public Node findByValue(int value)
    {
        Node tmp = head;
        while (tmp != null && !tmp.data.equals(value))
        {
            tmp = tmp.next;
        }
        return tmp;
    }

    public Node findByIndex(int index)
    {
        Node tmp = head;
        while (--index != 0 && tmp != null)
            tmp = tmp.next;

        return tmp;
    }

    public void print()
    {
        Node p = head;
        while (p != null)
        {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println("\n-------------------");
    }
}

class Node<T extends Comparable<T>>
{
    public T data;
    public Node next;

    public Node() {}

    public Node(T data, Node next)
    {
        this.data = data;
        this.next = next;
    }

}
