package com.mikufans.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree
{
    Node root;

    /**
     *   5
     * /   \
     * 2   6
     * \    \
     * 3    7
     * \
     * 4
     */
    public static void main(String[] args)
    {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insert(5);
        binaryTree.insert(2);
        binaryTree.insert(6);
        binaryTree.insert(7);
        binaryTree.insert(3);
        binaryTree.insert(4);
        System.out.println("----");

        System.out.println("前序遍历");
        binaryTree.preorder(binaryTree.root);


        System.out.println("中序遍历");
        binaryTree.inorder(binaryTree.root);

        System.out.println("后序遍历");
        binaryTree.postorder(binaryTree.root);


        System.out.println("层次遍历");
        binaryTree.translevel(binaryTree.root);

        System.out.println("深度");
        binaryTree.deep();
    }

    public void insert(int value)
    {
        Node newNode = new Node(value);
        if (this.root == null)
        {
            this.root = newNode;
            return;
        } else
        {
            Node tmp = this.root;
            Node parent = this.root;
            while (true)
            {
                if (tmp.value < value)
                {
                    parent = tmp;
                    tmp = tmp.right;
                    if (parent.right == null)
                    {
                        parent.right = newNode;
                        return;
                    }
                } else if (tmp.value > value)
                {
                    parent = tmp;
                    tmp = tmp.left;
                    if (parent.left == null)
                    {
                        parent.left = newNode;
                        return;
                    }
                } else
                {
                    System.out.println("已经存在相同得节点了！！！无需再插入");
                }
            }
        }
    }

    public void printNode(Node node)
    {
        System.out.println(node.value);
    }

    public void preorder(Node node)
    {
        if (node == null)
            return;
        printNode(node);
        preorder(node.left);
        preorder(node.right);
    }

    public void inorder(Node node)
    {
        if (node != null)
        {
            inorder(node.left);
            printNode(node);
            inorder(node.right);
        }
    }

    public void postorder(Node node)
    {
        if (node != null)
        {
            postorder(node.left);
            postorder(node.right);
            printNode(node);
        }
    }

    public int getHeight(Node node)
    {
        if (node == null)
            return 0;
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        return Math.max(left, right) + 1;
    }

    public void deep()
    {
        System.out.println(getHeight(root));
    }
    public void translevel(Node node)
    {
        Queue<Node> queue=new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty())
        {
            Node tmp=queue.element();
            queue.remove();
            if(tmp.left!=null)
                queue.offer(tmp.left);
            if(tmp.right!=null)
                queue.offer(tmp.right);
            System.out.println(tmp.value);
        }
    }
}

class Node
{
    int value;
    Node left;
    Node right;

    public Node(int value, Node left, Node right)
    {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Node(int value)
    {
        this.value = value;
        this.left = null;
        this.right = null;
    }


}
