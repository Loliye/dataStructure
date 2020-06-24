package com.mikufans.tree;

import javax.swing.plaf.basic.BasicTextAreaUI;
import java.util.LinkedList;


/**
 * 这里的B树，也就是英文中的B-Tree，一个 m 阶的B树满足以下条件：
 * <p>
 * 每个结点至多拥有m棵子树；
 * <p>
 * 根结点至少拥有两颗子树（存在子树的情况下），根结点至少有一个关键字；
 * <p>
 * 除了根结点以外，其余每个分支结点至少拥有 m/2 棵子树；
 * <p>
 * 所有的叶结点都在同一层上，B树的叶子结点可以看成是一种外部节点，不包含任何信息；
 * <p>
 * 有 k 棵子树的分支结点则存在 k-1 个关键码，关键码按照递增次序进行排列；
 * <p>
 * 关键字数量需要满足ceil(m/2)-1 <= n <= m-1；
 */
public class BTree
{
    //b树的阶级
    int M;

    //关键字
    LinkedList<Integer> values;

    //父节点
    BTree parent;

    //子树
    LinkedList<BTree> children;

    public BTree(int m)
    {
        values = new LinkedList<>();
        children = new LinkedList<>();
        if (m < 3)
            throw new RuntimeException("B-Tree : The order of B-Tree should be greater than 2.");
        M = m;
    }

    public BTree(BTree parent)
    {
        this(parent.M);
        this.parent = parent;
    }

    public static void main(String[] args)
    {
        BTree node = new BTree(3);
        node = node.insert(45);
        node = node.insert(24);
        node = node.insert(53);
        node = node.insert(90);
        node = node.insert(3);
        node = node.insert(12);
        node = node.insert(37);
        node = node.insert(50);
        node = node.insert(61);
        node = node.insert(70);
        node = node.insert(100);
        node.print();


        node = node.delete(61);
        System.out.println("-------------");
        node.print();
    }

    public boolean isEmpty()
    {
        if (values == null || values.size() == 0)
            return true;
        return false;
    }

    public boolean isRoot()
    {
        return parent == null;
    }

    public BTree getRoot()
    {
        BTree p = this;
        while (!p.isRoot())
            p = p.parent;
        return p;
    }

    /**
     * 查找当前B-Tree是否存在该节点
     *
     * @param target
     * @return
     */
    public BTree search(int target)
    {
        if (isEmpty())
            return this;

        int i = 0;
        for (; i < values.size() && values.get(i) <= target; i++)
        {
            if (values.get(i) == target)
            {
                return this;
            }
        }
        return children.get(i).search(target);
    }

    /**
     * 插入节点
     *
     * @param e
     * @return
     */
    public BTree insert(int e)
    {
        if (isEmpty())
        {
            values.add(e);
            children.add(new BTree(this));
            children.add(new BTree(this));
            return this;
        }
        BTree p = getRoot().search(e);
        if (!p.isEmpty())
        {
            throw new RuntimeException("cannot insert duplicate key to B-Tree, key: " + e);
        }
        insertNode(p.parent, e, new BTree(p.M));
        return getRoot();
    }

    /**
     * @param node      节点key超出M
     * @param e         插入的节点
     * @param rChildren 新产生的右子树
     */
    public void insertNode(BTree node, int e, BTree rChildren)
    {
        int i = 0;
        for (; i < node.values.size() && node.values.get(i) < e; i++) ;

        node.values.add(i, e);
        rChildren.parent = node;
        node.children.add(i + 1, rChildren);
        //key的数量超出M阶B-Tree的
        if (node.values.size() >= M)
        {
            int upI = M / 2;
            int up = node.values.get(upI);
            //上升中间关键字  左边的parent不变 右边parent放在上升关键字的右子树
            BTree rNode = new BTree(M);
            rNode.values = new LinkedList<>(node.values.subList(upI + 1, M));
            rNode.children = new LinkedList<>(node.children.subList(upI + 1, M + 1));
            //修改上升后子树的parent
            for (BTree child : rNode.children)
            {
                child.parent = rNode;
            }

            node.values = new LinkedList<>(node.values.subList(0, upI));
            node.children = new LinkedList<>(node.children.subList(0, upI + 1));
            // 从根节点中上升，选取上升关键字作为新的根节点
            if (node.parent == null)
            {
                node.parent = new BTree(M);
                node.parent.values.add(up);
                node.parent.children.add(node);
                node.parent.children.add(rNode);
                rNode.parent = node.parent;
                return;
            }
            insertNode(node.parent, up, rNode);
        }
    }

    public BTree delete(int e)
    {
        if (isEmpty())
            return this;

        BTree p = getRoot().search(e);
        if (p.isEmpty())
            throw new RuntimeException("the key to be deleted is not exist,key:" + e);

        int i = 0;
        for (; i < p.values.size() && p.values.get(i) < e; i++) ;

        if (!p.children.get(0).isEmpty())
        {
            BTree rMin = p.children.get(i);
            while (!rMin.children.get(rMin.children.size() - 1).isEmpty())
                rMin = rMin.children.get(0);

            p.values.set(i, rMin.values.get(0));
            return delete(rMin, i, 0);
        }
        return delete(p, i, 0);
    }


    /**
     * @param target
     * @param index
     * @param childIndex
     * @return
     */
    public BTree delete(BTree target, int index, int childIndex)
    {
        target.values.remove(index);
        target.children.remove(childIndex);
        //最少两个子节点都为null
        if (target.children.size() >= Math.ceil(M / 2.0))
        {
            return target.getRoot();
        }
        if (target.isRoot())
        {
            if (target.children.size() > 1)
                return target;
            else
            {
                BTree newRoot = target.children.get(0);
                newRoot.parent = null;
                return newRoot;
            }
        }

        int parentChildIndex = 0;
        while (parentChildIndex < target.parent.children.size() && target.parent.children.get(parentChildIndex) != target)
        {
            parentChildIndex++;
        }
        if (parentChildIndex > 0 && target.parent.children.get(parentChildIndex - 1).values.size() >= Math.ceil(M / 2.0))
        {

            /**
             * 左兄弟关键字数大于 ceil(M/2)-1
             * M=3 删除节点 5
             *    3
             *  /   \
             *1 2    5
             *
             *    2
             *  /   \
             * 1     3
             */
            int downKey = target.parent.values.get(parentChildIndex - 1);
            BTree leftSibling = target.parent.children.get(parentChildIndex - 1);
            int upKey = leftSibling.values.remove(leftSibling.values.size() - 1);
            BTree mergeChild = leftSibling.children.remove(leftSibling.children.size() - 1);
            System.out.println("左兄弟关键字数大于 ceil(M/2)-1:" + downKey + " " + upKey);
            target.values.add(0, downKey);
            target.children.add(0, mergeChild);
            target.parent.values.set(parentChildIndex - 1, upKey);
            return target.getRoot();
        } else if (parentChildIndex < target.parent.children.size() - 1 &&
                target.parent.children.get(parentChildIndex + 1).values.size() >= Math.ceil(M / 2.0))
        {
            /**
             *右兄弟关键字数大于 ceil(M/2)-1
             *M=3 删除节点 1
             *    3
             *  /   \
             * 1    4 5
             *
             *    4
             *  /   \
             * 3     5
             */
            int downKey = target.parent.values.get(parentChildIndex);
            BTree rightSibling = target.parent.children.get(parentChildIndex + 1);
            int upKey = rightSibling.values.remove(0);
            System.out.println("右兄弟关键字数大于 ceil(M/2)-1:" + downKey + " " + upKey);
            BTree mergeChild = rightSibling.children.remove(0);
            target.values.add(downKey);
            target.children.add(mergeChild);
            target.parent.values.set(parentChildIndex, upKey);
            return target.getRoot();
        } else
        {
            // 左右兄弟关键字数都不大于 ceil(M/2)-1

            /**
             *
             * 删除C节点
             *                      D
             *                 /         \
             *                B         F  H
             *              /   \      /  / \
             *             A     C    E  G   L
             *
             *                      D
             *                 /         \
             *                B         F  H
             *              /          /  / \
             *             A          E  G   L
             *
             *
             *
             *                      D
             *                 /         \
             *                          F  H
             *              /          /  / \
             *             A B        E  G   L
             *
             *
             *
             *                      F
             *                 /         \
             *               D             H
             *              /          /  / \
             *             A B        E  G   L
             *
             *
             *
             *                      F
             *                 /         \
             *               D            H
             *              /  \         / \
             *            A B   E       G   L
             */


            int parentValueIndex;
            if (parentChildIndex > 0)
            {
                // 如果有左兄弟，和左兄弟合并
                BTree leftSibling = target.parent.children.get(parentChildIndex - 1);
                // 加上父节点关键字
                parentValueIndex = parentChildIndex - 1;
                int downKey = target.parent.values.get(parentValueIndex);
                System.out.println("如果有左兄弟，和左兄弟合并:" + downKey);
                leftSibling.values.add(downKey);
                // 加上目标节点的剩余信息
                leftSibling.values.addAll(target.values);
                target.children.forEach(c -> c.parent = leftSibling);
                leftSibling.children.addAll(target.children);
            } else
            {
                // 没有左兄弟和右兄弟合并
                BTree rightSibling = target.parent.children.get(parentChildIndex + 1);
                // 加上父节点关键字
                parentValueIndex = parentChildIndex;
                int downKey = target.parent.values.get(parentValueIndex);
                System.out.println("没有左兄弟和右兄弟合并:" + downKey);
                rightSibling.values.add(0, downKey);
                // 加上目标节点的剩余信息
                rightSibling.values.addAll(0, target.values);
                target.children.forEach(c -> c.parent = rightSibling);
                rightSibling.children.addAll(0, target.children);
            }
            // 递归删除父节点关键字和孩子
            return delete(target.parent, parentValueIndex, parentChildIndex);
        }


    }


    public void print()
    {
        print(this, 0);
    }

    private void print(BTree node, int depth)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < depth; i++)
        {
            sb.append("|    ");
        }
        if (depth > 0)
        {
            sb.append("|----");
        }
        sb.append(node.values);
        System.out.println(sb.toString());
        for (BTree child : node.children)
        {
            print(child, depth + 1);
        }
    }


}
