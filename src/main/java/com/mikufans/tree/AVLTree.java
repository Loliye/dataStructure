package com.mikufans.tree;


public class AVLTree<T extends Comparable<T>>
{
    private AVLTreeNode<T> root;

    public static void main(String[] args)
    {
        AVLTree<Integer> at = new AVLTree<>();
        at.insert(2);
        at.insert(1);
        at.insert(3);
        at.insert(4);
        at.insert(5);
        at.preorder(at.root);

        System.out.println("当前高度为：" + at.height());
    }

    private int height(AVLTreeNode<T> treeNode)
    {
        if (treeNode != null)
            return treeNode.height;
        return 0;
    }

    public int height()
    {
        return this.height(root);
    }

    private int max(int a, int b)
    {
        return a > b ? a : b;
    }

    private AVLTreeNode<T> llRotate(AVLTreeNode<T> origin)
    {
        AVLTreeNode<T> leftNode;

        leftNode = origin.leftNode;
        origin.leftNode = leftNode.rightNode;
        leftNode.rightNode = origin;

        origin.height = max(height(origin.leftNode), height(origin.rightNode)) + 1;
        leftNode.height = max(height(leftNode.leftNode), height(leftNode.rightNode)) + 1;
        return leftNode;
    }

    private AVLTreeNode<T> rrRotate(AVLTreeNode<T> origin)
    {
        AVLTreeNode<T> rightNode;

        rightNode = origin.rightNode;
        origin.rightNode = rightNode.leftNode;
        rightNode.leftNode = origin;

        origin.height = max(height(origin.leftNode), height(origin.rightNode)) + 1;
        rightNode.height = max(height(rightNode.rightNode), height(rightNode.leftNode)) + 1;
        return rightNode;
    }

    private AVLTreeNode<T> lrRotate(AVLTreeNode<T> origin)
    {
        origin.leftNode = rrRotate(origin.leftNode);
        return llRotate(origin);
    }

    private AVLTreeNode<T> rlRotate(AVLTreeNode<T> origin)
    {
        origin.rightNode = llRotate(origin.rightNode);
        return rrRotate(origin);
    }

    private AVLTreeNode<T> insert(AVLTreeNode<T> treeNode, T key)
    {
        if (treeNode == null)
            treeNode = new AVLTreeNode<>(key, null, null);
        else
        {
            int cmp = key.compareTo(treeNode.key);
            if (cmp < 0)
            {
                treeNode.leftNode = insert(treeNode.leftNode, key);
                if (height(treeNode.leftNode) - height(treeNode.rightNode) == 2)
                {
                    if (key.compareTo(treeNode.leftNode.key) < 0)
                        treeNode = llRotate(treeNode);
                    else treeNode = lrRotate(treeNode);
                }
            } else if (cmp > 0)
            {
                treeNode.rightNode = insert(treeNode.rightNode, key);
                if (height(treeNode.rightNode) - height(treeNode.leftNode) == 2)
                {
                    if (key.compareTo(treeNode.rightNode.key) > 0)
                    {
                        treeNode = rrRotate(treeNode);

                    } else treeNode = rlRotate(treeNode);
                }
            } else System.out.println("添加失败！！！已经存在相同得节点了");
        }
        treeNode.height = max(height(treeNode.rightNode), height(treeNode.leftNode)) + 1;
        return treeNode;
    }

    public void insert(T key)
    {
        root = insert(root, key);
    }

    public void print(AVLTreeNode<T> node)
    {
        System.out.println(node.key);
    }

    public void preorder(AVLTreeNode<T> node)
    {
        if (node == null)
            return;
        print(node);
        preorder(node.leftNode);
        preorder(node.rightNode);
    }

    public void inorder(AVLTreeNode<T> node)
    {
        if (node == null)
            return;
        inorder(node.leftNode);
        preorder(node);
        inorder(node.rightNode);
    }

    public void postorder(AVLTreeNode<T> node)
    {
        if (node == null)
            return;
        postorder(node.leftNode);
        postorder(node.rightNode);
        print(node);
    }

}

class AVLTreeNode<T extends Comparable<T>>
{
    T key;
    int height;
    AVLTreeNode<T> leftNode;
    AVLTreeNode<T> rightNode;

    public AVLTreeNode(T key, AVLTreeNode<T> leftNode, AVLTreeNode<T> rightNode)
    {
        this.key = key;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public AVLTreeNode()
    {
    }

    @Override
    public String toString()
    {
        return "AVLTreeNode{" +
                "key=" + key +
                ", height=" + height +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }
}
