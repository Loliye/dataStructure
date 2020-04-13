package com.mikufans.stack;

import org.w3c.dom.stylesheets.LinkStyle;

public class LinkStack<T>
{
    public Node top;
    public int size = 0;

    public LinkStack()
    {
        top = new Node();
    }

    public static void main(String[] args) throws Exception
    {
        LinkStack<Integer> linkStack = new LinkStack<>();
        linkStack.push(1);
        linkStack.push(2);
        linkStack.push(3);
        linkStack.pop();
        System.out.println(linkStack.peek());
        linkStack.print();

    }

    public void push(T data)
    {
        Node newNode = new Node(data);
        if (top.next == null)
            top.next = newNode;
        else
        {
            Node tmp = top.next;
            top.next = newNode;
            newNode.next = tmp;
        }
        size++;
    }

    public T peek()
    {
        return (T) top.next.data;
    }

    public T pop() throws Exception
    {
        if (top.next == null)
            throw new Exception("stack is null");
        Node tmp = top.next;
        top.next = top.next.next;
        size--;
        return (T) tmp.data;
    }

    public void print()
    {
        StringBuffer result = new StringBuffer("[top=>");
        Node tmp = top.next;
        for (int i = 0; i < size; i++)
        {
            result.append(tmp.data + "=>");
            tmp = tmp.next;
        }
        result.append(" bottom]");
        System.out.println(result.toString());
    }

}

class Node<T>
{
    public T data;
    public Node next;

    public Node() {}

    public Node(T data)
    {
        this.data = data;
    }
}
