package com.mikufans.list;


/**
 * 双向链表
 * @param <T>
 */
public class DLinkerList<T extends Comparable<T>>
{

    DNode start;
    DNode end;

    public DLinkerList()
    {
        this.start = null;
        this.end = null;
    }

    public static void main(String[] args)
    {
        DLinkerList<Integer> list = new DLinkerList<>();
        list.insertToHead(1);
        list.insertToHead(2);
        list.insertToTail(4);
        list.insertToTail(5);
        list.insertToHead(3);
        list.deleteFirst();
        //        list.insertToTail(4);
        list.print();
    }

    public void insertToHead(T data)
    {
        DNode node = new DNode(data);
        if (start == null)
            end = node;
        else
        {
            start.pre = node;
            node.next = start;
        }
        start = node;
    }

    public void insertToTail(T data)
    {
        DNode node = new DNode(data);
        if (start == null)
            start = node;
        else
        {
            end.next = node;
            node.pre = end;
        }
        end = node;
    }

    public boolean isEmpty()
    {
        return start == null;
    }

    public DNode deleteFirst()
    {
        if (start == null)
            throw new RuntimeException("数据不存在");

        DNode tmp = start;
        if (start.next == null)
        {
            end = null;
        } else
        {
            start.next.pre = null;
        }
        start = tmp.next;
        return tmp;
    }


    public void print()
    {
        StringBuffer result = new StringBuffer("[top=>");
        DNode tmp = start;
        while (tmp != null)
        {
            result.append(tmp.data + "=>");
            tmp = tmp.next;
        }
        result.append(" bottom]");
        System.out.println(result.toString());
    }
}

class DNode<T extends Comparable<T>>
{
    T data;
    DNode pre;
    DNode next;

    DNode(T data, DNode pre, DNode next)
    {
        this.data = data;
        this.pre = pre;
        this.next = next;
    }

    DNode(T data)
    {
        this.data = data;
    }

    DNode()
    {
    }
}
